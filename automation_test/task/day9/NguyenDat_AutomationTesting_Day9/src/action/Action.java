package action;

import action.common.BasePage;
import action.common.PageGeneratorManager;
import action.doi_tac.KhachHang;
import action.doi_tac.NhaCungCap;
import action.hang_hoa.DanhMuc;
import data.DangNhapData;
import data.ProxyData;
import org.openqa.selenium.WebDriver;
import user_interface.DangNhapLocator;
import user_interface.Locator;
import user_interface.doi_tac.NhaCungCapLocator;

public class Action extends BasePage {
    WebDriver driver;
    Proxy proxy;
    DangNhap dangNhap;
    DanhMuc danhMuc;
    PhongBan phongBan;
    KhachHang khachHang;
    NhaCungCap nhaCungCap;

    public Action(WebDriver driver) {
        this.driver = driver;
    }

    public void checkPageVisible(String locator) {
        if (verifyTrue(isElementDisplayed(driver, locator))) {
            System.out.println("Navigate to " + getElementText(driver, locator));
        } else {
            System.out.println(getElementText(driver, locator) + " is not displayed");
        }
    }

    public void getMessage(String expected) {
        waitForElementVisible(driver, Locator.MESSAGE);
        SleepInSecond(5);
        if (verifyEqual(getElementText(driver, Locator.MESSAGE), expected)) {
            System.out.println(expected);
        } else {
            System.out.println("[" + expected + "] but found [" + getElementText(driver, Locator.MESSAGE) + "]");
        }
//        waitForElementInvisible(driver, Locator.MESSAGE);
    }

    public void compareMessage(String message) {
        System.out.println("Expected message as same as actual message: " + compareMessage(driver, Locator.MESSAGE, message));
    }

    public void dangNhapPrecondition() {
        proxy = PageGeneratorManager.getProxy(driver);
        proxy.checkProxy(ProxyData.USERNAME, ProxyData.PASSWORD);
    }

    public void danhMucPrecondition() {
        dangNhap = PageGeneratorManager.getDangNhap(driver);
        dangNhapPrecondition();
        dangNhap.dangNhap(DangNhapData.TEN_GIAN_HANG, DangNhapData.TEN_DANG_NHAP, DangNhapData.MAT_KHAU);
        danhMuc = PageGeneratorManager.getDanhMuc(driver);
        danhMuc.navigateToDanhMuc();
    }

    public void phongBanPrecondition() {
        dangNhapPrecondition();
        dangNhap = PageGeneratorManager.getDangNhap(driver);
        dangNhap.dangNhap(DangNhapData.TEN_GIAN_HANG, DangNhapData.TEN_DANG_NHAP, DangNhapData.MAT_KHAU);
        phongBan = PageGeneratorManager.getPhongBan(driver);
        phongBan.navigateToPhongBan();
    }

    public void loginToBanHang() {
        dangNhapPrecondition();
        dangNhap = PageGeneratorManager.getDangNhap(driver);
        dangNhap.enterTenGianHang(DangNhapData.TEN_GIAN_HANG);
        dangNhap.enterTenDangNhap(DangNhapData.TEN_DANG_NHAP);
        dangNhap.enterMatKhau(DangNhapData.MAT_KHAU);
        dangNhap.clickToElement(driver, DangNhapLocator.BAN_HANG);
    }

    public void khachHangPrecondition() {
        dangNhapPrecondition();
        dangNhap = PageGeneratorManager.getDangNhap(driver);
        dangNhap.dangNhap(DangNhapData.TEN_GIAN_HANG, DangNhapData.TEN_DANG_NHAP, DangNhapData.MAT_KHAU);
        khachHang = PageGeneratorManager.getKhachHang(driver);
        khachHang.navigateToKhachHang();
    }

    public void nhaCungCapPrecondition() {
        dangNhapPrecondition();
        dangNhap = PageGeneratorManager.getDangNhap(driver);
        dangNhap.dangNhap(DangNhapData.TEN_GIAN_HANG, DangNhapData.TEN_DANG_NHAP, DangNhapData.MAT_KHAU);
        nhaCungCap = PageGeneratorManager.getNhaCungCap(driver);
        nhaCungCap.navigateToNhaCungCap();
        checkPageVisible(NhaCungCapLocator.NHA_CUNG_CAP_TEXT);
    }

}
