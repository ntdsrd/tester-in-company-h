package action.doi_tac;

import action.common.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import user_interface.Locator;
import user_interface.doi_tac.NhaCungCapLocator;

public class NhaCungCap extends BasePage {
    WebDriver driver;

    public NhaCungCap(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToNhaCungCap() {
        hoverToElement(driver, Locator.DOI_TAC);
        hoverToElement(driver, Locator.NHA_CUNG_CAP);
        clickToElement(driver, Locator.NHA_CUNG_CAP);
    }
//    public void check

    public void clickNhaCungCap() {
        clickToElement(driver, NhaCungCapLocator.NHA_CUNG_CAP);
    }

    public void enterTenNhaCungCap(String tenNhaCungCap) {
        sendKeyToElement(driver, NhaCungCapLocator.TEN_NHA_CUNG_CAP, tenNhaCungCap);
    }

    public void enterDienThoai(String dienThoai) {
        sendKeyToElement(driver, NhaCungCapLocator.DIEN_THOAI, dienThoai);
    }

    public void enterEmail(String email) {
        sendKeyToElement(driver, NhaCungCapLocator.EMAIL, email);
    }

    public void clickLuu() {
        clickToElement(driver, NhaCungCapLocator.LUU);
    }

    public void clickThemNhomNhaCungCap() {
        clickToElement(driver, NhaCungCapLocator.THEM_NHOM_NHA_CUNG_CAP);
    }

    public void enterTenNhomThemNhomNhaCungCap(String value) {
        sendKeyToElement(driver, NhaCungCapLocator.THEM_NHOM_NHA_CUNG_CAP_TEN_NHOM, value);
    }

    public void clickLuuThemNhomNhaCungCap() {
        clickToElement(driver, NhaCungCapLocator.THEM_NHOM_NHA_CUNG_CAP_LUU);
    }

    public void clickMaNhaCungCap(String code) {
        clickToElementByDynamicLocator(driver, NhaCungCapLocator.MA_NHA_CUNG_CAP_LIST, code);
    }

    public void clickAdditionButton(String code, String buttonName) {
        clickToElementByDynamicLocator(driver, NhaCungCapLocator.NHA_CUNG_CAP_BUTTON, code, buttonName);
    }

    public void clearField(String data) {
        clearElementByDynamicLocator(driver, NhaCungCapLocator.GENERAL_FIELD, data);
    }

    public void resetField(String field) {
        ctrlZ(driver, NhaCungCapLocator.GENERAL_FIELD, Keys.CONTROL, "Z", field);
    }
}
