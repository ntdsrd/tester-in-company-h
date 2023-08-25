package user_interface.doi_tac;

public class NhaCungCapLocator {
    public static final String NHA_CUNG_CAP_TEXT = "//h1/span";
    public static final String NHA_CUNG_CAP = "//span[contains(text(),'Nhà cung cấp')]/parent::a";
    public static final String THEM_NHA_CUNG_CAP_TEN_NHA_CUNG_CAP = "//div[@data-role='draggable'][2]//input[@ng-model='supplier.Name']";
    public static final String THEM_NHA_CUNG_CAP_DIEN_THOAI = "//div[@data-role='draggable'][2]//input[@ng-model='supplier.Phone']";
    public static final String THEM_NHA_CUNG_CAP_EMAIL = "//div[@data-role='draggable'][2]//input[@ng-model='supplier.Email']";
    public static final String THEM_NHA_CUNG_CAP_LUU = "//div[@data-role='draggable'][2]//div/a[text()='Lưu']";
    public static final String THEM_NHOM_NHA_CUNG_CAP = "//a[@title='Thêm nhóm nhà cung cấp']/i";
    public static final String THEM_NHOM_NHA_CUNG_CAP_TEN_NHOM = "//label[contains(text(),'Tên nhóm')]/following-sibling::div/input";
    public static final String THEM_NHOM_NHA_CUNG_CAP_LUU = "//div[@uib-modal-transclude]//a[text()='Lưu']";
}