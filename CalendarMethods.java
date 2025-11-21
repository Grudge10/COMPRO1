import java.util.Scanner;

public class CalendarMethods {
    /** Main method */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter full year (e.g., 2012): "); // Prompt the user to enter year
        int year = input.nextInt();
        System.out.print("Enter month as a number between 1 and 12: "); // Prompt the user to enter month
        int month = input.nextInt();
        input.close();

        // Print calendar for the month of the year
        printMonth(year, month);
        printMonthTitle(year, month);
        printMonthBody(year, month);
    }

    /** A stub for printMonth may look like this */
    public static void printMonth(int year, int month) {
        System.out.printf("%15s (%d)\n", getMonthName(month), year);
    }

    /** A stub for printMonthTitle may look like this */
    public static void printMonthTitle(int year, int month) {
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
    }

    /** A stub for printMonthBody may look like this */
    public static void printMonthBody(int year, int month) {
        for (int q = 0; q < getStartDay(year, month); q++) {
            System.out.printf("%4s", " ");
        }
        for (int w = 1; w <= getNumberOfDaysInMonth(year, month); w++) {
            System.out.printf("%4d", w);
            if ((w + getStartDay(year, month)) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    /** A stub for getMonthName may look like this */
    public static String getMonthName(int month) {
        // Change month number to string
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

    /** A stub for getStartDay may look like this */
    public static int getStartDay(int year, int month) {
        // Set up january and february for zeller's congruence as well as the year
        int zellerYear = year;
        if (month == 1 || month == 2) {
            month += 12;
            zellerYear--;
        }

        // calculate where the first day of the month is using zeller's congruence
        int zellersCongruence = (int) (1 + (26 * (month + 1) / 10) + (zellerYear % 100) + ((zellerYear % 100) / 4) + ((zellerYear / 100) / 4) + (5 * (zellerYear / 100))) % 7;
        int startDay = (zellersCongruence + 6) % 7;

        return startDay;
    }

    /** A stub for getNumberOfDaysInMonth may look like this */
    public static int getNumberOfDaysInMonth(int year, int month) {
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

    /** A stub for isLeapYear may look like this */
    public static boolean isLeapYear(int year) {
        boolean leapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        return leapYear;
    }
}