package TongQuan;

import PhongBan.PhongBanUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TongQuan extends BasePage {

    WebDriver driver;

    public TongQuan(WebDriver driver) {
        this.driver = driver;
    }


    public void kiemTraHienThiMHTongQuan() {
        waitForElementIsVisible(driver,TongQuanUI.TONG_QUAN_HEADER);
    }

    public void diChuyenDenManHinhPhongBan() {
        clickToElement(driver, PhongBanUI.PHONG_BAN_HEADER);
    }

    public boolean verifyLoginSuccessfully() {
        return isDiplayElements(driver, TongQuanUI.TONG_QUAN_HEADER);
    }
}
