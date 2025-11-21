import java.util.*;

public class DayOfWeekIf {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Please input a number from 1-7: ");
        byte n = input.nextByte();

        String day = null;

        if (n == 1) {
            day = "Sunday";
        } else if (n == 2) {
            day = "Monday";
        } else if (n == 3) {
            day = "Tuesday";
        } else if (n == 4) {
            day = "Wednesday";
        } else if (n == 5) {
            day = "Thursday";
        } else if (n == 6) {
            day = "Friday";
        } else if (n == 7) {
            day = "Saturday";
        } else {
            System.out.print("Invalid Choice!");
        }

        System.out.printf("It's %s!", day);

        input.close();
    }
}