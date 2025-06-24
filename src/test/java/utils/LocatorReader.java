package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LocatorReader {
    private static Properties properties;

    private static final String LOCATOR_FILE_PATH = "src/test/resources/locator/locator.properties";

    public static void loadLocatorProperties() throws IOException {
        properties = new Properties();
        FileInputStream fis = new FileInputStream(LOCATOR_FILE_PATH);
        properties.load(fis);
    }

    public static String getLocatorProperty(String key) {
        return properties.getProperty(key);
    }
}
