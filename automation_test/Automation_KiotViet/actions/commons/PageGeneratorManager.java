package commons;

import Login.Login;
import PhongBan.PhongBan;
import TongQuan.TongQuan;
import TongQuan.TongQuan_01;
import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

    private  Login login;
    private TongQuan tongQuan;
    private PageGeneratorManager() {

    }

    public  static Login getLoginPage(WebDriver driver) {
        return new Login(driver);
    }

    public static TongQuan getTongQuanPage(WebDriver driver) {
        return new TongQuan(driver);
    }

    public static PhongBan getPhongBanPage(WebDriver driver) {
        return new PhongBan(driver);
    }

}
