package test_case.hang_hoa.danh_muc;

import action.Action;
import action.common.BaseTest;
import action.common.PageGeneratorManager;
import action.hang_hoa.DanhMuc;
import data.hang_hoa.DanhMucData;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ThemHangHoaTestCase extends BaseTest {
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
        action.getMessage();
    }

    @Test(description = "nhóm hàng is not selected", dependsOnMethods = {"ThemHangHoa01"})
    public void ThemHangHoa02() {
        danhMuc.enterTenHangThemHangHoa(DanhMucData.THEM_HANG_HOA_TEN_HANG);
        danhMuc.clickLuuThemHangHoa();
        System.out.print("Test Case 2: ");
        action.getMessage();
    }
}