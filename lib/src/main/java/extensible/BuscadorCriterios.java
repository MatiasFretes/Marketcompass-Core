package extensible;

import java.util.Set;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collections;
import java.util.HashSet;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class BuscadorCriterios {
	
    @SuppressWarnings("resource")
	public Set<FiltradorPorCriterio> buscar(String ubicacion) throws Exception {
        Set<FiltradorPorCriterio> implementacionesCriterios = new HashSet<>();
        File archivo = new File(ubicacion);
        
        if (!archivo.exists() || !archivo.isFile() || !ubicacion.endsWith(".jar")) 
            throw new IllegalArgumentException("El archivo no es un archivo JAR válido: " + ubicacion);
       
        URL url = archivo.toURI().toURL();
        URLClassLoader classLoader = new URLClassLoader(new URL[]{url});

        JarFile jar = new JarFile(archivo);
        for (JarEntry entry : Collections.list(jar.entries())) {
        	if (!entry.getName().endsWith(".class")) continue;

            String className = entry.getName().replace("/", ".").replace(".class", "");
            Class<?> cls = classLoader.loadClass(className);

            if(!FiltradorPorCriterio.class.isAssignableFrom(cls))
               throw new RuntimeException("La clase encontrada no es asignable a un FiltradorPorCriterio");

            FiltradorPorCriterio criterioEncontrado = (FiltradorPorCriterio) cls.getDeclaredConstructor().newInstance();
            implementacionesCriterios.add(criterioEncontrado);
        }
        classLoader.close();
        
        return implementacionesCriterios;
    }
}
