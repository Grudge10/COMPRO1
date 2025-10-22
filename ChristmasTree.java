import java.util.*;

public class ChristmasTree {
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

        input.close();

        for (int y = 1; y <= n; y++) {
            for (int x = 0; x <= n - y; x++) {
                System.out.print("  ");
            }
            for (int z = 1; z <= (y * 2) - 1; z++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        for (int q = 0; q < 2; q++) {
            for (int w = 0; w <= n - 2; w++) {
                System.out.print("  ");
            }
            System.out.print(" ");
            System.out.println("| |");
        }
    }
}