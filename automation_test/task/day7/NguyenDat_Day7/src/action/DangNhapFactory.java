package action;

import action.common.BasePage;
import action.common.BasePageFactory;
import data.DangNhapData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import user_interface.DangNhapLocator;

public class DangNhapFactory extends BasePageFactory {
    WebDriver driver;

    @FindBy(xpath = "//input[@id='Retailer']")
    WebElement ten_gian_hang;
    @FindBy(xpath = "//input[@id='UserName']")
    WebElement ten_dang_nhap;
    @FindBy(xpath = "//input[@id='Password']")
    WebElement mat_khau;
    @FindBy(xpath = "//button[text()='Quản lý']")
    WebElement quan_ly;
    @FindBy(xpath = "//div[@class='validation-summary-errors']/descendant::li")
    WebElement error_message;

    public DangNhapFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterTenGianHang(String tenGianHang) {
        sendKeyToElement(driver, ten_gian_hang, tenGianHang);
    }

    public void enterTenDangNhap(String tenDangNhap) {
        sendKeyToElement(driver, ten_dang_nhap, tenDangNhap);
    }

    public void enterMatKhau(String matKhau) {
        sendKeyToElement(driver, mat_khau, matKhau);
    }

    public void clickQuanLy() {
        clickToElement(driver, quan_ly);
    }

    public void getErrorMessage() {
        SleepInSecond(3);
        System.out.println(getElementText(driver, error_message));
    }

    public void compareMessage(String message) {
        System.out.println("Expected message as same as actual message: " + compareMessage(driver, error_message, message));
    }

    public void dangNhap(String tenGianHang, String tenDangNhap, String matKhau) {
        enterTenGianHang(tenGianHang);
        SleepInSecond(1);
        enterTenDangNhap(tenDangNhap);
        SleepInSecond(1);
        enterMatKhau(matKhau);
        SleepInSecond(1);
        clickQuanLy();
    }
}