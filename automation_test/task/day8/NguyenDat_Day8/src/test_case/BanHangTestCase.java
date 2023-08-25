package test_case;

import action.Action;
import action.BanHang;
import action.common.BaseTest;
import action.common.PageGeneratorManager;
import data.BanHangData;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BanHangTestCase extends BaseTest {
    WebDriver driver;
    Action action;
    BanHang banHang;

    @Parameters({"browser", "url"})
    @BeforeMethod
    public void initBrowser(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        action = PageGeneratorManager.getAction(driver);
        action.loginToBanHang();
        banHang = PageGeneratorManager.getBanHang(driver);
    }

    @AfterClass
    public void AfterTest() {
        driver.quit();
    }

    @Test(description = "thanh toán mang về")
    public void BanHang01() {
        banHang.chooseAction(BanHangData.MANG_VE);
        banHang.switchTo(BanHangData.THUC_DON);
        banHang.selectMenu(BanHangData.MILANO);
        banHang.clickButton(BanHangData.THANH_TOAN);
    }
}