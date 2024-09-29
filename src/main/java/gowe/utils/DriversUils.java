package gowe.utils;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;


public class DriversUils {

	/**
	 * Returns a WebDriver instance based on the specified browser name.
	 *
	 * This method sets up a WebDriver instance for the desired browser and includes
	 * browser-specific options such as maximizing the browser window and allowing
	 * remote origins.
	 *
	 * Supported browsers:
	 * - Chrome: Initializes a ChromeDriver with options to maximize the window and
	 *   allow remote origins.
	 * - Edge: Initializes an EdgeDriver with options to maximize the window and
	 *   allow remote origins.
	 * - Firefox: Initializes a FirefoxDriver with options to maximize the window
	 *   and allow remote origins.
	 * - Safari: Initializes a SafariDriver (Safari does not require special options
	 *   as the others do).
	 *
	 * The method returns null if an unsupported browser name is provided.
	 *
	 * @param browserName The name of the browser for which the WebDriver instance
	 *                    is required. Supported values: "chrome", "edge", "firefox", "safari".
	 * @return WebDriver instance for the specified browser, or null if the browser is unsupported.
	 * 
	 * @author Gowtham E
	 */


	public static WebDriver getWebDriver(String browserName) {
		WebDriver driver = null;

		switch (browserName.toLowerCase()) {
		case "chrome": 

			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--start-maximized");
			chromeOptions.addArguments("--remote-allow-origins=*");

			driver = new ChromeDriver(chromeOptions);
			break;
		case "edge":
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.addArguments("--start-maximized");

			edgeOptions.addArguments("--remote-allow-origins=*");
			driver = new EdgeDriver(edgeOptions);

			break;
		case "firefox":
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addArguments("--start-maximized");
			firefoxOptions.addArguments("--remote-allow-origins=*");

			driver = new FirefoxDriver(firefoxOptions);
			break;
		case "safari":
			driver = new SafariDriver(); // Safari options are typically handled differently
			break;
		default:
			System.out.println("Unsupported browser: " + browserName);
			break;
		}

		// Set implicit wait time for all browser instances
		// 10 seconds implicit wait

		if (driver != null) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		}


		return driver;
	}


	/**
	 * Safely quits the WebDriver instance.
	 *
	 * This method checks if the WebDriver instance is not null before calling
	 * the `quit()` method to gracefully close all browser windows and terminate
	 * the WebDriver session. If the driver is null, it prints an appropriate
	 * message. Additionally, any exceptions that occur during quitting are
	 * caught and logged.
	 *
	 * @param driver The WebDriver instance to be quit. If null, a message will be
	 *               printed and no action will be taken.
	 * 
	 * @author Gowtham E
	 */


	public static void quit(WebDriver driver ) {
		try {
			if (driver != null) {
				driver.quit();
				System.out.println("WebDriver instance quit successfully.");
			} else {
				System.out.println("WebDriver instance is null. Cannot quit.");
			}
		} catch (Exception e) {
			System.err.println("Error while quitting WebDriver: " + e.getMessage());
		}
	}


	/**
	 * Safely closes the current window of the WebDriver instance.
	 *
	 * This method checks if the WebDriver instance is not null before calling
	 * the `close()` method to close the current browser window. If the driver is null,
	 * it prints an appropriate message. Any exceptions that occur during closing
	 * are caught and logged.
	 *
	 * @param driver The WebDriver instance whose current window is to be closed. If null,
	 *               a message will be printed and no action will be taken.
	 * 
	 * @author Gowtham E
	 */


	public void close(WebDriver driver) {
		try {
			if (driver != null) {
				driver.close();
				System.out.println("Current window closed successfully.");
			} else {
				System.out.println("WebDriver instance is null. Cannot close window.");
			}
		} catch (Exception e) {
			System.err.println("Error while closing window: " + e.getMessage());
		}
	}


}
