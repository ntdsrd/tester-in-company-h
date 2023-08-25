package action;

import action.common.BasePage;
import org.openqa.selenium.WebDriver;
import user_interface.Locator;

public class TongQuan extends BasePage {
    WebDriver driver;

    public TongQuan(WebDriver driver) {
        this.driver = driver;
    }

    public void checkTongQuanPageVisible() {
        System.out.println("Go to the " + getElementText(driver, Locator.TONG_QUAN));
    }
}