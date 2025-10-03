import java.util.*;

public class DayOfTheWeek {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input
        System.out.print("Enter year(ex. 2012): ");
        int year = input.nextInt();

        System.out.print("Enter month(1-12): ");
        int month = input.nextInt();

        System.out.print("Enter the day of the month(1-31): ");
        int day = input.nextInt();

        input.close(); // Close scanner

        // Change values for jan and feb
        switch (month) {
            case 1:
                month = 13;
                --year;
                break;
            case 2:
                month = 14;
                --year;
        }

        // Compute
        int j = year / 100;
        int yearOfTheCentury = year % 100;
        int dayOfTheWeek = (day + (26 * (month + 1) / 10) + yearOfTheCentury + (yearOfTheCentury / 4) + (j / 4) + 5 * j) % 7;

        // Change number into string
        String dayOfTheWeekString = "";

        switch (dayOfTheWeek) {
            case 0:
                dayOfTheWeekString = "Saturday";
                break;
            case 1:
                dayOfTheWeekString = "Sunday";
                break;
            case 2:
                dayOfTheWeekString = "Monday";
                break;
            case 3:
                dayOfTheWeekString = "Tuesday";
                break;
            case 4:
                dayOfTheWeekString = "Wednesday";
                break;
            case 5:
                dayOfTheWeekString = "Thursday";
                break;
            case 6:
                dayOfTheWeekString = "Friday";
                break;
        }

        System.out.printf("Day of the week is %s", dayOfTheWeekString);
    }
}
