package utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class TestProperty {
    private static TestProperty instance = null;
    private static Properties properties;
    public static TestProperty getInstance() {
        if (instance == null) {
            instance = new TestProperty();
        }
        return instance;
    }

    public void loadProperties(String filePath) {
        properties = new Properties();
        Properties newProperties = new Properties();
        try {
            newProperties.load(Files.newBufferedReader(Paths.get(filePath)));
            properties.putAll(newProperties);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
