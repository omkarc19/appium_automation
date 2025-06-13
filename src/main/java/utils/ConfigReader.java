package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	 private static Properties properties;
	 static String userHome = System.getProperty("user.home");

	    private static final String CONFIG_FILE_PATH = "src/main/java/config/emulator.properties"; // Adjust path as needed

	     static {
	        try (InputStream input = new FileInputStream(CONFIG_FILE_PATH)) {
	            properties = new Properties();
	            properties.load(input);
	        } catch (IOException ex) {
	            System.err.println("Error loading configuration file: " + CONFIG_FILE_PATH);
	            ex.printStackTrace();
	            throw new RuntimeException("Failed to load emulator.properties. Please ensure the file exists at " + CONFIG_FILE_PATH, ex);
	        }
	    }

	    /**
	     * Retrieves a property value from the configuration file.
	     * @param key The key of the property to retrieve.
	     * @return The value of the property, or null if the key is not found.
	     */
	    public static String getProperty(String key) {
	        return properties.getProperty(key);
	    }

	    /**
	     * Retrieves a property value from the configuration file, with a default value.
	     * @param key The key of the property to retrieve.
	     * @param defaultValue The default value to return if the key is not found.
	     * @return The value of the property, or the default value if the key is not found.
	     */
	    public static String getProperty(String key, String defaultValue) {
	        return properties.getProperty(key, defaultValue);
	    }
}
