import java.util.*;

public class Array1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] num = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
        }

        System.out.print("Enter a number: ");
        int choice = input.nextInt();
        for (int i = 0; i < num.length; i++) {
            if (num[i] == choice) {
                System.out.println("Found " + choice + " at index " + i);
                break;
            }
            System.out.println(-1);
        }

        input.close();
    }
}