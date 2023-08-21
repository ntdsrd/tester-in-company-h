package action.common;

import action.Admin;
import action.Dashboard;
import action.Login;
import action.Proxy;
import org.openqa.selenium.WebDriver;

public class PageGenerateManager {
    public static Proxy proxy;
    public static Login login;
    public static Dashboard dashboard;
    public static Admin admin;

    public static Proxy getProxy(WebDriver driver) {
        return proxy = new Proxy(driver);
    }

    public static Login getLogin(WebDriver driver) {
        return login = new Login(driver);
    }

    public static Dashboard getDashboard(WebDriver driver) {
        return dashboard = new Dashboard(driver);
    }

    public static Admin getAdmin(WebDriver driver) {
        return admin = new Admin(driver);
    }
}
