package action;

import action.common.BasePage;
import org.openqa.selenium.WebDriver;
import user_interface.ProxyLocator;

public class Proxy extends BasePage {
    WebDriver driver;

    public Proxy(WebDriver driver) {
        this.driver = driver;
    }

    public void checkProxy(String username, String password) {
        if (driver.getTitle().contains("Proxy")) {
            sendKeyToElement(driver, ProxyLocator.USERNAME, username);
            SleepInSecond(1);
            sendKeyToElement(driver, ProxyLocator.PASSWORD, password);
            SleepInSecond(1);
            clickToElement(driver, ProxyLocator.SUBMIT);
        }
    }
}