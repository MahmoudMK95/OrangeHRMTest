package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class DataUtil {

    private static final String TEST_DATA_PATH = "src/test/resources/TestData/";

    private static final String JSON_DATA_PATH = "src/test/java/APIRequest/";

    public static String getPropertyValue (String fileName, String key) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(TEST_DATA_PATH + fileName +".properties"));
        return properties.getProperty(key);
    }

    public static String getJsonFile(String fileName) {
        try {
            // Read entire file as a String
            return new String(Files.readAllBytes(Paths.get(JSON_DATA_PATH + fileName + ".json")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
