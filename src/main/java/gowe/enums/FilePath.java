package gowe.enums;

/**
 * Enum representing file paths for different types of files.
 * 
 * @author Gowtham E
 */
public enum FilePath {
    SCREENSHOTS("src/test/resources/screenShots/"),
    REPORTS("src/test/resources/reports/"),
    LOGS("logs/");

    private final String relativePath;

    // Constructor to initialize the relative file path
    FilePath(String relativePath) {
        this.relativePath = relativePath;
    }

    // Method to get the complete file path based on the current working directory
    public String getPath() {
        // Get the current working directory
        String currentDir = System.getProperty("user.dir");
        return currentDir + "/" + relativePath;
    }
}
