import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTC_01 extends BaseTest {
    //private WebDriver driver;
    Login login;
    TongQuan tongQuan;

    @Parameters({"browser", "url"})
    @BeforeMethod
    public void initBrowser(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        login = new PageGeneratorManager().getLoginPage(driver);
        //login = new Login(driver);
    }

    @Test(description = "Trường hợp đăng nhập thành công")
    public void Login_01() {
        //Step 1: Nhập tên gian hàng
        login.nhapTenGianHang(GlobalConstants.TEN_GIAN_HANG);
        //Step 2: Nhập tên đăng nhập
        login.nhapTenDangNhap(GlobalConstants.TEN_DANG_NHAP);
        //Step 3: Nhập mật khẩu
        login.nhapMatKhau(GlobalConstants.MAT_KHAU);
        //Step 4: Click button Quản lí
        login.clickButtonQuanLi();
        tongQuan = new PageGeneratorManager().getTongQuanPage(driver);
        //Step 5: Kiểm tra hiện thị màn hình Tổng Quan
        tongQuan.kiemTraHienThiManHinhTongQuan();
    }


    @AfterMethod
    public void AfterTest() {
        driver.quit();
    }
}

