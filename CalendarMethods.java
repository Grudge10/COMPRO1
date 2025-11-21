import java.util.Scanner;

public class CalendarMethods {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Scan user inputs

        // Get month with error checker
        int month = 0;
        while (true) {
            System.out.print("Enter month (ex. january = 1): ");
            if (input.hasNextInt()) {
                month = input.nextInt();
                if (month < 1 || month > 12) {
                    System.out.println("Invalid input please retry!");
                    continue;
                }
                break;
            } else {
                System.out.println("Invalid input please retry!");
                input.next();
            }
        }

        // Get year with error checker
        int year = 0;
        while (true) {
            System.out.print("Enter year: ");
            if (input.hasNextInt()) {
                year = input.nextInt();
                if (year < 1) {
                    System.out.println("Invalid input please retry!");
                    continue;
                }
                break;
            } else {
                System.out.println("Invalid input please retry!");
                input.next();
            }
        }

        input.close(); // Close scanner

        calendar(month, year); // print calendar
    }

    // Change month int to string
    public static String monthIntToString(int month) {
        String monthString = " ";
        switch (month) {
            case 1: monthString = "January"; break;
            case 2: monthString = "February"; break;
            case 3: monthString = "March"; break;
            case 4: monthString = "April"; break;
            case 5: monthString = "May"; break;
            case 6: monthString = "June"; break;
            case 7: monthString = "July"; break;
            case 8: monthString = "August"; break;
            case 9: monthString = "September"; break;
            case 10: monthString = "October"; break;
            case 11: monthString = "November"; break;
            case 12: monthString = "December"; break;
        }
        return monthString;
    }

    // Check how many theres there is in the month
    public static int daysOfTheMonth(int month, int year) {
        int days = 0;
        if (month == 2) {
            days = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0) ? 29 : 28;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            days = 30;
        } else {
            days = 31;
        }
        return days;
    }

    // Calculate zeller's congruence and find out where the first day of the month is
    public static int zellersCongruence(int month, int year) {
        // Set up january and february for zeller's congruence as well as the year
        int zellerYear = year;
        if (month == 1 || month == 2) {
            month += 12;
            zellerYear--;
        }
        int h = (int) (1 + (26 * (month + 1) / 10) + (zellerYear % 100) + ((zellerYear % 100) / 4) + ((zellerYear / 100) / 4) + (5 * (zellerYear / 100))) % 7;
        return h;
    }

    // Print calendar
    public static void calendar(int month, int year){
        System.out.printf("%15s (%s)\n", monthIntToString(month), year);
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
        for (int q = 0; q < (zellersCongruence(month, year) + 6) % 7; q++) {
            System.out.printf("%4s", " ");
        }
        for (int w = 1; w <= daysOfTheMonth(month, year); w++) {
            System.out.printf("%4d", w);
            if ((w + ((zellersCongruence(month, year) + 6) % 7)) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}