package gowe.utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * PropertyReader is a utility class for reading properties from a properties file.
 * <p>
 * This class provides methods to load properties, retrieve values by key,
 * check if a key exists, and get the total number of properties. 
 * It also allows reloading of the properties file if needed.
 * </p>
 * 
 * Author: Gowtham E
 * Date: 2024-09-29
 */
public class PropertyReader {

    private Properties properties = new Properties();

    /**
     * Constructor to load the properties file.
     *
     * @param filePath the path to the properties file to be loaded.
     */
    public PropertyReader(String filePath) {
        try (InputStream input = new FileInputStream(filePath)) {
            // Load the properties file
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to get a property value by key.
     *
     * @param key the key of the property to retrieve.
     * @return the value associated with the specified key, or null if the key does not exist.
     */
    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    /**
     * Method to get a property value by key with a default value if the key is not found.
     *
     * @param key the key of the property to retrieve.
     * @param defaultValue the value to return if the specified key does not exist.
     * @return the value associated with the specified key, or defaultValue if the key does not exist.
     */
    public String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    /**
     * Method to get all properties as a formatted string.
     *
     * @return a string representation of all properties in the format "key=value".
     */
    public String getAllProperties() {
        StringBuilder sb = new StringBuilder();
        properties.forEach((key, value) -> sb.append(key).append("=").append(value).append("\n"));
        return sb.toString();
    }

    /**
     * Method to check if a particular key exists in the properties.
     *
     * @param key the key to check for existence.
     * @return true if the key exists, false otherwise.
     */
    public boolean containsKey(String key) {
        return properties.containsKey(key);
    }

    /**
     * Method to get the number of properties loaded.
     *
     * @return the number of properties in the properties file.
     */
    public int getPropertyCount() {
        return properties.size();
    }

    /**
     * Method to reload the properties file.
     *
     * @param filePath the path to the properties file to be loaded again.
     */
    public void reloadProperties(String filePath) {
        try (InputStream input = new FileInputStream(filePath)) {
            properties.clear(); // Clear existing properties
            properties.load(input); // Load properties from the new file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
