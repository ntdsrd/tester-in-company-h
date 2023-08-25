package test_case.doi_tac.khach_hang;

import action.*;
import action.common.BaseTest;
import action.common.PageGeneratorManager;
import action.doi_tac.KhachHang;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class ThemNhomKhachHangTestCase extends BaseTest {
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
        khachHang.clickThemNhomKhachHang();
    }

    @AfterMethod
    public void AfterTest() {
        driver.quit();
    }

    @Test(description = "tên nhóm is blank")
    public void ThemNhomKhachHang01() {
        //do not enter any value in "Tên nhóm" field
        khachHang.enterTenNhomThemNhomKhachHang("");
        //click "Lưu" button
        khachHang.clickLuuThemNhomKhachHang();
        //get message
        System.out.print("Test Case 2: ");
        action.getMessage();
    }

    @Test(description = "thêm nhóm khách hàng successfully", dependsOnMethods = {"ThemNhomKhachHang01"})
    public void ThemNhomKhachHang02() {
        //enter value in "Tên nhóm" field
        khachHang.enterTenNhomThemNhomKhachHang("nhóm");
        //click "Lưu" button
        khachHang.clickLuuThemNhomKhachHang();
        //get message
        System.out.print("Test Case 2: ");
        action.getMessage();
    }

    @Test(description = "tên nhóm is exist", dependsOnMethods = {"ThemNhomKhachHang02"})
    public void ThemNhomKhachHang03() {
        //enter value in "Tên nhóm" field
        khachHang.enterTenNhomThemNhomKhachHang("nhóm");
        //click "Lưu" button
        khachHang.clickLuuThemNhomKhachHang();
        //get message
        System.out.print("Test Case 3: ");
        action.getMessage();
    }
}