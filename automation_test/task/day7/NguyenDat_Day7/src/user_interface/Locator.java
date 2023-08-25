package user_interface;

public class Locator {
    public static final String MESSAGE = "//div[@class='toast-message']";
    public static final String TONG_QUAN = "//a[contains(text(), 'Tổng quan')]";
    public static final String HANG_HOA = "//a[contains(text(), 'Hàng hóa')]";
    public static final String HANG_HOA_DANH_MUC = "//a[contains(text(), 'Danh mục')]";
    public static final String PHONG_BAN = "//a[contains(text(), 'Phòng/Bàn')]";
    public static final String DOI_TAC = "//ul[@class='menu']/li[a[contains(text(), 'Đối tác')]]";
    public static final String KHACH_HANG = "//li[a[contains(text(), 'Đối tác')]]/descendant::li[1]/a";
}