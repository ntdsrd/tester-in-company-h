package action.doi_tac;

import action.common.BasePage;
import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import user_interface.Locator;
import user_interface.doi_tac.KhachHangLocator;

public class KhachHang extends BasePage {
    WebDriver driver;
    Actions actions;

    public KhachHang(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToKhachHang() {
        hoverToElement(driver, Locator.DOI_TAC);
        SleepInSecond(1);
        hoverToElement(driver, Locator.KHACH_HANG);
        SleepInSecond(1);
        Verify.verify(isElementDisplayed(driver, Locator.KHACH_HANG));
        System.out.println("Go to the " + getElementText(driver, Locator.KHACH_HANG));
        clickToElement(driver, Locator.KHACH_HANG);
    }

    public void clickKhachHang() {
        clickToElement(driver, KhachHangLocator.KHACH_HANG);
    }

    public void enterTenKhachHangThemKhachHang(String value) {
        sendKeyToElement(driver, KhachHangLocator.THEM_KHACH_HANG_TEN_KHACH_HANG, value);
    }

    public void enterNgaySinhThemKhachHang(String dateOfBirth) {
        actions = new Actions(driver);
        actions.sendKeys(driver.findElement(By.xpath("//input[@ng-model='BirthDate']")), dateOfBirth).perform();
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