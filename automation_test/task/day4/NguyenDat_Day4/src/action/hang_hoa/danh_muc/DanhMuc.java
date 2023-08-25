package action.hang_hoa.danh_muc;

import action.common.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import user_interface.hang_hoa.danh_muc.DanhMucLocator;

public class DanhMuc extends BasePage {
    WebDriver driver;

    public DanhMuc(WebDriver driver) {
        this.driver = driver;
    }

    public void checkDanhMucPageVisible() {
        System.out.println("Go to the " + driver.getTitle());
    }

    public void timKiem(String value) {
        sendKeyToElement(driver, DanhMucLocator.TIM_KIEM, value);
        SleepInSecond(1);
        pressKey(driver, Keys.ENTER);
        releaseKey(driver, Keys.ENTER);
        SleepInSecond(1);
        if (value.toUpperCase().equals(getElementText(driver, DanhMucLocator.TIM_KIEM_RESULT))) {
            System.out.println("Tìm kiếm: " + value + "\nKết quả: " + getElementText(driver, DanhMucLocator.TIM_KIEM_RESULT_NAME));
        } else {
            System.out.println("Tìm kiếm: " + value + "\nKết quả: Không có hàng hóa phù hợp");
        }
    }

    public void themHangHoa() {
        hoverToElement(driver, DanhMucLocator.THEM_MOI_BUTTON);
        SleepInSecond(1);
        hoverToElement(driver, DanhMucLocator.THEM_MOI_THEM_HANG_HOA);
        SleepInSecond(1);
        clickToElement(driver, DanhMucLocator.THEM_MOI_THEM_HANG_HOA);
    }

    public void enterTenHangThemHangHoa(String value) {
        sendKeyToElement(driver, DanhMucLocator.THEM_HANG_HOA_TEN_HANG, value);
    }

    public void clickLuuButtonThemHangHoa() {
        jsScrollToBelowElement(driver, DanhMucLocator.THEM_HANG_HOA_LUU_BUTTON);
        clickToElement(driver, DanhMucLocator.THEM_HANG_HOA_LUU_BUTTON);
    }

    public void getErrorMessage() {
        SleepInSecond(5);
        System.out.println(getElementText(driver, DanhMucLocator.ERROR_MESSAGE));
    }

    public void compareMessage(String message) {
        System.out.println("Expected message as same as actual message: " + compareMessage(driver, DanhMucLocator.ERROR_MESSAGE, message));
    }
}
