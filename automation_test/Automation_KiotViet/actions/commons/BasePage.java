package commons;

import org.apache.xalan.xsltc.dom.AdaptiveResultTreeImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Objects;

public class BasePage {

    JavascriptExecutor javascriptExecutor;
    Actions actions;
    WebDriver driver;
    WebDriverWait explicitwait;
   public By getXpath(String locator) {
       return By.xpath(locator);
   }

   public WebElement getElement(WebDriver driver, String locator) {
       return driver.findElement(getXpath(locator));
   }

    public List<WebElement> getElements(WebDriver driver, String locator) {
        return driver.findElements(getXpath(locator));
    }

    public void clickToElement(WebDriver driver, String locator) {
        waitForElementIsVisible(driver, locator);
        waitForElementClickable(driver, locator);
        hoverToElement(driver, locator);
        getElement(driver, locator).click();

    }

    public void waitForElementIsVisible(WebDriver driver, String locator) {
        explicitwait = new WebDriverWait(driver,GlobalConstants.SHORT_TIMEOUT);
        explicitwait.until(ExpectedConditions.visibilityOfElementLocated(getXpath(locator)));
    }

    public void waitForElementClickable(WebDriver driver, String locator) {
       waitForElementIsVisible(driver, locator);
        explicitwait = new WebDriverWait(driver,GlobalConstants.SHORT_TIMEOUT);
        explicitwait.until(ExpectedConditions.elementToBeClickable(getXpath(locator)));
    }

    public void enterTextToElement(WebDriver driver, String locator, String value) {
       waitForElementIsVisible(driver, locator);
       getElement(driver, locator).clear();
       getElement(driver, locator).sendKeys(value);
    }

    public void getTextElement(WebDriver driver, String locator){
       waitForElementIsVisible(driver, locator);
       getElement(driver, locator).getText().trim();
    }


    public void hoverToElement(WebDriver driver, String locator){
       actions = new Actions(driver);
       waitForElementIsVisible(driver, locator);
       actions.clickAndHold(getElement(driver, locator));
    }

    public void SleepInSecond(int second)   {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
        getElement(driver, parentLocator).click();
        SleepInSecond(1);
        List<WebElement> allItems = (List<WebElement>) explicitwait.until(ExpectedConditions.presenceOfElementLocated(getXpath(childItemLocator)));
        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {
                javascriptExecutor = (JavascriptExecutor) driver;
                javascriptExecutor.executeScript("arguments[0],scrollIntoView(true);", item);
                SleepInSecond(1);
                item.click();
                SleepInSecond(1);
                break;
            }

        }
    }

    public void clickToElementByJS(WebDriver driver, String locator) {
        waitForElementClickable(driver, locator);
        javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click;", getElement(driver, locator));
    }
    public String getDynamicLocator(String locator, String...params) {
       return String.format(locator,params);
    }

    public WebElement getDynamicElement(WebDriver driver, String locator, String... params) {
       locator = getDynamicLocator(locator,params);
       return getElement(driver,locator);
    }

    public boolean isDiplayElements(WebDriver driver, String locator ) {
       waitForElementIsVisible(driver,locator);
       return getElement(driver,locator).isDisplayed();
    }





}
