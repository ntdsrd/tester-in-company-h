package test_case.doi_tac.nha_cung_cap;

import action.Action;
import action.common.BaseTest;
import action.common.PageGeneratorManager;
import action.doi_tac.NhaCungCap;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class CapNhatNhaCungCapTestCase extends BaseTest {
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
        //bấm vào mã nhà cung cấp
        nhaCungCap.clickMaNhaCungCap("NCC000038");
        //bấm vào nút cập nhật
        nhaCungCap.clickAdditionButton("NCC000038", "Cập nhật");
    }

    @AfterMethod(alwaysRun = true)
    public void AfterTest() {
        driver.quit();
    }

    @Test(description = "cập nhật nhà cung cấp với mã nhà cung cấp để trống")
    public void CapNhatNhaCungCap01() {
        //xóa mã nhà cung cấp
        nhaCungCap.clearField("supplier.Code");
        //bấm lưu
        nhaCungCap.clickLuu();
        //get message
        System.out.print("Test Case 1: ");
        action.getMessage("Mã nhà cung cấp không được để trống");
//        //reset field
//        nhaCungCap.resetField("supplier.Code");
    }

    @Test(description = "cập nhật nhà cung cấp với tên nhà cung cấp để trống", dependsOnMethods = {"CapNhatNhaCungCap01"})
    public void CapNhatNhaCungCap02() {
        //xóa tên nhà cung cấp
        nhaCungCap.clearField("supplier.Name");
        //bấm lưu
        nhaCungCap.clickLuu();
        //get message
        System.out.print("Test Case 2: ");
        action.getMessage("Bạn chưa nhập Tên nhà cung cấp");
//        //reset field
//        nhaCungCap.resetField("supplier.Name");
    }

    @Test(description = "cập nhật nhà cung cấp với email và điện thoại để trống", dependsOnMethods = {"CapNhatNhaCungCap02"})
    public void CapNhatNhaCungCap03() {
        //xóa điện thoại
        nhaCungCap.clearField("supplier.Phone");
        //xóa email
        nhaCungCap.clearField("supplier.Email");
        //bấm lưu
        nhaCungCap.clickLuu();
        //get message
        System.out.print("Test Case 3: ");
        action.getMessage("Bạn cần nhập số điện thoại hoặc email của nhà cung cấp");
//        //reset field
//        nhaCungCap.resetField("supplier.Phone");
//        nhaCungCap.resetField("supplier.Email");
    }
}