import java.util.Scanner;

public class CalendarMethods {
    public static void main(String[] args) {
        int month = monthInput(0); // get month
        int year = yearInput(0); // get year

        // Print calendar for the month of the year
        printMonth(year, month);
        printMonthTitle(year, month);
        printMonthBody(year, month);
    }

    // get month
    public static int monthInput(int month) {
        Scanner input = new Scanner(System.in);
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
        return month;
    }

    // get year
    public static int yearInput(int year) {
        Scanner input = new Scanner(System.in);
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
        return year;
    }

    // print calendar header
    public static void printMonth(int year, int month) {
        System.out.printf("%9s%s %d%.9s\n", " ", getMonthName(month), year, " ");
    }

    // print days
    public static void printMonthTitle(int year, int month) {
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
    }

    // print calendar body
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

    // convert month number to string
    public static String getMonthName(int month) {
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

    // calculate where the first day of the month is using zeller's congruence
    public static int getStartDay(int year, int month) {
        // Set up january and february for zeller's congruence as well as the year
        int zellerYear = year;
        if (month == 1 || month == 2) {
            month += 12;
            zellerYear--;
        }
        int zellersCongruence = (int) (1 + (26 * (month + 1) / 10) + (zellerYear % 100) + ((zellerYear % 100) / 4) + ((zellerYear / 100) / 4) + (5 * (zellerYear / 100))) % 7;
        int startDay = (zellersCongruence + 6) % 7;
        return startDay;
    }

    // determine how many days there is in the month
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

    // check if leap year
    public static boolean isLeapYear(int year) {
        boolean leapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        return leapYear;
    }
}