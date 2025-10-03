import java.util.*;

public class DaysInAMonth {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get needed info
        System.out.print("Input Month(1-12): ");
        byte month = input.nextByte();

        if (month < 1 || month > 12) {
            System.out.println("Invalid Choice"); // Check for invalid choice
        }

        System.out.print("Input Year: ");
        int year = input.nextInt();

        input.close();

        // Convert month numbers to strings
        String monthName = "";

        switch (month) {
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "February";
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
                break;
        }

        // Check for how many days in a month
        byte days = 0;

        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12:
                days = 31;
                break;
            case 4, 6, 9, 11:
                days = 30;
                break;
            case 2:
                days = 28; // if not leap year
                break;
        }

        // Change default value for feb if leap year
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            days = 29;
        }

        // Display
        System.out.printf("%s %d has %d days", monthName, year, days);
    }
}
