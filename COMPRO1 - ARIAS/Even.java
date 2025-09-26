import java.util.Scanner;

public class Even {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.printf("Input a number: ");
        int n = input.nextInt();

        if (n % 2 == 0) {
            System.out.printf("%d is an even number", n);
        }

        input.close();
    }
}