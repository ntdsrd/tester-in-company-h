package action;

import action.common.BasePage;
import data.BanHangData;
import org.openqa.selenium.WebDriver;
import user_interface.BanHangLocator;

public class BanHang extends BasePage {
    WebDriver driver;

    public BanHang(WebDriver driver) {
        this.driver = driver;
    }

    public void chooseAction(String... params) {
        clickToElementByDynamicLocator(driver, BanHangLocator.PHONG_BAN_ACTION, params);
        SleepInSecond(1);
    }

    public void switchTo(String... params) {
        clickToElementByDynamicLocator(driver, BanHangLocator.HEADER_LINK, params);
        SleepInSecond(1);
    }

    public void selectMenu(String... params) {
        clickToElementByDynamicLocator(driver, BanHangLocator.THUC_DON_MENU, params);
        SleepInSecond(1);
    }

    public void clickButton(String... params) {
        clickToElementByDynamicLocator(driver, BanHangLocator.BUTTON, params);
    }
}
