package test_case.doi_tac.khach_hang;

import action.*;
import action.common.BaseTest;
import action.common.PageGeneratorManager;
import action.doi_tac.KhachHang;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class ThemKhachHangTestCase extends BaseTest {
    WebDriver driver;
    Action action;
    KhachHang khachHang;

    @Parameters({"browser", "url"})
    @BeforeMethod
    public void initBrowser(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        action = PageGeneratorManager.getAction(driver);
        action.khachHangPrecondition();
        khachHang = PageGeneratorManager.getKhachHang(driver);
        khachHang.clickKhachHang();
    }

    @AfterMethod
    public void AfterTest() {
        driver.quit();
    }

    @Test(description = "tên khách hàng is blank")
    public void ThemKhachHang01() {
        //do not enter any value in "Tên khách hàng" field
        khachHang.enterTenKhachHangThemKhachHang("");
        //click "Lưu" button
        khachHang.clickLuuThemKhachHang();
        //get message
        System.out.print("Test Case 1: ");
//        action.getMessage();
    }

    @Test(description = "thêm khách hàng successfully", dependsOnMethods = {"ThemKhachHang01"})
    public void ThemKhachHang02() {
        //enter value in "Tên khách hàng" field
        khachHang.enterTenKhachHangThemKhachHang("khách hàng");
        khachHang.enterNgaySinhThemKhachHang("03092000");
        //click "Lưu" button
        khachHang.clickLuuThemKhachHang();
        //get message
        System.out.print("Test Case 2: ");
//        action.getMessage();
    }
}