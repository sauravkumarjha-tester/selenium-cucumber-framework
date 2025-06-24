package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    private static final String CONFIG_FILE_PATH = "src/test/resources/config/config.properties";

    public static void loadProperties() throws IOException {
        properties = new Properties();
        FileInputStream fis = new FileInputStream(CONFIG_FILE_PATH);
        properties.load(fis);
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
