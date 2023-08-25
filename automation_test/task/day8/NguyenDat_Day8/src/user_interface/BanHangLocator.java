package user_interface;

public class BanHangLocator {
    public static final String HEADER_LINK = "//a[contains(text(),\"%s\")]";
    public static final String PHONG_BAN_ACTION = "//div['%s']/ul/li['%s']/div[@class='tableroom-actions']/following-sibling::a";
    public static final String THUC_DON_MENU = "//div[@class='swiper-wrapper']//div['%s']//li['%s']/a";
    public static final String BUTTON = "//button[contains(text(),\"'%s'\")]";
}
