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
        sendKeyToElement(driver, ProxyLocator.USERNAME, username);
        sendKeyToElement(driver, ProxyLocator.PASSWORD, password);
        clickToElement(driver, ProxyLocator.SUBMIT_BUTTON);
    }
}
