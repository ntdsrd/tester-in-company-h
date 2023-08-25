package test_case.phong_ban;

import action.*;
import action.common.BaseTest;
import action.common.PageGeneratorManager;
import data.PhongBanData;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class ThemKhuVucTestCase extends BaseTest {
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
        phongBan.clickThemKhuVuc();
    }

    @AfterMethod
    public void AfterTest() {
        driver.quit();
    }

    @Test(description = "tên khu vực is blank")
    public void ThemKhuVuc01() {
        phongBan.clickLuuThemKhuVuc();
        System.out.print("Test Case 1: ");
        action.getMessage();
    }

    @Test(description = "tên khu vực is exist", dependsOnMethods = {"ThemKhuVuc01"})
    public void ThemKhuVuc02() {
        phongBan.enterTenKhuVucThemKhuVuc(PhongBanData.THEM_KHU_VUC_TEN_KHU_VUC_EXIST);
        phongBan.clickLuuThemKhuVuc();
        System.out.print("Test Case 2: ");
        action.getMessage();
    }

    @Test(description = "thêm khu vực successfully", dependsOnMethods = {"ThemKhuVuc02"})
    public void ThemKhuVuc03() {
        phongBan.enterTenKhuVucThemKhuVuc(PhongBanData.THEM_KHU_VUC_TEN_KHU_VUC);
        phongBan.clickLuuThemKhuVuc();
        System.out.print("Test Case 3: ");
        action.getMessage();
    }
}