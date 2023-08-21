import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer sum = 0;
        System.out.print("Enter an integer ");
        Integer input = sc.nextInt();
        String string = input.toString();
        for (int i = 0; i < string.length(); i++) {
            int c = string.charAt(i) - 48;
            sum = sum + c;
        }
        System.out.println(sum);
    }
}