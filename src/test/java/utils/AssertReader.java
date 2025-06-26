package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AssertReader {

    private static Properties properties;
    
    private static final String FILE_PATH = "src/test/resources/assert/";
  
    public static void loadAssertReader(String fileName) throws IOException {
        properties = new Properties();
        FileInputStream fis = new FileInputStream(FILE_PATH + fileName + ".properties");
        properties.load(fis);
    }

    public static String getAssertProperties(String key) {
        return properties.getProperty(key);
    }

}
