package action.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;

    public enum BROWSER {
        CHROME, EDGE;
    }

    public WebDriver getBrowserDriver() {
        BROWSER browser = BROWSER.valueOf(GlobalConstant.BROWSER_NAME.toUpperCase());
        if (browser == BROWSER.CHROME) {
            System.setProperty("webdriver.chrome.driver", GlobalConstant.PROPERTY_VALUE.concat("chromedriver"));
            driver = new ChromeDriver();
        } else if (browser == BROWSER.EDGE) {
            System.setProperty("webdriver.edge.driver", GlobalConstant.PROPERTY_VALUE.concat("msedgedriver.exe"));
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("Please enter correct browser name");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstant.LONG_TIMEOUT));
        driver.manage().window().maximize();
        driver.get(GlobalConstant.URL);
        return driver;
    }
}