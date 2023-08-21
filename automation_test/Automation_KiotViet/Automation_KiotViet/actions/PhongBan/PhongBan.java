package PhongBan;

import Login.Login;
import TongQuan.TongQuan;
import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PhongBan extends BasePage {
    WebDriver driver;
    Login login;
    TongQuan tongQuan;
    PhongBan phongBan;
    public PhongBan(WebDriver driver) {
        this.driver = driver;
    }

    public void diChuyenToiManHinhPhongBan() {
        login = PageGeneratorManager.getLoginPage(driver);
        login.loginSuccessfully();
        tongQuan = PageGeneratorManager.getTongQuanPage(driver);
        tongQuan.diChuyenDenManHinhPhongBan();
        phongBan = PageGeneratorManager.getPhongBanPage(driver);
        Assert.assertTrue(verifyPhongBanPageDisplay());
    }

    public boolean verifyPhongBanPageDisplay() {
        return isDiplayElements(driver, PhongBanUI.BUTTON_THEM_MOI_PHONG_BAN);
    }
}
