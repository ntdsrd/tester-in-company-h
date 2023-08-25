package action.common;

import action.PhongBan;
import action.Proxy;
import action.DangNhap;
import action.hang_hoa.DanhMuc;
import action.TongQuan;
import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    private static Proxy proxy;
    private static DangNhap dangNhap;
    private static TongQuan tongQuan;
    private static DanhMuc danhMuc;
    private static PhongBan phongBan;

    private PageGeneratorManager() {
    }

    public static Proxy getProxyPage(WebDriver driver) {
        if (proxy == null) {
            proxy = new Proxy(driver);
        }
        return proxy;
    }

    public static DangNhap getDangNhapPage(WebDriver driver) {
        if (dangNhap == null) {
            dangNhap = new DangNhap(driver);
        }
        return dangNhap;
    }

    public static TongQuan getTongQuanPage(WebDriver driver) {
        if (tongQuan == null) {
            tongQuan = new TongQuan(driver);
        }
        return tongQuan;
    }

    public static DanhMuc getDanhMucPage(WebDriver driver) {
        if (danhMuc == null) {
            danhMuc = new DanhMuc(driver);
        }
        return danhMuc;
    }

    public static PhongBan getPhongBanPage(WebDriver driver) {
        if (phongBan == null) {
            phongBan = new PhongBan(driver);
        }
        return phongBan;
    }
}