package action.common;

import action.*;
import action.doi_tac.KhachHang;
import action.hang_hoa.DanhMuc;
import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    public static Proxy proxy;
    public static Action action;
    public static DangNhap dangNhap;
    public static DangNhapFactory dangNhapFactory;
    public static TongQuan tongQuan;
    public static DanhMuc danhMuc;
    public static PhongBan phongBan;
    public static BanHang banHang;
    public static KhachHang khachHang;

    private PageGeneratorManager() {
    }

    public static Proxy getProxy(WebDriver driver) {
        return proxy = new Proxy(driver);
    }

    public static Action getAction(WebDriver driver) {
        return action = new Action(driver);
    }

    public static DangNhap getDangNhap(WebDriver driver) {
        return dangNhap = new DangNhap(driver);
    }

    public static DangNhapFactory getDangNhapFactory(WebDriver driver) {
        return dangNhapFactory = new DangNhapFactory(driver);
    }


    public static TongQuan getTongQuan(WebDriver driver) {
        return tongQuan = new TongQuan(driver);
    }

    public static DanhMuc getDanhMuc(WebDriver driver) {
        return danhMuc = new DanhMuc(driver);
    }

    public static PhongBan getPhongBan(WebDriver driver) {
        return phongBan = new PhongBan(driver);
    }

    public static BanHang getBanHang(WebDriver driver) {
        return banHang = new BanHang(driver);
    }

    public static KhachHang getKhachHang(WebDriver driver) {
        return khachHang = new KhachHang(driver);
    }
}