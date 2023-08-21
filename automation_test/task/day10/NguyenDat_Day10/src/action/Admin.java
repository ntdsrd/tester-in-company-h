package action;

import action.common.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import user_interface.AdminLocator;

public class Admin extends BasePage {
    WebDriver driver;

    public Admin(WebDriver driver) {
        this.driver = driver;
    }

    public void checkAdminVisible() {
        if (isElementDisplayed(driver, AdminLocator.ADMIN_TITLE)) {
            System.out.println("Navigate to " + getTextOfElement(driver, AdminLocator.ADMIN_TITLE) + " successfully");
        } else {
            throw new RuntimeException();
        }
    }

    public void clickAddButton() {
        clickToElement(driver, AdminLocator.ADD_BUTTON);
    }

    public void addUser(String userRole, String employeeName, String status, String username, String password) {
        clickToElement(driver, AdminLocator.USER_ROLE);
        clickToElementByDynamicLocator(driver, AdminLocator.LIST_BOX, userRole);
        sendKeyToElement(driver, AdminLocator.EMPLOYEE_NAME, employeeName);
        clickToElementByDynamicLocator(driver, AdminLocator.LIST_BOX, employeeName);
        clickToElement(driver, AdminLocator.STATUS);
        clickToElementByDynamicLocator(driver, AdminLocator.LIST_BOX, status);
        sendKeyToElement(driver, AdminLocator.USERNAME, username);
        sendKeyToElement(driver, AdminLocator.PASSWORD, password);
        sendKeyToElement(driver, AdminLocator.CONFIRM_PASSWORD, password);
        sleep(5);
        clickToElement(driver, AdminLocator.SAVE_BUTTON);
        clickToElement(driver, AdminLocator.SAVE_BUTTON);
        sleep(3);
    }

    public void searchUser(String username) {
        sendKeyToElement(driver, AdminLocator.USERNAME, username);
        clickToElement(driver, AdminLocator.SEARCH_BUTTON);
    }

    public void verifyUser(String expected) {
        if (verifyEquals(getTextOfElementByDynamicLocator(driver, AdminLocator.SEARCH_USERNAME, expected), expected)) {
            System.out.println("User [" + expected + "] found");
        } else {
            System.out.println("User [" + expected + "] not found");
        }
    }
}
