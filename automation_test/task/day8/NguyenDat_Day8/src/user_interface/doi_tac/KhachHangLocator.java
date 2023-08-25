package user_interface.doi_tac;

public class KhachHangLocator {
    public static final String KHACH_HANG = "//span[contains(text(),'Khách hàng')]/parent::a";
    public static final String THEM_KHACH_HANG_TEN_KHACH_HANG = "//label[contains(text(),'Tên khách hàng')]/following-sibling::div/input";
    public static final String THEM_KHACH_HANG_NGAY_SINH = "//input[@ng-model='BirthDate']";
    public static final String THEM_KHACH_HANG_LUU = "//div/a[text()='Lưu']";
    public static final String THEM_NHOM_KHACH_HANG = "//a[@title='Thêm nhóm khách hàng']/i";
    public static final String THEM_NHOM_KHACH_HANG_TEN_NHOM = "//label[contains(text(),'Tên nhóm')]/following-sibling::div/input";
    public static final String THEM_NHOM_KHACH_HANG_LUU = "//div[@uib-modal-transclude]//a[text()='Lưu']";
}
