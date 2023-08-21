package action;

import action.common.BasePage;
import org.openqa.selenium.WebDriver;
import user_interface.LoginLocator;

public class Login extends BasePage {
    WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        sendKeyToElement(driver, LoginLocator.USERNAME, username);
    }

    public void enterPassword(String password) {
        sendKeyToElement(driver, LoginLocator.PASSWORD, password);
    }

    public void clickSubmitButton() {
        clickToElement(driver, LoginLocator.SUBMIT_BUTTON);
    }
}
