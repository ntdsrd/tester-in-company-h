package action.dang_nhap;

import action.common.BasePage;
import org.openqa.selenium.WebDriver;
import user_interface.dang_nhap.DangNhapLocator;

public class DangNhap extends BasePage {
    WebDriver driver;

    public DangNhap(WebDriver driver) {
        this.driver = driver;
    }

    public void enterTenGianHang(String tenGianHang) {
        sendKeyToElement(driver, DangNhapLocator.TEN_GIAN_HANG, tenGianHang);
    }

    public void enterTenDangNhap(String tenDangNhap) {
        sendKeyToElement(driver, DangNhapLocator.TEN_DANG_NHAP, tenDangNhap);
    }

    public void enterMatKhau(String matKhau) {
        sendKeyToElement(driver, DangNhapLocator.MAT_KHAU, matKhau);
    }

    public void clickQuanLyButton() {
        clickToElement(driver, DangNhapLocator.QUAN_LY);
    }

    public void getErrorMessage() {
        SleepInSecond(5);
        System.out.println(getElementText(driver, DangNhapLocator.ERROR_MESSAGE));
    }

    public void compareMessage(String message) {
        System.out.println("Expected message as same as actual message: " + compareMessage(driver, DangNhapLocator.ERROR_MESSAGE, message));
    }

    public void dangNhapFull(String tenGianHang, String tenDangNhap, String matKhau) {
        enterTenGianHang(tenGianHang);
        enterTenDangNhap(tenDangNhap);
        enterMatKhau(matKhau);
        clickQuanLyButton();
    }
}
