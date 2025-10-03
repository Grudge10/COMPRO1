import java.util.*;

public class PalindromeInteger {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get needed info
        System.out.print("Enter a three-digit integer: ");
        int integer = input.nextInt();

        // Check if input is valid
        if (integer > 1000 || integer < 100) {
            System.out.println("Invalid Choice");
            System.exit(0);
        }

        input.close(); // Close Scanner

        // Reverse the numbers
        int first = integer % 10 * 100;
        int second = integer / 10 % 10 * 10;
        int third = integer / 100 % 10;
        int reversed = first + second + third;

        // Check if palindrome or not then display
        if (integer == reversed) {
            System.out.printf("%d is a palindrome", integer);
        } else {
            System.out.printf("%d not a palindrome", integer);
        }
    }
}
