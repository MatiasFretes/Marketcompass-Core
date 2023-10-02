package configuracion;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfiguracionRutas {

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

    public static String getRutaJsonMercados() {
        return properties.getProperty("rutaJsonMercados");
    }
    
    public static String getRutaExtensionJAR() {
        return properties.getProperty("rutaExtensionJAR");
    }
}