package test_case.phong_ban;

import action.*;
import action.common.BaseTest;
import action.common.PageGeneratorManager;
import data.PhongBanData;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class TimKiemTestCase extends BaseTest {
    WebDriver driver;
    Action action;
    PhongBan phongBan;

    @Parameters({"browser", "url"})
    @BeforeMethod
    public void initBrowser(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        action = PageGeneratorManager.getAction(driver);
        action.phongBanPrecondition();
        phongBan = PageGeneratorManager.getPhongBan(driver);
    }

    @AfterMethod
    public void AfterTest() {
        driver.quit();
    }

    @Test(description = "tìm kiếm với tên phòng/bàn")
    public void TimKiem01() {
        System.out.println("Test Case 1: ");
        phongBan.timKiem(PhongBanData.TIM_KIEM_TEN_PHONG_BAN);
    }

    @Test(description = "tìm kiếm với tên phòng bàn không tồn tại", dependsOnMethods = {"TimKiem01"})
    public void TimKiem02() {
        System.out.println("Test Case 2: ");
        phongBan.timKiem(PhongBanData.TIM_KIEM_TEN_PHONG_BAN_NON_EXIST);
    }
}