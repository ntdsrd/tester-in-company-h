package Login;

import commons.BaseTest;
import commons.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import java.io.File;

public class Login_01 extends BaseTest {
    public String proJectLocation = System.getProperty("user.dir");
    WebDriver driver;
    Actions action;

    public String getSlash (String folderName){
        String separator = File.separator;
        return separator + folderName + separator;
    }

    @Parameters({"browser", "url"})
    @Test
    public void initBrowser(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
    }
    @Test (priority = 2)
    public void Login_01_Dang_Nhap_Thanh_Cong () {
        //driver.get("https://fnb.kiotviet.vn/autotest111");
        driver.findElement(By.xpath(LoginUI.TEN_GIAN_HANG)).sendKeys(GlobalConstants.TEN_GIAN_HANG);
        SleepInSecond(1);
        driver.findElement(By.xpath(LoginUI.TEN_DANG_NHAP)).sendKeys(GlobalConstants.TEN_DANG_NHAP);
        SleepInSecond(1);
        driver.findElement(By.xpath(LoginUI.MAT_KHAU)).sendKeys(GlobalConstants.MAT_KHAU);
        SleepInSecond(1);
        driver.findElement(By.xpath(LoginUI.BUTTON_QUAN_LY)).click();

        // Login
        SleepInSecond(10);
        action = new Actions(driver);
        action.clickAndHold(driver.findElement(By.xpath("//a[contains(text(),'Phòng/Bàn')]"))).perform();

        driver.findElement(By.xpath("//a[contains(text(),'Phòng/Bàn')]")).click();
        SleepInSecond(10);
//        driver.findElement(By.xpath("//span[contains(text(),'Thêm mới')]")).click();
//
//        driver.quit();
    }


    public void SleepInSecond(int second)   {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
