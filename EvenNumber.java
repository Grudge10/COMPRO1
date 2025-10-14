import java.util.Scanner;

public class EvenNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");

        if (!input.hasNextInt()) {
            System.out.println("Invalid Choice!");
            System.exit(0);
        }

        int n = input.nextInt();

        System.out.printf("The even numbers from 0 to %d", n);

        int x = 0;
        while (x <= n) {
            if (x % 2 == 0) {
                System.out.println(x);
            }
            x++;
        }

        input.close();
    }
}
