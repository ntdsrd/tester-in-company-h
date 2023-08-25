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
        System.out.println("Go to the " + driver.getTitle());
    }

    public void navigateToDanhMuc() {
        hoverToElement(driver, TongQuanLocator.HANG_HOA_MENU);
        SleepInSecond(1);
        hoverToElement(driver, TongQuanLocator.DANH_MUC_MENU);
        SleepInSecond(1);
        clickToElement(driver, TongQuanLocator.DANH_MUC_MENU);
    }
}
