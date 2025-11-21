import java.util.*;

public class FutureDate {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter today's day: ");
        byte today = input.nextByte();

        if (today < 0 || today > 6) {
            System.out.println("Invalid Choice");
            System.exit(0);
        }

        System.out.print("Enter the number of days elapsed since today: ");
        byte futureDay = input.nextByte();

        input.close();

        byte futureDate = (byte) ((today + futureDay) % 7);

        String stringToday = "", stringFutureDay = "";

        switch (today) {
            case 0:
                stringToday = "Sunday";
                break;
            case 1:
                stringToday = "Monday";
                break;
            case 2:
                stringToday = "Tuesday";
                break;
            case 3:
                stringToday = "Wednesday";
                break;
            case 4:
                stringToday = "Thursday";
                break;
            case 5:
                stringToday = "Friday";
                break;
            case 6:
                stringToday = "Saturday";
                break;
        }

        switch (futureDate) {
            case 0:
                stringFutureDay = "Sunday";
                break;
            case 1:
                stringFutureDay = "Monday";
                break;
            case 2:
                stringFutureDay = "Tuesday";
                break;
            case 3:
                stringFutureDay = "Wednesday";
                break;
            case 4:
                stringFutureDay = "Thursday";
                break;
            case 5:
                stringFutureDay = "Friday";
                break;
            case 6:
                stringFutureDay = "Saturday";
                break;
        }

        System.out.printf("Today is %s and the future day is %s", stringToday, stringFutureDay);
    }
}
