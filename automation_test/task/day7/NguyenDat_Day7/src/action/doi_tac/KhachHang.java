package action.doi_tac;

import action.common.BasePage;
import org.openqa.selenium.WebDriver;
import user_interface.Locator;
import user_interface.doi_tac.KhachHangLocator;

public class KhachHang extends BasePage {
    WebDriver driver;

    public KhachHang(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToKhachHang() {
        hoverToElement(driver, Locator.DOI_TAC);
        SleepInSecond(1);
        hoverToElement(driver, Locator.KHACH_HANG);
        SleepInSecond(1);
        System.out.println("Go to the " + getElementText(driver, Locator.KHACH_HANG));
        clickToElement(driver, Locator.KHACH_HANG);
    }

    public void clickKhachHang() {
        clickToElement(driver, KhachHangLocator.KHACH_HANG);
    }

    public void enterTenKhachHangThemKhachHang(String value) {
        sendKeyToElement(driver, KhachHangLocator.THEM_KHACH_HANG_TEN_KHACH_HANG, value);
    }

    public void clickLuuThemKhachHang() {
        clickToElement(driver, KhachHangLocator.THEM_KHACH_HANG_LUU);
    }

    public void clickThemNhomKhachHang() {
        clickToElement(driver, KhachHangLocator.THEM_NHOM_KHACH_HANG);
    }

    public void enterTenNhomThemNhomKhachHang(String value) {
        sendKeyToElement(driver, KhachHangLocator.THEM_NHOM_KHACH_HANG_TEN_NHOM, value);
    }

    public void clickLuuThemNhomKhachHang() {
        clickToElement(driver, KhachHangLocator.THEM_NHOM_KHACH_HANG_LUU);
    }
}