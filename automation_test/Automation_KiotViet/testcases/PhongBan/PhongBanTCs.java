package PhongBan;

import Login.Login;
import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class PhongBanTCs extends BaseTest {
    WebDriver driver;
    Login login;
    PhongBan phongBan;

    @BeforeMethod
    @Parameters({"browser", "url"})
    public void initBrowser(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        phongBan = PageGeneratorManager.getPhongBanPage(driver);
        phongBan.diChuyenToiManHinhPhongBan();
    }

    @Test
    public void phongBan_01() {
        System.out.println("Hello Minh");
    }
    @Test
    public void phongBan_02() {
        System.out.println("Hello Minh");
    }
    @Test
    public void phongBan_03() {
        System.out.println("Hello Minh");
    }

    @AfterMethod(alwaysRun = true)
    public void AfterTest() {
        driver.quit();
    }
}
