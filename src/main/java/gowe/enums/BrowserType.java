package gowe.enums;

/**
 * Enum representing different browser types.
 * 
 * @author Gowtham E
 */
public enum BrowserType {
    CHROME("chrome"),
    FIREFOX("firefox"),
    EDGE("edge"),
    SAFARI("safari");

    private final String browserName;

    // Constructor to initialize the browser name
    BrowserType(String browserName) {
        this.browserName = browserName;
    }

    // Method to get the browser name
    public String getBrowserName() {
        return browserName;
    }
}
