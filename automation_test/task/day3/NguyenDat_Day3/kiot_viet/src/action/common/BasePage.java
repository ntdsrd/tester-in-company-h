package action.common;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    Actions action;
    Select select;
    private WebDriverWait explicitWait;

    //xpath
    public By getXpath(String locator) {
        return By.xpath(locator);
    }

    //find element
    public WebElement getElement(WebDriver driver, String locator) {
        return driver.findElement(getXpath(locator));
    }

    //find elements
    public List<WebElement> getElements(WebDriver driver, String locator) {
        return driver.findElements(getXpath(locator));
    }

    //wait element visible
    public void waitForElementVisible(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstant.SHORT_TIMEOUT));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getXpath(locator)));
    }

    //wait element invisible
    public void waitForElementInvisible(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstant.SHORT_TIMEOUT));
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getXpath(locator)));
    }

    //wait all elements visible
    public void waitForAllElementsVisible(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstant.SHORT_TIMEOUT));
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(getElements(driver, locator)));
    }

    //wait all elements invisible
    public void waitForAllElementsInvisible(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstant.SHORT_TIMEOUT));
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getElements(driver, locator)));
    }

    //wait element clickable
    public void waitForElementClickable(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstant.SHORT_TIMEOUT));
        explicitWait.until(ExpectedConditions.elementToBeClickable(getXpath(locator)));
    }

    //send key
    public void sendKeyToElement(WebDriver driver, String locator, String value) {
        waitForElementVisible(driver, locator);
        getElement(driver, locator).clear();
        getElement(driver, locator).sendKeys(value);
    }

    //clear
    public void clearElement(WebDriver driver, String locator) {
        waitForElementVisible(driver, locator);
        getElement(driver, locator).clear();
    }

    //click
    public void clickToElement(WebDriver driver, String locator) {
        waitForElementClickable(driver, locator);
        getElement(driver, locator).click();
    }

    //right click
    public void rightClickToElement(WebDriver driver, String locator) {
        waitForElementClickable(driver, locator);
        action = new Actions(driver);
        action.contextClick(getElement(driver, locator)).perform();
    }

    //get text
    public String getElementText(WebDriver driver, String locator) {
        waitForElementVisible(driver, locator);
        return getElement(driver, locator).getText().trim();
    }

    //get attribute
    public String getElementAttribute(WebDriver driver, String locator, String attribute) {
        waitForElementVisible(driver, locator);
        return getElement(driver, locator).getAttribute(attribute);
    }

    //hover
    public void hoverToElement(WebDriver driver, String locator) {
        waitForElementVisible(driver, locator);
        action = new Actions(driver);
        action.moveToElement(getElement(driver, locator)).perform();
    }

    //drag and drop
    public void dragAndDropElement(WebDriver driver, String locator, String target) {
        waitForElementVisible(driver, locator);
        action = new Actions(driver);
        action.dragAndDrop(getElement(driver, locator), getElement(driver, target)).perform();
    }

    //select element in dropdown by text
    public void selectElementInDropdownByText(WebDriver driver, String locator, String text) {
        waitForElementVisible(driver, locator);
        select = new Select(getElement(driver, locator));
        select.selectByVisibleText(text);
    }

    //select element in dropdown by value
    public void selectElementInDropdownByValue(WebDriver driver, String locator, String value) {
        waitForElementVisible(driver, locator);
        select = new Select(getElement(driver, locator));
        select.selectByValue(value);
    }

    //select element in dropdown by index
    public void selectElementInDropdownByIndex(WebDriver driver, String locator, int index) {
        waitForElementVisible(driver, locator);
        select = new Select(getElement(driver, locator));
        select.selectByIndex(index);
    }

    //press key
    public void pressKey(WebDriver driver, Keys key) {
        action = new Actions(driver);
        action.keyDown(key).perform();
    }

    //release key
    public void releaseKey(WebDriver driver, Keys key) {
        action = new Actions(driver);
        action.keyUp(key).perform();
    }

    //accept alert
    public void acceptAlert(WebDriver driver) {
        driver.switchTo().alert().accept();
    }

    //dismiss alert
    public void dismissAlert(WebDriver driver) {
        driver.switchTo().alert().dismiss();
    }

    //send key in alert
    public void sendKeyInAlert(WebDriver driver, String value) {
        driver.switchTo().alert().sendKeys(value);
    }

    //get text in alert
    public String getTextInAlert(WebDriver driver) {
        return driver.switchTo().alert().getText();
    }

    //switch window by title
    public void switchWindowByTitle(WebDriver driver, String text) {
        String currentWindow = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            if (driver.getTitle().contains(text)) {
                driver.switchTo().window(currentWindow);
            } else {
                driver.switchTo().window(winHandle);
            }
            break;
        }
    }

    //refresh page
    public void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    //back to page
    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    //forward to page
    public void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    //element displayed
    public boolean isElementDisplayed(WebDriver driver, String locator) {
        return getElement(driver, locator).isDisplayed();
    }

    //element selected
    public boolean isElementSelected(WebDriver driver, String locator) {
        return getElement(driver, locator).isSelected();
    }

    //compare message
    public boolean compareMessage(WebDriver driver, String locator, String message) {
        return getElementText(driver, locator).equals(message);
    }

    //sleep
    public void SleepInSecond(int second) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
