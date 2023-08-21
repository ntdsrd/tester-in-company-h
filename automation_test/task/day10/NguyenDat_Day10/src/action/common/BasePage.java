package action.common;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class BasePage {
    WebDriverWait explicitWait;
    Actions actions;

    //sleep
    public void sleep(int second) {
        try {
            Thread.sleep(second);
        } catch (Throwable throwable) {
            throw new RuntimeException();
        }
    }

    //by xpath
    public By byXpath(String locator) {
        return By.xpath(locator);
    }

    //find element
    public WebElement findElement(WebDriver driver, String locator) {
        return driver.findElement(byXpath(locator));
    }

    //find elements
    public List<WebElement> findElements(WebDriver driver, String locator) {
        return driver.findElements(byXpath(locator));
    }

    //wait for element visible
    public void waitForElementVisible(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstant.SHORT_TIMEOUT));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(byXpath(locator)));
    }

    //wait for element clickable
    public void waitForElementClickable(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstant.SHORT_TIMEOUT));
        explicitWait.until(ExpectedConditions.elementToBeClickable(byXpath(locator)));
    }

    //verify equals
    public boolean verifyEquals(String actual, String expected) {
        try {
            Assert.assertEquals(actual, expected);
        } catch (Throwable throwable) {
            return false;
        }
        return true;
    }

    //verify true
    public boolean verifyTrue(boolean condition) {
        try {
            Assert.assertTrue(condition);
        } catch (Throwable throwable) {
            return false;
        }
        return true;
    }

    //check element displayed
    public boolean isElementDisplayed(WebDriver driver, String locator) {
        return findElement(driver, locator).isDisplayed();
    }

    //clear element
    public void clearElement(WebDriver driver, String locator) {
        waitForElementVisible(driver, locator);
        findElement(driver, locator).clear();
    }

    //send key to element
    public void sendKeyToElement(WebDriver driver, String locator, String value) {
        clearElement(driver, locator);
        findElement(driver, locator).sendKeys(value);
    }

    //click to element
    public void clickToElement(WebDriver driver, String locator) {
        waitForElementClickable(driver, locator);
        findElement(driver, locator).click();
    }

    //get text of element
    public String getTextOfElement(WebDriver driver, String locator) {
        waitForElementVisible(driver, locator);
        return findElement(driver, locator).getText().trim();
    }

    //find dynamic locator
    public String findDynamicLocator(String locator, String... params) {
        return String.format(locator, (Object[]) params);
    }

    //find dynamic element
    public WebElement findDynamicElement(WebDriver driver, String locator, String... params) {
        locator = findDynamicLocator(locator, params);
        return findElement(driver, locator);
    }

    //click to element by dynamic locator
    public void clickToElementByDynamicLocator(WebDriver driver, String locator, String... params) {
        findDynamicElement(driver, locator, params).click();
    }

    //get text of element by dynamic locator
    public String getTextOfElementByDynamicLocator(WebDriver driver, String locator, String... params) {
        return findDynamicElement(driver, locator, params).getText().trim();
    }
}
