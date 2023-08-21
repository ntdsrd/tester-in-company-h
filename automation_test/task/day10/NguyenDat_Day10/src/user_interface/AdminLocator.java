package user_interface;

public class AdminLocator {
    public static final String ADMIN_TITLE = "//div[@class='oxd-topbar-header-title']//h6[1]";
    public static final String ADD_BUTTON = "//div[@class='orangehrm-header-container']/button";
    public static final String USER_ROLE = "//label[contains(text(),'User Role')]/parent::div/following-sibling::div/div";
    public static final String LIST_BOX = "//div[@role='listbox']//*[contains(text(),'%s')]";
    public static final String STATUS = "//label[contains(text(),'Status')]/parent::div/following-sibling::div/div";
    public static final String EMPLOYEE_NAME = "//input[@placeholder='Type for hints...']";
    public static final String USERNAME = "//label[contains(text(),'Username')]/parent::div/following-sibling::div/input";
    public static final String PASSWORD = "//label[text()='Password']/parent::div/following-sibling::div/input";
    public static final String CONFIRM_PASSWORD = "//label[text()='Confirm Password']/parent::div/following-sibling::div/input";
    public static final String SAVE_BUTTON = "//div[@class='oxd-form-actions']/button[@type='submit']";
    public static final String SEARCH_BUTTON = "//div[@class='oxd-form-actions']/button[@type='submit']";
    public static final String SEARCH_USERNAME = "//div[contains(text(),'%s')]";
}
