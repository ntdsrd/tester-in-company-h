import action.common.BaseTest;
import action.common.PageGeneratorManager;
import action.dang_nhap.DangNhap;
import data.ProxyData;
import action.Proxy;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test_case.dang_nhap.DangNhapTestCase;

public class Main extends BaseTest {
    WebDriver driver;
    Proxy proxy;
    DangNhap dangNhap;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void initBrowser(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        proxy = PageGeneratorManager.getProxyPage(driver);
        proxy.checkProxy(ProxyData.USERNAME, ProxyData.PASSWORD);
        dangNhap = PageGeneratorManager.getDangNhapPage(driver);
    }

    @Test()
    public void Test() {
        driver.get("https://www.guru99.com/execute-javascript-selenium-webdriver.html");
        dangNhap.jsClickToElement(driver, "//*[@id=\"post-1052\"]/div/div/nav/div/div/button");
    }

    @AfterClass
    public void AfterTest() {
//        driver.quit();
    }
}