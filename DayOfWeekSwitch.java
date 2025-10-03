import java.util.*;

public class DayOfWeekSwitch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Please input a number from 1-7: ");
        byte n = input.nextByte();

        String day = "[Invalid Choice]";

        switch (n) {
            case 1:
                day = "Sunday";
                break;
            case 2:
                day = "Monday";
                break;
            case 3:
                day = "Tuesday";
                break;
            case 4:
                day = "Wednesday";
                break;
            case 5:
                day = "Thursday";
                break;
            case 6:
                day = "Friday";
                break;
            case 7:
                day = "Saturday";
                break;
        }

        System.out.printf("It's %s!", day);

        input.close();
    }
}
