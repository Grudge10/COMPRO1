import java.util.Scanner;

public class StudentMajorAndStatus {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter two characters: ");
        String choice = input.nextLine();
        System.out.println(printMajorAndStatus(choice));
        input.close();
    }

    public static String printMajorAndStatus(String choice) {
        String majorAndStatus = "";
        if (choice.charAt(0) == 'M' || choice.charAt(0) == 'C' || choice.charAt(0) == 'I') {
            switch (choice.charAt(0)) {
                case 'M':
                    majorAndStatus += "Mathematics ";
                    break;
                case 'C':
                    majorAndStatus += "Computer Science ";
                    break;
                case 'I':
                    majorAndStatus += "Information Technology ";
                    break;
            }
            if (choice.charAt(1) == '1' || choice.charAt(1) == '2' || choice.charAt(1) == '3' || choice.charAt(1) == '4') {
                switch (choice.charAt(1)) {
                case '1':
                    majorAndStatus += "Freshman";
                    break;
                case '2':
                    majorAndStatus += "Sophomore";
                    break;
                case '3':
                    majorAndStatus += "Junior";
                    break;
                case '4':
                    majorAndStatus += "Senior";
                    break;
            }
            } else {
                return "Invalid input";
            }
        } else {
            return "Invalid input";
        }
        return majorAndStatus;
    }
}