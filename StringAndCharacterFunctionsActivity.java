import java.util.Scanner;

public class StringAndCharacterFunctionsActivity {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // scan user input
        // for problem 1
        System.out.print("Enter two characters: ");
        String choice = input.nextLine();
        System.out.println(studentMajorAndStatus(choice));
        // for problem 2
        System.out.print("Enter a SSN: ");
        String SSN = input.nextLine();
        System.out.printf("%s is %s social security number\n", SSN, validateSSN(SSN));

        input.close(); // close scanner since its not needed anymore
        // for problem 3
        System.out.printf("Your plate number is %s\n", generateVehiclePlateNumbers());
    }

    public static String studentMajorAndStatus(String choice) {
        String majorAndStatus = "", choiceFixed = choice.toUpperCase(); // create a placeholder and a upper cased version of the user's choice
        // check the first and second characters to see what to output. if input is incorrect return invalid input
        if (choiceFixed.charAt(0) == 'M')
            majorAndStatus += "Mathematics ";
        else if (choiceFixed.charAt(0) == 'C')
            majorAndStatus += "Computer Science ";
        else if (choiceFixed.charAt(0) == 'I')
            majorAndStatus += "Information Technology ";
        else
            return "Invalid input";
        if (choiceFixed.charAt(1) == '1')
            majorAndStatus += "Freshman";
        else if (choiceFixed.charAt(1) == '2')
            majorAndStatus += "Sophomore";
        else if (choiceFixed.charAt(1) == '3')
            majorAndStatus += "Junior";
        else if (choiceFixed.charAt(1) == '4')
            majorAndStatus += "Senior";
        else
            return "Invalid input";
        return majorAndStatus; // return the string that has been created
    }

    public static String validateSSN(String SSN) {
        if (SSN.length() != 11) // check if the length of the SSN is wrong. if yes, return invalid
            return "an invalid";
        for (int i = 0; i <= 10; i++) { // check if the numbers and dashes are in the wrong place. if yes, return invalid
            if (i == 3 || i == 6) {
                if (SSN.charAt(i) != '-')
                    return "an invalid";
            } else {
                if (!Character.isDigit(SSN.charAt(i)))
                    return "an invalid";
            }
        }
        return "a valid"; // if the provided SSN has passed through all the checkings, return valid
    }

    public static String generateVehiclePlateNumbers() {
        String plateNumber = "", abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // create a placeholder and a string for all letters in the alphabet
        for (int i = 1; i <= 3; i++) { // create a random number 3 times which will turn into a letter
            plateNumber += abc.charAt((int) (Math.random() * 26));
        }
        plateNumber += Integer.toString(1000 + (int) (Math.random() * 9000)); // add in 4 random digits
        return plateNumber; // return the created plate number
    }
}
