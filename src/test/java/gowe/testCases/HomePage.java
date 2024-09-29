package gowe.testCases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import gowe.utils.SleepUtil;

public class HomePage extends BasePage {
    
	@Test
    public void TC_01() {
        reporter.addTest("TC_01");
        try {
            driver.get(propertyReader.getProperty("url"));
            SleepUtil.sleepFor10Seconds();
            reporter.writeLogWithoutScreenshot(Status.INFO, "Navigated to OrangeHRM login page");
        } catch (Exception e) {
            reporter.writeLogWithoutScreenshot(Status.FAIL, "Test TC_01 failed: " + e.getMessage());
        }
    }

    @Test
    public void TC_02() {
        reporter.addTest("TC_02");
        try {
            driver.get(propertyReader.getProperty("url"));
            SleepUtil.sleepFor10Seconds();
            reporter.writeLogWithScreenshot(Status.INFO, "Navigated to OrangeHRM login page");
            
            String expectedTitle = "OrangeHRM";
            String actualTitle = driver.getTitle();
            if (actualTitle.equals(expectedTitle)) {
                reporter.writeLogWithoutScreenshot(Status.PASS, "Title matched: '" + expectedTitle + "'");
            } else {
                reporter.writeLogWithScreenshot(Status.FAIL, "Title did not match. Expected: '" + expectedTitle + "', but was: '" + actualTitle + "'");
            }
        } catch (Exception e) {
            reporter.writeLogWithoutScreenshot(Status.FAIL, "Test TC_02 failed: " + e.getMessage());
        }
    }
    

}
