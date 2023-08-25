package test_case;

import action.Proxy;
import action.common.BaseTest;
import action.common.PageGeneratorManager;
import action.DangNhap;
import action.TongQuan;
import data.DangNhapData;
import data.ProxyData;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import user_interface.DangNhapLocator;

public class DangNhapTestCase extends BaseTest {
    WebDriver driver;
    Proxy proxy;
    DangNhap dangNhap;
    TongQuan tongQuan;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void initBrowser(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        proxy = PageGeneratorManager.getProxyPage(driver);
        proxy.checkProxy(ProxyData.USERNAME, ProxyData.PASSWORD);
        dangNhap = PageGeneratorManager.getDangNhapPage(driver);
    }

    @AfterClass
    public void AfterTest() {
        driver.quit();
    }

    @Test(description = "all fields are blank")
    public void DangNhap01() {
        //click "Quản lý" button
        dangNhap.clickQuanLy();
        //get error message
        System.out.print("Test Case 1: ");
        dangNhap.getErrorMessage();
        dangNhap.compareMessage("Bạn hãy nhập đầy đủ thông tin các trường!");
    }

    @Test(description = "tên gian hàng is blank", dependsOnMethods = {"DangNhap01"})
    public void DangNhap02() {
        //enter "Tên gian hàng"
        dangNhap.clearElement(driver, DangNhapLocator.TEN_GIAN_HANG);
        //enter "Tên đăng nhập"
        dangNhap.enterTenDangNhap(DangNhapData.TEN_DANG_NHAP);
        //enter "Mật khẩu"
        dangNhap.enterMatKhau(DangNhapData.MAT_KHAU);
        //click "Quản lý" button
        dangNhap.clickQuanLy();
        //get error message
        System.out.print("Test Case 2: ");
        dangNhap.getErrorMessage();
        dangNhap.compareMessage("Cửa hàng không tồn tại");
    }

    @Test(description = "tên đăng nhập is blank", dependsOnMethods = {"DangNhap02"})
    public void DangNhap03() {
        //enter "Tên gian hàng"
        dangNhap.enterTenGianHang(DangNhapData.TEN_GIAN_HANG);
        //enter "Tên đăng nhập"
        dangNhap.clearElement(driver, DangNhapLocator.TEN_DANG_NHAP);
        //enter "Mật khẩu"
        dangNhap.enterMatKhau(DangNhapData.MAT_KHAU);
        //click "Quản lý" button
        dangNhap.clickQuanLy();
        //get error message
        System.out.print("Test Case 3: ");
        dangNhap.getErrorMessage();
        dangNhap.compareMessage("Bạn hãy nhập đầy đủ thông tin các trường!");
    }

    @Test(description = "mật khẩu is blank", dependsOnMethods = {"DangNhap03"})
    public void DangNhap04() {
        //enter "Tên gian hàng"
        dangNhap.enterTenGianHang(DangNhapData.TEN_GIAN_HANG);
        //enter "Tên đăng nhập"
        dangNhap.enterTenDangNhap(DangNhapData.TEN_DANG_NHAP);
        //enter "Mật khẩu"
        dangNhap.clearElement(driver, DangNhapLocator.MAT_KHAU);
        //click "Quản lý" button
        dangNhap.clickQuanLy();
        //get error message
        System.out.print("Test Case 4: ");
        dangNhap.getErrorMessage();
        dangNhap.compareMessage("Bạn hãy nhập đầy đủ thông tin các trường!");
    }

    @Test(description = "tên gian hàng is incorrect", dependsOnMethods = {"DangNhap04"})
    public void DangNhap05() {
        //enter "Tên gian hàng"
        dangNhap.enterTenGianHang(DangNhapData.TEN_GIAN_HANG_INCORRECT);
        //enter "Tên đăng nhập"
        dangNhap.enterTenDangNhap(DangNhapData.TEN_DANG_NHAP);
        //enter "Mật khẩu"
        dangNhap.enterMatKhau(DangNhapData.MAT_KHAU);
        //click "Quản lý" button
        dangNhap.clickQuanLy();
        //get error message
        System.out.print("Test Case 5: ");
        dangNhap.getErrorMessage();
        dangNhap.compareMessage("Cửa hàng " + DangNhapData.TEN_GIAN_HANG_INCORRECT + " không tồn tại");
    }

    @Test(description = "tên đăng nhập is incorrect", dependsOnMethods = {"DangNhap05"})
    public void DangNhap06() {
        //enter "Tên gian hàng"
        dangNhap.enterTenGianHang(DangNhapData.TEN_GIAN_HANG);
        //enter "Tên đăng nhập"
        dangNhap.enterTenDangNhap(DangNhapData.TEN_DANG_NHAP_INCORRECT);
        //enter "Mật khẩu"
        dangNhap.enterMatKhau(DangNhapData.MAT_KHAU);
        //click "Quản lý" button
        dangNhap.clickQuanLy();
        //get error message
        System.out.print("Test Case 6: ");
        dangNhap.getErrorMessage();
        dangNhap.compareMessage("Invalid Username or Password");
    }

    @Test(description = "mật khẩu is incorrect", dependsOnMethods = {"DangNhap06"})
    public void DangNhap07() {
        //enter "Tên gian hàng"
        dangNhap.enterTenGianHang(DangNhapData.TEN_GIAN_HANG);
        //enter "Tên đăng nhập"
        dangNhap.enterTenDangNhap(DangNhapData.TEN_DANG_NHAP);
        //enter "Mật khẩu"
        dangNhap.enterMatKhau(DangNhapData.MAT_KHAU_INCORRECT);
        //click "Quản lý" button
        dangNhap.clickQuanLy();
        //get error message
        System.out.print("Test Case 7: ");
        dangNhap.getErrorMessage();
        dangNhap.compareMessage("Invalid Username or Password");
    }

    @Test(description = "login successfully", dependsOnMethods = {"DangNhap07"})
    public void DangNhap08() {
        //enter "Tên gian hàng"
        dangNhap.enterTenGianHang(DangNhapData.TEN_GIAN_HANG);
        //enter "Tên đăng nhập"
        dangNhap.enterTenDangNhap(DangNhapData.TEN_DANG_NHAP);
        //enter "Mật khẩu"
        dangNhap.enterMatKhau(DangNhapData.MAT_KHAU);
        //click "Quản lý" button
        dangNhap.clickQuanLy();
        //check "Tổng quan" dashboard visible
        tongQuan = PageGeneratorManager.getTongQuanPage(driver);
        System.out.print("Test Case 8: ");
        tongQuan.checkTongQuanPageVisible();
    }
}