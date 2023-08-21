package Login;

import TongQuan.TongQuan;
import TongQuan.TongQuanUI;
import commons.BasePage;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Login extends BasePage {
    WebDriver driver;
    private TongQuan tongQuan;
    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void nhapTenGianHang(String tenGianHang) {
        enterTextToElement(driver,LoginUI.TEN_GIAN_HANG, tenGianHang);
        SleepInSecond(1);
    }

    public void nhapTenDangNhap(String tenDangNhap) {
        enterTextToElement(driver,LoginUI.TEN_DANG_NHAP, tenDangNhap);
        SleepInSecond(1);
    }

    public void nhapMatKhau(String matKhau) {
        enterTextToElement(driver,LoginUI.MAT_KHAU, matKhau);
        SleepInSecond(1);
    }

    public void clickButtonLogin() {
        clickToElement(driver,LoginUI.BUTTON_QUAN_LY);
    }

    public void loginSuccessfully() {
        nhapTenGianHang(GlobalConstants.TEN_GIAN_HANG);
        nhapTenDangNhap(GlobalConstants.TEN_DANG_NHAP);
        nhapMatKhau(GlobalConstants.MAT_KHAU);
        clickButtonLogin();
        tongQuan = PageGeneratorManager.getTongQuanPage(driver);
        Assert.assertTrue(isDiplayElements(driver, TongQuanUI.TONG_QUAN_HEADER));
    }

    public boolean verifyLoginSuccessfully() {
        return isDiplayElements(driver, TongQuanUI.TONG_QUAN_HEADER);
    }

}
