package packageOne;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class ClassOne {

	
	public static void main(String[] args) {
	       ChromeOptions options = new ChromeOptions();
//	        options.setHeadless(true);  // Enable headless mode
//	        options.addArguments("--headless");
	        options.addArguments("--start-maximized"); // Start browser maximized
	        options.addArguments("--remote-allow-origins=*"); // Allow cross-origin communication



	        // Additional options (feel free to customize)
	        options.addArguments("--start-maximized");  // Start browser maximized
	        options.addArguments("--remote-allow-origins=*");  // Allow cross-origin communication

	        // Create a new ChromeDriver instance
	        WebDriver driver = new ChromeDriver(options);

	        // Navigate to Google
	        driver.get("https://www.google.com"); // Use the full URL

	        // Perform your test actions here (example: get the title)
	        String title = driver.getTitle();
	        System.out.println("Page title: " + title);

	        // Close the browser
	        driver.quit();
		
	}
}
