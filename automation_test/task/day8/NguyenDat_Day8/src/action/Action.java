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

    public void getMessage(String expected, String message) {
        waitForElementVisible(driver, Locator.MESSAGE);
        sortAssertEqual(expected.trim(), getElementText(driver, Locator.MESSAGE), message);
//        sortAssertAll();
        SleepInSecond(5);
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

    public void nhaCungCapPrecondition(String message) {
        dangNhapPrecondition();
        dangNhap = PageGeneratorManager.getDangNhap(driver);
        dangNhap.dangNhap(DangNhapData.TEN_GIAN_HANG, DangNhapData.TEN_DANG_NHAP, DangNhapData.MAT_KHAU);
        nhaCungCap = PageGeneratorManager.getNhaCungCap(driver);
        nhaCungCap.navigateToNhaCungCap(message);
    }

}
