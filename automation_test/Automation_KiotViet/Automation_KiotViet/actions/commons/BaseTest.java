package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    private WebDriver driver;

    private enum BROWSER {
        CHROME, EDGE, FIREFOX, IE
    }

    private enum PLATFORM {
        ANDROID, IOS, WINDOWN_PHONE
    }

    public WebDriver getBrowserDriver(String browserName, String url){
        BROWSER browser = BROWSER.valueOf(browserName.toUpperCase());
        if(browser == BROWSER.CHROME) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser == BROWSER.FIREFOX) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser == BROWSER.EDGE) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("Please enter correct browser name");
        }
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }



    public WebDriver getBrowserDriver(String browserName){
        BROWSER browser = BROWSER.valueOf(browserName.toUpperCase());
        if(browser == BROWSER.CHROME) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser == BROWSER.FIREFOX) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser == BROWSER.EDGE) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("Please enter correct browser name");
        }
        driver.manage().window().maximize();
        return driver;
    }


}


