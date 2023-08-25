package action.tong_quan;

import action.common.BasePage;
import org.openqa.selenium.WebDriver;
import user_interface.tong_quan.TongQuanLocator;

public class TongQuan extends BasePage {
    WebDriver driver;

    public TongQuan(WebDriver driver) {
        this.driver = driver;
    }

    public void checkTongQuanPageVisible() {
        waitForElementVisible(driver, TongQuanLocator.TONG_QUAN_MENU);
        System.out.println("Go to the " + getElementText(driver, TongQuanLocator.TONG_QUAN_MENU));
    }
}
