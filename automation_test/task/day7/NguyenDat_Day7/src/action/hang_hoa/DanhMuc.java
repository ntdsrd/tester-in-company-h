package action.hang_hoa;

import action.common.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import user_interface.Locator;
import user_interface.hang_hoa.DanhMucLocator;

public class DanhMuc extends BasePage {
    WebDriver driver;

    public DanhMuc(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToDanhMuc() {
        hoverToElement(driver, Locator.HANG_HOA);
        SleepInSecond(1);
        hoverToElement(driver, Locator.HANG_HOA_DANH_MUC);
        SleepInSecond(1);
        System.out.println("Go to the " + getElementText(driver, Locator.HANG_HOA_DANH_MUC));
        clickToElement(driver, Locator.HANG_HOA_DANH_MUC);
    }

    public void timKiem(String value) {
        sendKeyToElement(driver, DanhMucLocator.TIM_KIEM, value);
        SleepInSecond(1);
        pressKey(driver, Keys.ENTER);
        releaseKey(driver, Keys.ENTER);
        SleepInSecond(1);
        if (isElementDisplayed(driver, DanhMucLocator.TIM_KIEM_RESULT)) {
            if (value.toUpperCase().equals(getElementText(driver, DanhMucLocator.TIM_KIEM_RESULT))) {
                System.out.println("Tìm kiếm: " + value + "\nKết quả: " + getElementText(driver, DanhMucLocator.TIM_KIEM_RESULT_NAME));
            } else {
                System.out.println("Tìm kiếm: " + value + "\nKết quả: Không có hàng hóa phù hợp");
            }
        } else if (isElementDisplayed(driver, DanhMucLocator.TIM_KIEM_NO_DATA)) {
            System.out.println("Tìm kiếm: " + value + "\nKết quả: Không có hàng hóa phù hợp");
        } else {
            System.out.println("System error");
        }
    }

    public void themHangHoa() {
        hoverToElement(driver, DanhMucLocator.THEM_MOI);
        SleepInSecond(1);
        hoverToElement(driver, DanhMucLocator.THEM_MOI_THEM_HANG_HOA);
        SleepInSecond(1);
        clickToElement(driver, DanhMucLocator.THEM_MOI_THEM_HANG_HOA);
    }

    public void enterTenHangThemHangHoa(String value) {
        sendKeyToElement(driver, DanhMucLocator.THEM_HANG_HOA_TEN_HANG, value);
    }

    public void clickLuuThemHangHoa() {
        jsScrollToBelowElement(driver, DanhMucLocator.THEM_HANG_HOA_LUU);
        SleepInSecond(1);
        clickToElement(driver, DanhMucLocator.THEM_HANG_HOA_LUU);
    }
}