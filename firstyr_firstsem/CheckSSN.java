import java.util.Scanner;

public class CheckSSN {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a SSN: ");
        String SSN = input.nextLine();
        System.out.printf("%s is %s social security number\n", SSN, validateSSN(SSN));
        input.close();
    }

    public static String validateSSN(String SSN) {
        if (SSN.length() == 11) {
            for (int i = 0; i < 11; i++) {
                if ((i == 3 || i == 6) && SSN.charAt(i) != '-')
                    return "an invalid";
                if ((i == 0 || i == 1 || i == 2 || i == 4 || i == 5 || i == 7 || i == 8 || i == 9 || i == 10) && !Character.isDigit(SSN.charAt(i)))
                    return "an invalid";
            }
            return "a valid";
        } else 
            return "an invalid";
    }
}
