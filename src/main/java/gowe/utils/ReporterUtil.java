package gowe.utils;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import gowe.enums.FilePath;

import java.nio.file.Files;

public class ReporterUtil {

    private ExtentReports extentReports;
    private ExtentTest testCase;
    private WebDriver driver;  // The WebDriver instance will be set by BasePage

    /**
     * Initializes the Extent Reports with the specified test suite name.
     *
     * @param testSuiteName The name of the test suite for which the report is generated.
     */
    public void initializeReport(String testSuiteName) {
        String reportFilePath = FilePath.REPORTS.getPath() + testSuiteName + "_" + getTimeStamp() + ".html";

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportFilePath);
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setDocumentTitle("Execution Results for " + testSuiteName + " - " + getTimeStamp());
        sparkReporter.config().setTimelineEnabled(true);
        sparkReporter.config().setTimeStampFormat("MM-dd-yyyy hh:mm:ss");

        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        extentReports.setSystemInfo("Execution Date", getDateTimeInFormat(new Date(), "MM-dd-yyyy hh:mm"));
        extentReports.setSystemInfo("User Name", System.getProperty("user.name"));

        try {
            InetAddress ip = InetAddress.getLocalHost();
            extentReports.setSystemInfo("IP Address", ip.getHostAddress());
            extentReports.setSystemInfo("Local Host Name", ip.getHostName());
        } catch (Exception e) {
            System.err.println("Unable to fetch IP address: " + e.getMessage());
        }
    }

    /**
     * Adds a new test case to the report.
     *
     * @param testCaseName The name of the test case.
     */
    public void addTest(String testCaseName) {
        testCase = extentReports.createTest(testCaseName);
    }

    /**
     * Logs a message in the report with the specified status.
     *
     * @param status    The status of the log entry (PASS, FAIL, etc.).
     * @param stepInfo  The information to log.
     */
    public void writeLogWithoutScreenshot(Status status, String stepInfo) {
        testCase.log(status, stepInfo);
    }

    /**
     * Logs a message along with a screenshot in the report.
     *
     * @param status        The status of the log entry (PASS, FAIL, etc.).
     * @param stepInfo      The information to log.
     * @param screenshotName The name for the screenshot file.
     */
    public void writeLog(Status status, String stepInfo, String screenshotName) {
        String screenshotPath = FilePath.SCREENSHOTS.getPath() + screenshotName + "_" + getTimeStamp() + ".png";
        testCase.log(status, stepInfo, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }

    /**
     * Logs a message with a screenshot.
     *
     * @param status    The status of the log entry (PASS, FAIL, etc.).
     * @param stepInfo  The information to log.
     */
    public void writeLogWithScreenshot(Status status, String stepInfo) {
        String screenshotName = "screenshot"; // You can modify this to a desired name or parameterize it
        takeScreenshot(screenshotName);
        writeLog(status, stepInfo, screenshotName);
    }

    /**
     * Finalizes the report and writes it to the specified location.
     */
    public void finalizeReport() {
        extentReports.flush();
    }

    /**
     * Takes a screenshot and saves it to the specified location.
     *
     * @param screenshotName The name for the screenshot file.
     */
    public void takeScreenshot(String screenshotName) {
        try {
            // Cast the driver to TakesScreenshot
            TakesScreenshot screenshot = (TakesScreenshot) driver;

            // Capture the screenshot as a file
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

            // Create a unique filename using the screenshot name and current timestamp
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String screenshotFileName = screenshotName + "_" + timestamp + ".png";

            // Define the destination for the screenshot
            File destFile = new File(FilePath.SCREENSHOTS.getPath() + screenshotFileName);

            // Copy the screenshot to the destination
            Files.copy(srcFile.toPath(), destFile.toPath());

            // Print the file path of the saved screenshot
            System.out.println("Screenshot saved at: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            // Handle IO exceptions that may occur during file operations
            System.err.println("Error while saving screenshot: " + e.getMessage());
        } catch (WebDriverException e) {
            // Handle exceptions related to the WebDriver
            System.err.println("WebDriverException while taking screenshot: " + e.getMessage());
        }
    }

    // Utility methods
    private String getTimeStamp() {
        return new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    }

    private String getDateTimeInFormat(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }

    // Method to set the WebDriver instance
    public void setWebDriver(WebDriver driver) {
        this.driver = driver;
    }
}
