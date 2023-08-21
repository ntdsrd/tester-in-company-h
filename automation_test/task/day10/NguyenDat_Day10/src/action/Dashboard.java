package action;

import action.common.BasePage;
import org.openqa.selenium.WebDriver;
import user_interface.DashboardLocator;

public class Dashboard extends BasePage {
    WebDriver driver;

    public Dashboard(WebDriver driver) {
        this.driver = driver;
    }

    public void checkDashboardVisible() {
        if (isElementDisplayed(driver, DashboardLocator.TITLE)) {
            System.out.println("Navigate to " + getTextOfElement(driver, DashboardLocator.TITLE) + " successfully");
        } else {
            throw new RuntimeException();
        }
    }

    public void clickAdminMenu() {
        clickToElement(driver, DashboardLocator.ADMIN_MENU);
    }
}
