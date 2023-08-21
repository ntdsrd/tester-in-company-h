package test_case;

import action.Admin;
import action.Dashboard;
import action.Login;
import action.Proxy;
import action.common.BaseTest;
import action.common.PageGenerateManager;
import data.LoginData;
import data.ProxyData;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase extends BaseTest {
    WebDriver driver;
    Proxy proxy;
    Login login;
    Dashboard dashboard;
    Admin admin;

    @BeforeClass
    public void initBrowser() {
        driver = getBrowserDriver();
        proxy = PageGenerateManager.getProxy(driver);
        login = PageGenerateManager.getLogin(driver);
        dashboard = PageGenerateManager.getDashboard(driver);
        admin = PageGenerateManager.getAdmin(driver);
        proxy.checkProxy(ProxyData.USERNAME, ProxyData.PASSWORD);
    }

    @AfterClass
    public void AfterTest() {
//        driver.quit();
    }

    @Test(description = "login successfully")
    public void TestCase01() {
        //enter username
        login.enterUsername(LoginData.USERNAME);
        //enter password
        login.enterPassword(LoginData.PASSWORD);
        //click submit button
        login.clickSubmitButton();
        //check dashboard visible
        System.out.print("Test Case 01: ");
        dashboard.checkDashboardVisible();
    }

    @Test(description = "create and delete user", dependsOnMethods = {"TestCase01"})
    public void TestCase02() {
        //click admin menu
        dashboard.clickAdminMenu();
        admin.checkAdminVisible();
        //click add button
        admin.clickAddButton();
        //add user
        admin.addUser("Admin", "Odis  Adalwin", "Enable", "username07", "Vietnam@12345");
        //search user
//        admin.searchUser("David.Morris");
        //verify user
        admin.verifyUser("David.Morris");
    }
}
