package test_case.phong_ban;

import action.PhongBan;
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

public class ThemKhuVucTestCase extends BaseTest {
    WebDriver driver;
    Proxy proxy;
    DangNhap dangNhap;
    TongQuan tongQuan;
    PhongBan phongBan;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void initBrowser(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        proxy = PageGeneratorManager.getProxyPage(driver);
        proxy.checkProxy(ProxyData.USERNAME, ProxyData.PASSWORD);
        dangNhap = PageGeneratorManager.getDangNhapPage(driver);
        dangNhap.dangNhapAction(DangNhapData.TEN_GIAN_HANG, DangNhapData.TEN_DANG_NHAP, DangNhapData.MAT_KHAU);
        tongQuan = PageGeneratorManager.getTongQuanPage(driver);
        tongQuan.navigateToPhongBan();
        phongBan = PageGeneratorManager.getPhongBanPage(driver);
        phongBan.clickThemKhuVuc();
    }

    @AfterClass
    public void AfterTest() {
        driver.quit();
    }

    @Test(description = "tên khu vực is blank")
    public void ThemKhuVuc01() {
        phongBan.clickLuuThemKhuVuc();
        System.out.print("Test Case 1: ");
        tongQuan.getMessage();
    }

    @Test(description = "tên khu vực is exist", dependsOnMethods = {"ThemKhuVuc01"})
    public void ThemKhuVuc02() {
        phongBan.enterTenKhuVucThemKhuVuc("Lầu 3");
        phongBan.clickLuuThemKhuVuc();
        System.out.print("Test Case 2: ");
        tongQuan.getMessage();
    }

    @Test(description = "thêm khu vực successfully", dependsOnMethods = {"ThemKhuVuc02"})
    public void ThemKhuVuc03() {
        phongBan.enterTenKhuVucThemKhuVuc("kv2");
        phongBan.clickLuuThemKhuVuc();
        System.out.print("Test Case 3: ");
        tongQuan.getMessage();
    }
}