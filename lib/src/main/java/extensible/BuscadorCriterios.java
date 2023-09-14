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
	Set<FiltradorPorCriterio> buscar(String path) {
        Set<FiltradorPorCriterio> result = new HashSet<>();
        try {
            File jarFile = new File(path);

            URL url = jarFile.toURI().toURL();
            URLClassLoader classLoader = new URLClassLoader(new URL[]{url});

            JarFile jar = new JarFile(jarFile);
            for (JarEntry entry : Collections.list(jar.entries())) {
            	if (!entry.getName().endsWith(".class")) continue;

                String className = entry.getName().replace("/", ".").replace(".class", "");
                Class<?> cls = classLoader.loadClass(className);

                if(!FiltradorPorCriterio.class.isAssignableFrom(cls))
                   throw new RuntimeException("La clase encontrada no es asignable a un FiltradorPorCriterio");

                FiltradorPorCriterio criterioEncontrado = (FiltradorPorCriterio) cls.getDeclaredConstructor().newInstance();
                result.add(criterioEncontrado);
            }
            classLoader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

//    public static void main(String[] args) {
//    	BuscadorCriterios discovery = new BuscadorCriterios();
//        Set<FiltradorPorCriterio> classes = discovery.buscar("C:/Users/Matias/Proyectos/DistanciaProject/DistanciaProject/lib/build/libs/lib.jar");
//
//        for (FiltradorPorCriterio obj : classes) {
//        	FiltradorPorCriterio criterio = (FiltradorPorCriterio) obj;
//            String message = criterio.filtrar();
//            System.out.println(message);
//        }
//    }
}
