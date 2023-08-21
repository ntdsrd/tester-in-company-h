public class Main {
    public static void main(String[] args) {
        String text1 = "//h2[contains(text(),'%s')]/parent::div//following-sibling::div/a[contains(text(),'%s')::div//following-sibling::div/a[contains(text(),'%s')]";
        String text2 = "//h2[contains(text(),'%s')]/parent::div//following-sibling::div/a[contains(text(),'%s')::div//following-sibling::div/a[contains(text())]";

    test t = new test();
    t.test_01(text1, "world1","world2","world");
    t.test_01(text2, "world","world");


    }




}
