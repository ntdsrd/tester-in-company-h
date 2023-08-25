package action;

import action.common.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import user_interface.Locator;
import user_interface.hang_hoa.DanhMucLocator;
import user_interface.PhongBanLocator;

public class PhongBan extends BasePage {
    WebDriver driver;

    public PhongBan(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToPhongBan() {
        hoverToElement(driver, Locator.PHONG_BAN);
        SleepInSecond(1);
        clickToElement(driver, Locator.PHONG_BAN);
        System.out.println("Go to the " + getElementText(driver, Locator.PHONG_BAN));
    }

    public void clickThemKhuVuc() {
        clickToElement(driver, PhongBanLocator.THEM_KHU_VUC);
    }

    public void enterTenKhuVucThemKhuVuc(String value) {
        sendKeyToElement(driver, PhongBanLocator.THEM_KHU_VUC_TEN_KHU_VUC, value);
    }

    public void clickLuuThemKhuVuc() {
        clickToElement(driver, PhongBanLocator.THEM_KHU_VUC_LUU);
    }

    public void timKiem(String value) {
        sendKeyToElement(driver, PhongBanLocator.TIM_KIEM, value);
        SleepInSecond(1);
        pressKey(driver, Keys.ENTER);
        releaseKey(driver, Keys.ENTER);
        SleepInSecond(1);
        if (isElementDisplayed(driver, PhongBanLocator.TIM_KIEM_RESULT)) {
            if (value.toUpperCase().equals(getElementText(driver, PhongBanLocator.TIM_KIEM_RESULT))) {
                System.out.println("Tìm kiếm: " + value + "\nKết quả: " + getElementText(driver, DanhMucLocator.TIM_KIEM_RESULT_NAME));
            } else {
                System.out.println("Tìm kiếm: " + value + "\nKết quả: Không tìm thấy kết quả nào phù hợp");
            }
        } else if (isElementDisplayed(driver, PhongBanLocator.TIM_KIEM_NO_DATA)) {
            System.out.println("Tìm kiếm: " + value + "\nKết quả: Không tìm thấy kết quả nào phù hợp");
        } else {
            System.out.println("System error");
        }
    }
}