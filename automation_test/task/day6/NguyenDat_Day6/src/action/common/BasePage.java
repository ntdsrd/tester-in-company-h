package action.common;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    Actions action;
    JavascriptExecutor javascriptExecutor;
    WebDriverWait explicitWait;

    //get xpath
    public By getXpath(String locator) {
        return By.xpath(locator);
    }

    //get element
    public WebElement getElement(WebDriver driver, String locator) {
        return driver.findElement(getXpath(locator));
    }

    //get elements
    public List<WebElement> getElements(WebDriver driver, String locator) {
        return driver.findElements(getXpath(locator));
    }

    //wait for element visible
    public void waitForElementVisible(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstant.SHORT_TIMEOUT));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getXpath(locator)));
    }

    //wait for element invisible
    public void waitForElementInvisible(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstant.SHORT_TIMEOUT));
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getXpath(locator)));
    }

    //wait for all elements visible
    public void waitForAllElementsVisible(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstant.SHORT_TIMEOUT));
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(getElements(driver, locator)));
    }

    //wait for all elements invisible
    public void waitForAllElementsInvisible(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstant.SHORT_TIMEOUT));
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getElements(driver, locator)));
    }

    //wait for element clickable
    public void waitForElementClickable(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstant.SHORT_TIMEOUT));
        explicitWait.until(ExpectedConditions.elementToBeClickable(getXpath(locator)));
    }

    //send key to element
    public void sendKeyToElement(WebDriver driver, String locator, String value) {
        waitForElementVisible(driver, locator);
        getElement(driver, locator).clear();
        getElement(driver, locator).sendKeys(value);
    }

    //clear element
    public void clearElement(WebDriver driver, String locator) {
        waitForElementVisible(driver, locator);
        getElement(driver, locator).clear();
    }

    //click to element
    public void clickToElement(WebDriver driver, String locator) {
        waitForElementClickable(driver, locator);
        getElement(driver, locator).click();
    }

    //right click to element
    public void rightClickToElement(WebDriver driver, String locator) {
        waitForElementClickable(driver, locator);
        action = new Actions(driver);
        action.contextClick(getElement(driver, locator)).perform();
    }

    //get element text
    public String getElementText(WebDriver driver, String locator) {
        waitForElementVisible(driver, locator);
        return getElement(driver, locator).getText().trim();
    }

    //get element attribute
    public String getElementAttribute(WebDriver driver, String locator, String attribute) {
        waitForElementVisible(driver, locator);
        return getElement(driver, locator).getAttribute(attribute).trim();
    }

    //hover to element
    public void hoverToElement(WebDriver driver, String locator) {
        waitForElementVisible(driver, locator);
        action = new Actions(driver);
        action.moveToElement(getElement(driver, locator)).perform();
    }

    //drag and drop element
    public void dragAndDropElement(WebDriver driver, String locator, String target) {
        waitForElementVisible(driver, locator);
        action = new Actions(driver);
        action.dragAndDrop(getElement(driver, locator), getElement(driver, target)).perform();
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

    //check element displayed
    public boolean isElementDisplayed(WebDriver driver, String locator) {
        return getElement(driver, locator).isDisplayed();
    }

    //check element selected
    public boolean isElementSelected(WebDriver driver, String locator) {
        return getElement(driver, locator).isSelected();
    }

    //compare message
    public boolean compareMessage(WebDriver driver, String locator, String message) {
        return getElementText(driver, locator).equals(message);
    }

    //get dynamic locator
    public String getDynamicLocator(String locator, String... params) {
        return String.format(locator, (Object[]) params);
    }

    //get dynamic element
    public WebElement getDynamicElement(WebDriver driver, String locator, String... params) {
        locator = getDynamicLocator(locator, params);
        return getElement(driver, locator);
    }

    //click to element by dynamic locator
    public void clickToElementByDynamicLocator(WebDriver driver, String locator, String... params) {
        waitForElementClickable(driver, locator);
        getDynamicElement(driver, locator, params).click();
    }

    //send key to element by dynamic locator
    public void sendKeyToElementByDynamicLocator(WebDriver driver, String locator, String value, String... params) {
        waitForElementVisible(driver, locator);
        getDynamicElement(driver, locator, params).clear();
        getDynamicElement(driver, locator, params).sendKeys(value);
    }

    //get element text by dynamic locator
    public String getElementTextByDynamicLocator(WebDriver driver, String locator, String... params) {
        waitForElementVisible(driver, locator);
        return getDynamicElement(driver, locator, params).getText().trim();
    }

    //check element displayed by dynamic locator
    public boolean isElementDisplayedByDynamicLocator(WebDriver driver, String locator, String... params) {
        return getDynamicElement(driver, locator, params).isDisplayed();
    }

    //press key by dynamic locator
    public void pressKeyByDynamicLocator(WebDriver driver, String locator, String... params) {
        action = new Actions(driver);
        action.sendKeys(getDynamicElement(driver, locator, params));
    }

    //javascript executor refresh browser
    public void jsRefreshBrowser() {
        javascriptExecutor.executeScript("history.go(0)");
    }

    //javascript executor get all text
    public String jsGetAllText() {
        return javascriptExecutor.executeScript("return document.documentElement.innerText").toString();
    }

    //javascript executor get title
    public String jsGetTitle() {
        return javascriptExecutor.executeScript("return document.title").toString();
    }

    //javascript executor get domain
    public String jsGetDomain() {
        return javascriptExecutor.executeScript("return document.domain").toString();
    }

    //javascript executor scroll to the bottom
    public void jsScrollToTheBottom() {
        javascriptExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    //javascript executor scroll to above element
    public void jsScrollToAboveElement(WebDriver driver, String locator) {
        waitForElementVisible(driver, locator);
        javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", getElement(driver, locator));
    }

    //javascript executor scroll to below element
    public void jsScrollToBelowElement(WebDriver driver, String locator) {
        waitForElementVisible(driver, locator);
        javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(false)", getElement(driver, locator));
    }

    //javascript executor remove attribute
    public void jsRemoveAttribute(WebDriver driver, String locator, String attribute) {
        waitForElementVisible(driver, locator);
        javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].removeAttribute('" + attribute + "')", getElement(driver, locator));
    }

    //javascript executor click to element
    public void jsClickToElement(WebDriver driver, String locator) {
        waitForElementClickable(driver, locator);
        javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click", getElement(driver, locator));
    }

    //javascript executor select element in dropdown list
    public void jsSelectElementInDropdown(WebDriver driver, String parentLocator, String childLocator, String expectedItem) {
        getElement(driver, parentLocator).click();
        SleepInSecond(1);
        List<WebElement> allItems = (List<WebElement>) explicitWait.until(ExpectedConditions.presenceOfElementLocated(getXpath(childLocator)));
        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {
                javascriptExecutor = (JavascriptExecutor) driver;
                javascriptExecutor.executeScript("arguments[0],scrollIntoView(true)", item);
                SleepInSecond(1);
                item.click();
                SleepInSecond(1);
                break;
            }
        }
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