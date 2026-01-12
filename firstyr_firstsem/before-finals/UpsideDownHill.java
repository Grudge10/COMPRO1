import java.util.*;

public class UpsideDownHill {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = 0;
        while (true) {
            System.out.print("Enter a number: ");
            if (input.hasNextInt()) {
                n = input.nextInt();
                if (n >= 1) {
                    break;
                } else {
                    System.out.println("Invalid Choice!");
                }
            } else {
                System.out.println("Invalid Choice! Retry again.");
                input.next();
            }
        }

        for (int y = 1; y <= n; y++) {
            for (int x1 = 1; x1 < y; x1++) {
            System.out.printf(" ");
            }
            for (int x2 = y; x2 <= n; x2++) {
                System.out.print("*");
            }
            System.out.println();
        }

        input.close();
    }
}
