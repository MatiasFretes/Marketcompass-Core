package extensible;

import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class BuscadorCriterio {
	
	public List<String> mercados;
	
	public BuscadorCriterio(List<String> mercados) {
		this.mercados = mercados;
	}
	    
    @SuppressWarnings("resource")
    public Set<SeleccionadorPorCriterio> buscar(String carpeta) throws Exception {
        Set<SeleccionadorPorCriterio> implementacionesCriterios = new HashSet<>();
        File carpetaFile = new File(carpeta);

        if (!carpetaFile.exists())
            throw new FileNotFoundException("La carpeta no existe: " + carpeta);
        
        if (!carpetaFile.isDirectory()) 
            throw new IllegalArgumentException("La carpeta no existe: " + carpeta);
        

        File[] archivos = carpetaFile.listFiles((dir, name) -> name.toLowerCase().endsWith(".jar"));

        if (archivos == null || archivos.length == 0) {
        	return implementacionesCriterios;
        }

        for (File archivo : archivos) {
            URL url = archivo.toURI().toURL();
            URLClassLoader classLoader = new URLClassLoader(new URL[]{url});

            JarFile jar = new JarFile(archivo);
            for (JarEntry entry : Collections.list(jar.entries())) {
                if (!entry.getName().endsWith(".class")) continue;

                String className = entry.getName().replace("/", ".").replace(".class", "");
                Class<?> cls = classLoader.loadClass(className);

                if (!SeleccionadorPorCriterio.class.isAssignableFrom(cls))
                    continue;

                SeleccionadorPorCriterio criterioEncontrado = (SeleccionadorPorCriterio) cls.getDeclaredConstructor(List.class).newInstance(this.mercados);
                implementacionesCriterios.add(criterioEncontrado);
            }

            classLoader.close();
        }

        return implementacionesCriterios;
    }

}
