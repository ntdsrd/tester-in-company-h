package test_case.doi_tac.nha_cung_cap;

import action.Action;
import action.common.BaseTest;
import action.common.PageGeneratorManager;
import action.doi_tac.NhaCungCap;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class ThemNhaCungCapTestCase extends BaseTest {
    WebDriver driver;
    Action action;
    NhaCungCap nhaCungCap;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void initBrowser(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        action = PageGeneratorManager.getAction(driver);
        action.nhaCungCapPrecondition("Navigate to Nhà Cung Cấp");
        nhaCungCap = PageGeneratorManager.getNhaCungCap(driver);
        nhaCungCap.clickNhaCungCap();
    }

    @AfterClass(alwaysRun = true)
    public void AfterTest() {
        driver.quit();
        action.sortAssertAll();
    }

    @Test(description = "thêm nhà cung cấp with all fields are blank")
    public void ThemNhaCungCap01() {
        //click "Lưu" button
        nhaCungCap.clickLuu();
        //get message
        action.getMessage("Bạn chưa nhập Tên nhà cung cấp", "Test Case 1:");
    }

    @Test(description = "enter only tên nhà cung cấp", dependsOnMethods = {"ThemNhaCungCap01"})
    public void ThemNhaCungCap02() {
        //enter value in "Tên nhà cung cấp"
        nhaCungCap.enterTenNhaCungCapThemNhaCungCap("nhà cung cấp");
        //click "Lưu" button
        nhaCungCap.clickLuu();
        //get message
//        System.out.print("Test Case 2: ");
        action.getMessage("Bạn cần nhập số điện thoại hoặc email của nhà cung cấp", "Test Case 2:");
    }

    @Test(description = "thêm nhà cung cấp with điện thoại", dependsOnMethods = {"ThemNhaCungCap02"})
    public void ThemNhaCungCap03() {
        //enter value in "Tên nhà cung cấp"
        nhaCungCap.enterTenNhaCungCapThemNhaCungCap("nhà cung cấp 02");
        //enter value in "Điện thoại"
        nhaCungCap.enterDienThoai("0987654322");
        //click "Lưu" button
        nhaCungCap.clickLuu();
        //get message
        action.getMessage("Thông tin nhà cung cấp được cập nhật thành công", "Test Case 3:");
    }

    @Test(description = "thêm nhà cung cấp with điện thoại exist", dependsOnMethods = {"ThemNhaCungCap03"})
    public void ThemNhaCungCap04() {
        //enter value in "Tên nhà cung cấp"
        nhaCungCap.enterTenNhaCungCapThemNhaCungCap("nhà cung cấp 03");
        //enter exist value in "Điện thoại"
        nhaCungCap.enterDienThoai("0987654321");
        //click "Lưu" button
        nhaCungCap.clickLuu();
        //get message
//        System.out.print("Test Case 4: ");
        action.getMessage("Số điện thoại 0987654321 đã tồn tại trong hệ thống", "Test Case 4:");
    }

    @Test(description = "thêm nhà cung cấp with email invalid", dependsOnMethods = {"ThemNhaCungCap04"})
    public void ThemNhaCungCap05() {
        //enter value in "Tên nhà cung cấp"
        nhaCungCap.enterTenNhaCungCapThemNhaCungCap("nhà cung cấp 04");
        //enter invalid value in "Email"
        nhaCungCap.enterDienThoai("");
        nhaCungCap.enterEmail("email");
        //click "Lưu" button
        nhaCungCap.clickLuu();
        //get message
//        System.out.print("Test Case 5: ");
        action.getMessage("Email không hợp lệ", "Test Case 5:");
    }

    @Test(description = "thêm nhà cung cấp with email valid", dependsOnMethods = {"ThemNhaCungCap05"})
    public void ThemNhaCungCap06() {
        //enter value in "Tên nhà cung cấp"
        nhaCungCap.enterTenNhaCungCapThemNhaCungCap("nhà cung cấp 05");
        //enter valid value in "Email"
        nhaCungCap.enterEmail("email@email.com");
        //click "Lưu" button
        nhaCungCap.clickLuu();
        //get message
//        System.out.print("Test Case 6: ");
        action.getMessage("Thông tin nhà cung cấp được cập nhật thành công", "Test Case 6:");
    }
}