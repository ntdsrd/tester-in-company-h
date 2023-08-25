package test_case.doi_tac.nha_cung_cap;

import action.Action;
import action.common.BaseTest;
import action.common.PageGeneratorManager;
import action.doi_tac.NhaCungCap;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class ThemNhomNhaCungCapTestCase extends BaseTest {
    WebDriver driver;
    Action action;
    NhaCungCap nhaCungCap;

    @Parameters({"browser", "url"})
    @BeforeMethod
    public void initBrowser(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        action = PageGeneratorManager.getAction(driver);
        action.nhaCungCapPrecondition();
        nhaCungCap = PageGeneratorManager.getNhaCungCap(driver);
        nhaCungCap.clickThemNhomNhaCungCap();
    }

    @AfterMethod(alwaysRun = true)
    public void AfterTest() {
        driver.quit();
    }

    @Test(description = "tên nhóm is blank")
    public void ThemNhomNhaCungCap01() {
        //click "Lưu" button
        nhaCungCap.clickLuuThemNhomNhaCungCap();
        //get message
        System.out.print("Test Case 1: ");
        action.getMessage("Bạn chưa nhập Tên nhóm");
    }

    @Test(description = "thêm nhóm nhà cung cấp successfully", dependsOnMethods = {"ThemNhomNhaCungCap01"})
    public void ThemNhomNhaCungCap02() {
        //enter "Tên nhóm"
        nhaCungCap.enterTenNhomThemNhomNhaCungCap("nhóm 1");
        //click "Lưu" button
        nhaCungCap.clickLuuThemNhomNhaCungCap();
        //get message
        System.out.print("Test Case 2: ");
        action.getMessage("Thêm mới nhóm nhà cung cấp thành công");
    }

    @Test(description = "tên nhóm is exist", dependsOnMethods = {"ThemNhomNhaCungCap02"})
    public void ThemNhomNhaCungCap03() {
        //enter exist "Tên nhóm"
        nhaCungCap.enterTenNhomThemNhomNhaCungCap("nhóm 1");
        //click "Lưu" button
        nhaCungCap.clickLuuThemNhomNhaCungCap();
        //get message
        System.out.print("Test Case 3: ");
        action.getMessage("Nhóm nhóm 1 đã tồn tại");
    }
}