package utilities;

import utilities.TestProperty;
public class TestInitializer {
    public static void setUp() {
        TestProperty config = TestProperty.getInstance();
        // Load the properties file before any tests run
        config.loadProperties("src/test/resources/Config/config.properties");
    }
}
