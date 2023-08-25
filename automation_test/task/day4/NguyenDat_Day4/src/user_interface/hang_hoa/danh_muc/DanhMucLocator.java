package user_interface.hang_hoa.danh_muc;

public class DanhMucLocator {
    public static final String TIM_KIEM = "//div[@class='form-group']/input";
    public static final String TIM_KIEM_RESULT = "//tr[2]/td[@class='cell-code']/span";
    public static final String TIM_KIEM_RESULT_NAME = "//div[@class='k-tabstrip-wrapper']/descendant::h3";
    public static final String THEM_MOI_BUTTON = "//aside[@class='header-filter-buttons']/child::div/a";
    public static final String THEM_MOI_THEM_HANG_HOA = "//aside[@class='header-filter-buttons']//ul/li[1]/a";
    public static final String THEM_HANG_HOA_TEN_HANG = "//input[@ng-model='product.Name']";
    public static final String THEM_HANG_HOA_NHOM_HANG = "//kv-category-dropdownlist[@selected-id='product.CategoryId']";
    public static final String THEM_HANG_HOA_LUU_BUTTON = "//a[@ng-enter='SaveProduct()']";
    public static final String ERROR_MESSAGE = "//div[@class='toast-message']";
}
