package action;

import action.common.BasePage;
import action.common.PageGeneratorManager;
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

    public Action(WebDriver driver) {
        this.driver = driver;
    }

    public void getMessage() {
        SleepInSecond(5);
        System.out.println(getElementText(driver, Locator.MESSAGE));
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
        SleepInSecond(1);
        dangNhap.enterTenDangNhap(DangNhapData.TEN_DANG_NHAP);
        SleepInSecond(1);
        dangNhap.enterMatKhau(DangNhapData.MAT_KHAU);
        SleepInSecond(1);
        dangNhap.clickToElement(driver, DangNhapLocator.BAN_HANG);
    }
}
