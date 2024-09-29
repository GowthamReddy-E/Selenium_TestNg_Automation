package gowe.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaits {

    private WebDriver driver;
    private WebDriverWait wait;

    public ExplicitWaits(WebDriver driver, int timeoutInSeconds) {
        this.driver = driver;
        // Initialize WebDriverWait with a specific timeout
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    }

    // Wait for element to be visible by ID
    public WebElement waitForElementVisibleById(String id) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
    }

    // Wait for element to be clickable by ID
    public WebElement waitForElementClickableById(String id) {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
    }

    // Wait for element to be present by ID
    public WebElement waitForElementPresentById(String id) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
    }

    // Wait for element to be visible by Class Name
    public WebElement waitForElementVisibleByClassName(String className) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
    }

    // Wait for element to be clickable by Class Name
    public WebElement waitForElementClickableByClassName(String className) {
        return wait.until(ExpectedConditions.elementToBeClickable(By.className(className)));
    }

    // Wait for element to be present by Class Name
    public WebElement waitForElementPresentByClassName(String className) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.className(className)));
    }

    // Wait for element to be visible by Tag Name
    public WebElement waitForElementVisibleByTagName(String tagName) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(tagName)));
    }

    // Wait for element to be clickable by Tag Name
    public WebElement waitForElementClickableByTagName(String tagName) {
        return wait.until(ExpectedConditions.elementToBeClickable(By.tagName(tagName)));
    }

    // Wait for element to be present by Tag Name
    public WebElement waitForElementPresentByTagName(String tagName) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName(tagName)));
    }

    // Wait for element to be visible by CSS Selector
    public WebElement waitForElementVisibleByCssSelector(String cssSelector) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
    }

    // Wait for element to be clickable by CSS Selector
    public WebElement waitForElementClickableByCssSelector(String cssSelector) {
        return wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector)));
    }

    // Wait for element to be present by CSS Selector
    public WebElement waitForElementPresentByCssSelector(String cssSelector) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector)));
    }

    // Wait for element to be visible by XPath
    public WebElement waitForElementVisibleByXPath(String xpath) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    // Wait for element to be clickable by XPath
    public WebElement waitForElementClickableByXPath(String xpath) {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    // Wait for element to be present by XPath
    public WebElement waitForElementPresentByXPath(String xpath) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    // Wait for element to be visible by Link Text
    public WebElement waitForElementVisibleByLinkText(String linkText) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(linkText)));
    }

    // Wait for element to be clickable by Link Text
    public WebElement waitForElementClickableByLinkText(String linkText) {
        return wait.until(ExpectedConditions.elementToBeClickable(By.linkText(linkText)));
    }

    // Wait for element to be present by Link Text
    public WebElement waitForElementPresentByLinkText(String linkText) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(linkText)));
    }

    // Wait for element to be visible by Partial Link Text
    public WebElement waitForElementVisibleByPartialLinkText(String partialLinkText) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(partialLinkText)));
    }

    // Wait for element to be clickable by Partial Link Text
    public WebElement waitForElementClickableByPartialLinkText(String partialLinkText) {
        return wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(partialLinkText)));
    }

    // Wait for element to be present by Partial Link Text
    public WebElement waitForElementPresentByPartialLinkText(String partialLinkText) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(partialLinkText)));
    }

}
