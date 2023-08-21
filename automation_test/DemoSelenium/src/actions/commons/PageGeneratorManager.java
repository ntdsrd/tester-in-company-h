
import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    private Login login;
    private TongQuan tongQuan;

    public PageGeneratorManager() {

    }

    public Login getLoginPage(WebDriver driver) {
        if (login == null) {
            login = new Login(driver);
        }
        return login;
    }

    public TongQuan getTongQuanPage(WebDriver driver) {
        if (tongQuan == null) {
            tongQuan = new TongQuan(driver);
        }
        return tongQuan;
    }
}
