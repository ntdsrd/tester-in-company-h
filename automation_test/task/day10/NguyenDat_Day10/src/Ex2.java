public class Ex2 {
    public static boolean checkIfPrime(int num) {
        boolean flag = true;
        if (num == 2 || num == 3 || num == 5 || num == 7) {
            return flag;
        } else if (num % 2 == 0 || num % 3 == 0 || num % 5 == 0 || num % 7 == 0) {
            return flag = false;
        }
        return flag;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 7, 9, 6, 11, 98, 45, 67, 35, 23, 21, 5, 9, 11, 20};
        //latest prime
        for (int i = arr.length - 1; i >= 0; i--) {
            if (checkIfPrime(arr[i])) {
                System.out.println("Last prime: " + arr[i]);
                break;
            }
        }
        //bigest prime
        int big = 0;
        for (int i = 0; i < arr.length; i++) {
            if (checkIfPrime(arr[i])) {
                if (arr[i] > big) big = arr[i];
            }
        }
        System.out.println("Biggest prime: " + big);
    }
}