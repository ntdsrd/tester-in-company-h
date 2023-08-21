package TongQuan;

import Login.Login;
import PhongBan.PhongBan;
import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


public class TongQuan_01 extends BaseTest {
    WebDriver driver;
    Login login;
    PhongBan phongBan;

    @BeforeTest
    @Parameters({"browser", "url"})
    public void initBrowser(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        login.loginSuccessfully();
        phongBan = PageGeneratorManager.getPhongBanPage(driver);
        phongBan.diChuyenToiManHinhPhongBan();
    }


    @AfterTest
    public void AfterTest() {
        driver.quit();
    }

}
