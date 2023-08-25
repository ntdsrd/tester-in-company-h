package action.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;

    private enum BROWSER {
        CHROME, EDGE;
    }

    public WebDriver getBrowserDriver(String browserName, String url) {
        BROWSER browser = BROWSER.valueOf(browserName.toUpperCase());
        if (browser == BROWSER.CHROME) {
            System.setProperty("webdriver.chrome.driver", GlobalConstant.PROPERTY_VALUE.concat("chromedriver.exe"));
            driver = new ChromeDriver();
        } else if (browser == BROWSER.EDGE) {
            System.setProperty("webdriver.edge.driver", GlobalConstant.PROPERTY_VALUE.concat("msedgedriver.exe"));
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("Please enter correct browser name");
        }
        driver.manage().timeouts().implicitlyWait(GlobalConstant.LONG_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }
}