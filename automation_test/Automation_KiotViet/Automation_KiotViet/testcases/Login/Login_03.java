package Login;

import TongQuan.TongQuan_01;
import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Login_03 extends BaseTest {
    WebDriver driver;
    Login login;
    TongQuan_01 tongQuan;


    @Parameters({"browser", "url"})
    @BeforeMethod
    public void initBrowser(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        login = PageGeneratorManager.getLoginPage(driver);
    }

    @Test(description = "Đăng nhập thành công", groups = {"group1"})
    public void Login_01() {
        //Step 1: Nhập tên gian hàng
        login.nhapTenGianHang(GlobalConstants.TEN_GIAN_HANG);

        //Step 2: Nhập tên đăng nhập
        login.nhapTenDangNhap(GlobalConstants.TEN_DANG_NHAP);

        //Step 3: Nhập mật khẩu
        login.nhapMatKhau(GlobalConstants.MAT_KHAU);

        //Step 4: Click button Login
        login.clickButtonLogin();
        //Step 5: Kiểm tra hiển thị màn hình tổng quan
        Assert.assertTrue(login.verifyLoginSuccessfully());

    }
//    @Test(description = "Đăng nhập thành công", groups = {"group1"})
//    public void Login_02() {
//        //Step 1: Nhập tên gian hàng
//        login.nhapTenGianHang(GlobalConstants.TEN_GIAN_HANG);
//
//        //Step 2: Nhập tên đăng nhập
//        login.nhapTenDangNhap(GlobalConstants.TEN_DANG_NHAP);
//
//        //Step 3: Nhập mật khẩu
//        login.nhapMatKhau(GlobalConstants.MAT_KHAU);
//
//        //Step 4: Click button Login
//        login.clickButtonLogin();
//        //Step 5: Kiểm tra hiển thị màn hình tổng quan
//        Assert.assertTrue(login.verifyLoginSuccessfully());
//
//    }

        @AfterMethod
        public void AfterTest() {
        driver.quit();
        }
}
