package configuracion;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfiguracionRuta {
	
	private static Properties properties = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("config.properties");
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String obtenerDirectorio() {
        return properties.getProperty("rutaExtensionJAR");
    }
}
