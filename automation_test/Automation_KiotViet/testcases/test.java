public class test {


    public void test_01 (String text, String... param) {

        text = String.format(text,param);


        System.out.println("test 01" + text);
    }

}
