package action;

import action.common.BasePage;
import org.openqa.selenium.WebDriver;
import user_interface.phong_ban.PhongBanLocator;
import user_interface.phong_ban.ThemKhuVucLocator;

public class PhongBan extends BasePage {
    WebDriver driver;

    public PhongBan(WebDriver driver) {
        this.driver = driver;
    }

    public void clickThemKhuVuc() {
        clickToElement(driver, PhongBanLocator.THEM_KHU_VUC);
    }

    public void enterTenKhuVucThemKhuVuc(String value) {
        sendKeyToElement(driver, ThemKhuVucLocator.TEN_KHU_VUC, value);
    }

    public void clickLuuThemKhuVuc() {
        clickToElement(driver, ThemKhuVucLocator.LUU);
    }
}