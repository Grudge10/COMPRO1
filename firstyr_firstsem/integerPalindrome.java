import java.util.Scanner;

public class integerPalindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // scan user input
        System.out.print("Enter a number: "); // ask for number
        int number = input.nextInt(); // get the user's input
        System.out.println(isPalindrome(number)); // use isPalindrome method to check if its a palindrome
        input.close(); // close the scanner
    }

    public static int reverse(int number) {
        String numberString = String.valueOf(number), reverse = ""; // turn int number to string and initialize the variable that will be used to put the reversed number
        for(int i = numberString.length() - 1; i >= 0; i--)
            reverse += numberString.charAt(i); // reverse the whole number by individually getting each number from right to left
        int reverseInt = Integer.valueOf(reverse); // turned the reversed number from string to int
        return reverseInt; // return the reverse number
    }

    public static boolean isPalindrome(int number) {
        return number == reverse(number); // check whether or not the number is a palindrome by comparing the number and reverse number
    }
}