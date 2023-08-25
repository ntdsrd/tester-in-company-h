package action;

import action.common.BasePage;
import org.openqa.selenium.WebDriver;
import user_interface.TongQuanLocator;

public class TongQuan extends BasePage {
    WebDriver driver;

    public TongQuan(WebDriver driver) {
        this.driver = driver;
    }

    public void checkTongQuanPageVisible() {
        System.out.println("Go to the " + getElementText(driver, TongQuanLocator.TONG_QUAN_MENU));
    }

    public void getMessage() {
        SleepInSecond(5);
        System.out.println(getElementText(driver, TongQuanLocator.ERROR_MESSAGE));
    }

    public void compareMessage(String message) {
        System.out.println("Expected message as same as actual message: " + compareMessage(driver, TongQuanLocator.ERROR_MESSAGE, message));
    }

    public void navigateToDanhMuc() {
        hoverToElement(driver, TongQuanLocator.HANG_HOA_MENU);
        SleepInSecond(1);
        hoverToElement(driver, TongQuanLocator.DANH_MUC_MENU);
        SleepInSecond(1);
        System.out.println("Go to the " + getElementText(driver, TongQuanLocator.DANH_MUC_MENU));
        clickToElement(driver, TongQuanLocator.DANH_MUC_MENU);
    }

    public void navigateToPhongBan() {
        hoverToElement(driver, TongQuanLocator.PHONG_BAN_MENU);
        SleepInSecond(1);
        clickToElement(driver, TongQuanLocator.PHONG_BAN_MENU);
        System.out.println("Go to the " + getElementText(driver, TongQuanLocator.PHONG_BAN_MENU));
    }
}