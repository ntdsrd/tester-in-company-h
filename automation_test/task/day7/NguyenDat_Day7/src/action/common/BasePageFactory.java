package action.common;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePageFactory {
    Actions action;
    JavascriptExecutor javascriptExecutor;
    WebDriverWait explicitWait;

    //wait for element visible
    public void waitForElementVisible(WebDriver driver, WebElement element) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstant.SHORT_TIMEOUT));
        explicitWait.until(ExpectedConditions.visibilityOf(element));
    }

    //wait for element clickable
    public void waitForElementClickable(WebDriver driver, WebElement element) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstant.SHORT_TIMEOUT));
        explicitWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    //send key to element
    public void sendKeyToElement(WebDriver driver, WebElement element, String value) {
        waitForElementVisible(driver, element);
        element.clear();
        element.sendKeys(value);
    }

    //clear element
    public void clearElement(WebDriver driver, WebElement element) {
        waitForElementVisible(driver, element);
        element.clear();
    }

    //click to element
    public void clickToElement(WebDriver driver, WebElement element) {
        waitForElementClickable(driver, element);
        element.click();
    }

    //get element text
    public String getElementText(WebDriver driver, WebElement element) {
        waitForElementVisible(driver, element);
        return element.getText().trim();
    }

    //hover to element
    public void hoverToElement(WebDriver driver, WebElement element) {
        waitForElementVisible(driver, element);
        action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    //compare message
    public boolean compareMessage(WebDriver driver, WebElement element, String message) {
        return getElementText(driver, element).equals(message);
    }

    //sleep in second
    public void SleepInSecond(int second) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}