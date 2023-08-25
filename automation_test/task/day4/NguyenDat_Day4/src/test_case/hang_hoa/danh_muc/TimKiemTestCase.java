package test_case.hang_hoa.danh_muc;

import action.Proxy;
import action.common.BaseTest;
import action.common.PageGeneratorManager;
import action.dang_nhap.DangNhap;
import action.hang_hoa.danh_muc.DanhMuc;
import action.tong_quan.TongQuan;
import data.DangNhapData;
import data.ProxyData;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TimKiemTestCase extends BaseTest {
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
        dangNhap.dangNhapFull(DangNhapData.TEN_GIAN_HANG, DangNhapData.TEN_DANG_NHAP, DangNhapData.MAT_KHAU);
        tongQuan = PageGeneratorManager.getTongQuanPage(driver);
        tongQuan.navigateToDanhMuc();
        danhMuc = PageGeneratorManager.getDanhMucPage(driver);
        danhMuc.checkDanhMucPageVisible();
    }

    @Test(description = "tìm kiếm với mã hàng hóa")
    public void TimKiem01() {
        System.out.println("Test Case 1: ");
        danhMuc.timKiem("sp000074");
    }

    @Test(description = "tìm kiếm với mã hàng hóa không tồn tại", dependsOnMethods = {"TimKiem01"})
    public void TimKiem02() {
        System.out.println("Test Case 2: ");
        danhMuc.timKiem("abc");
    }

    @AfterClass
    public void AfterTest() {
        driver.quit();
    }
}
