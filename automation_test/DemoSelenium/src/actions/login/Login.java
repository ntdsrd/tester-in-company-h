import org.openqa.selenium.WebDriver;

public class Login extends BasePage{
    WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void nhapTenGianHang(String tenGianHang) {
        sendKeyToElement(driver, LoginUI.TEN_GIAN_HANG, tenGianHang);
    }

    public void nhapTenDangNhap(String tenDangNhap) {
        sendKeyToElement(driver, LoginUI.TEN_DANG_NHAP, tenDangNhap);
    }

    public void nhapMatKhau(String password) {
        sendKeyToElement(driver, LoginUI.MAT_KHAU, password);
    }

    public void clickButtonQuanLi() {
        clickToElement(driver, LoginUI.BUTTON_QUAN_LY);
    }
}
