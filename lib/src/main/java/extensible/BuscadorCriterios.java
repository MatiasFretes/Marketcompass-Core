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
	public Set<FiltradorPorCriterio> buscar(String path) throws Exception {
        Set<FiltradorPorCriterio> result = new HashSet<>();
        File jarFile = new File(path);

        if (!jarFile.exists() || !jarFile.isFile()) {
            throw new IllegalArgumentException("La ubicación no es un archivo JAR válido: " + path);
        }
        
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
        
        return result;
    }
}
