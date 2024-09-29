package gowe.testCases;

import gowe.enums.FilePath;
import gowe.utils.DriversUils;
import gowe.utils.FileUtils;
import gowe.utils.ReporterUtil;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BasePage {

    protected WebDriver driver;
    protected ReporterUtil reporter;

    /**
     * Sets up the WebDriver before each test method.
     *
     * This method will be automatically called before each test.
     *
     * @param browser The name of the browser to be launched.
     */
    @Parameters({"browser"})
    @BeforeClass
    public void setUp(String browser) {
    	FileUtils.deleteFilesInFolder(FilePath.SCREENSHOTS.getPath());
    	FileUtils.deleteFilesInFolder(FilePath.REPORTS.getPath());
        // Initialize the WebDriver instance based on the specified browser
        driver = DriversUils.getWebDriver(browser);
        
        // Initialize the reporter and set the WebDriver
        reporter = new ReporterUtil();
        reporter.setWebDriver(driver);
        reporter.initializeReport("SampleTestSuite");  // Adjust the suite name as necessary
    }

    /**
     * Closes the WebDriver after each test method.
     *
     * This method will be automatically called after each test.
     */
    @AfterClass
    public void tearDown() {
        // Safely quit the WebDriver instance
        DriversUils.quit(driver);
        reporter.finalizeReport();  // Finalize the report after each test
    }
}
