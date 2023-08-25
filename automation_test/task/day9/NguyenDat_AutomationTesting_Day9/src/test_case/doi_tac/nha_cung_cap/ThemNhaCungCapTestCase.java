package test_case.doi_tac.nha_cung_cap;

import action.Action;
import action.common.BaseTest;
import action.common.PageGeneratorManager;
import action.doi_tac.NhaCungCap;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class ThemNhaCungCapTestCase extends BaseTest {
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
        nhaCungCap.clickNhaCungCap();
    }

    @AfterMethod(alwaysRun = true)
    public void AfterTest() {
        driver.quit();
    }

    @Test(description = "thêm nhà cung cấp with all fields are blank")
    public void ThemNhaCungCap01() {
        //click "Lưu" button
        nhaCungCap.clickLuu();
        //get message
        System.out.print("Test Case 1: ");
        action.getMessage("Bạn chưa nhập Tên nhà cung cấp");
    }

    @Test(description = "enter only tên nhà cung cấp", dependsOnMethods = {"ThemNhaCungCap01"})
    public void ThemNhaCungCap02() {
        //enter value in "Tên nhà cung cấp"
        nhaCungCap.enterTenNhaCungCap("nhà cung cấp");
        //click "Lưu" button
        nhaCungCap.clickLuu();
        //get message
        System.out.print("Test Case 2: ");
        action.getMessage("Bạn cần nhập số điện thoại hoặc email của nhà cung cấp");
    }

    @Test(description = "thêm nhà cung cấp with điện thoại", dependsOnMethods = {"ThemNhaCungCap02"})
    public void ThemNhaCungCap03() {
        //enter value in "Tên nhà cung cấp"
        nhaCungCap.enterTenNhaCungCap("nhà cung cấp 02");
        //enter value in "Điện thoại"
        nhaCungCap.enterDienThoai("0987654324");
        //click "Lưu" button
        nhaCungCap.clickLuu();
        //get message
        System.out.print("Test Case 3: ");
        action.getMessage("Thông tin nhà cung cấp được cập nhật thành công");
    }

    @Test(description = "thêm nhà cung cấp with điện thoại exist", dependsOnMethods = {"ThemNhaCungCap03"})
    public void ThemNhaCungCap04() {
        //enter value in "Tên nhà cung cấp"
        nhaCungCap.enterTenNhaCungCap("nhà cung cấp 03");
        //enter exist value in "Điện thoại"
        nhaCungCap.enterDienThoai("0987654321");
        //click "Lưu" button
        nhaCungCap.clickLuu();
        //get message
        System.out.print("Test Case 4: ");
        action.getMessage("Số điện thoại 0987654321 đã tồn tại trong hệ thống");
    }

    @Test(description = "thêm nhà cung cấp with email invalid", dependsOnMethods = {"ThemNhaCungCap04"})
    public void ThemNhaCungCap05() {
        //enter value in "Tên nhà cung cấp"
        nhaCungCap.enterTenNhaCungCap("nhà cung cấp 04");
        //enter invalid value in "Email"
        nhaCungCap.enterDienThoai("");
        nhaCungCap.enterEmail("email");
        //click "Lưu" button
        nhaCungCap.clickLuu();
        //get message
        System.out.print("Test Case 5: ");
        action.getMessage("Email không hợp lệ");
    }

    @Test(description = "thêm nhà cung cấp with email valid", dependsOnMethods = {"ThemNhaCungCap05"})
    public void ThemNhaCungCap06() {
        //enter value in "Tên nhà cung cấp"
        nhaCungCap.enterTenNhaCungCap("nhà cung cấp 05");
        //enter valid value in "Email"
        nhaCungCap.enterEmail("email@email.com");
        //click "Lưu" button
        nhaCungCap.clickLuu();
        //get message
        System.out.print("Test Case 6: ");
        action.getMessage("Thông tin nhà cung cấp được cập nhật thành công");
    }
}