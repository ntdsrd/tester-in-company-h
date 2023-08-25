package test_case.hang_hoa.danh_muc;

import action.Action;
import action.common.BaseTest;
import action.common.PageGeneratorManager;
import action.hang_hoa.DanhMuc;
import data.hang_hoa.DanhMucData;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class TimKiemTestCase extends BaseTest {
    WebDriver driver;
    Action action;
    DanhMuc danhMuc;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void initBrowser(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        action = PageGeneratorManager.getAction(driver);
        action.danhMucPrecondition();
        danhMuc = PageGeneratorManager.getDanhMuc(driver);
    }

    @AfterClass
    public void AfterTest() {
        driver.quit();
    }

    @Test(description = "tìm kiếm với mã hàng hóa")
    public void TimKiem01() {
        System.out.println("Test Case 1: ");
        danhMuc.timKiem(DanhMucData.TIM_KIEM_MA_HANG_HOA);
    }

    @Test(description = "tìm kiếm với mã hàng hóa không tồn tại", dependsOnMethods = {"TimKiem01"})
    public void TimKiem02() {
        System.out.println("Test Case 2: ");
        danhMuc.timKiem(DanhMucData.TIM_KIEM_MA_HANG_HOA_NON_EXIST);
    }
}