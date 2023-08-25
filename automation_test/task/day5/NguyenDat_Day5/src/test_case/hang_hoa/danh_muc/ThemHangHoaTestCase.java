package test_case.hang_hoa.danh_muc;

import action.Proxy;
import action.common.BaseTest;
import action.common.PageGeneratorManager;
import action.DangNhap;
import action.hang_hoa.DanhMuc;
import action.TongQuan;
import data.DangNhapData;
import data.ProxyData;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ThemHangHoaTestCase extends BaseTest {
    WebDriver driver;
    Proxy proxy;
    DangNhap dangNhap;
    TongQuan tongQuan;
    DanhMuc danhMuc;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void initBrowser(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        proxy = PageGeneratorManager.getProxyPage(driver);
        proxy.checkProxy(ProxyData.USERNAME, ProxyData.PASSWORD);
        dangNhap = PageGeneratorManager.getDangNhapPage(driver);
        dangNhap.dangNhapAction(DangNhapData.TEN_GIAN_HANG, DangNhapData.TEN_DANG_NHAP, DangNhapData.MAT_KHAU);
        tongQuan = PageGeneratorManager.getTongQuanPage(driver);
        tongQuan.navigateToDanhMuc();
        danhMuc = PageGeneratorManager.getDanhMucPage(driver);
        danhMuc.themHangHoa();
    }

    @AfterClass
    public void AfterTest() {
        driver.quit();
    }

    @Test(description = "all fields are blank")
    public void ThemHangHoa01() {
        danhMuc.clickLuuThemHangHoa();
        System.out.print("Test Case 1: ");
        tongQuan.getMessage();
    }

    @Test(description = "nhóm hàng is not selected", dependsOnMethods = {"ThemHangHoa01"})
    public void ThemHangHoa02() {
        danhMuc.enterTenHangThemHangHoa("tea");
        danhMuc.clickLuuThemHangHoa();
        System.out.print("Test Case 2: ");
        tongQuan.getMessage();
    }
}