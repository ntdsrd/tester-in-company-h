package action.common;

import action.Proxy;
import action.dang_nhap.DangNhap;
import action.tong_quan.TongQuan;
import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    private static Proxy proxy;
    private static DangNhap dangNhap;
    private static TongQuan tongQuan;

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
}
