package action.doi_tac;

import action.common.BasePage;
import org.openqa.selenium.WebDriver;
import user_interface.Locator;
import user_interface.doi_tac.NhaCungCapLocator;

public class NhaCungCap extends BasePage {
    WebDriver driver;

    public NhaCungCap(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToNhaCungCap(String message) {
        hoverToElement(driver, Locator.DOI_TAC);
        hoverToElement(driver, Locator.NHA_CUNG_CAP);
        clickToElement(driver, Locator.NHA_CUNG_CAP);
        sortAssertTrue(isElementDisplayed(driver, NhaCungCapLocator.NHA_CUNG_CAP_TEXT), message);
//        sortAssertAll();
    }

    public void clickNhaCungCap() {
        clickToElement(driver, NhaCungCapLocator.NHA_CUNG_CAP);
    }

    public void enterTenNhaCungCapThemNhaCungCap(String tenNhaCungCap) {
        sendKeyToElement(driver, NhaCungCapLocator.THEM_NHA_CUNG_CAP_TEN_NHA_CUNG_CAP, tenNhaCungCap);
    }

    public void enterDienThoai(String dienThoai) {
        sendKeyToElement(driver, NhaCungCapLocator.THEM_NHA_CUNG_CAP_DIEN_THOAI, dienThoai);
    }

    public void enterEmail(String email) {
        sendKeyToElement(driver, NhaCungCapLocator.THEM_NHA_CUNG_CAP_EMAIL, email);
    }

    public void clickLuu() {
        clickToElement(driver, NhaCungCapLocator.THEM_NHA_CUNG_CAP_LUU);
    }

    public void clickThemNhomNhaCungCap() {
        clickToElement(driver, NhaCungCapLocator.THEM_NHOM_NHA_CUNG_CAP);
    }

}
