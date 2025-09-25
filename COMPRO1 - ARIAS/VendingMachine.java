import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        float coffee, tea, water;
        coffee = 100.00f;
        tea = 90.00f;
        water = 20.00f;

        System.out.print("*********************************\nWELCOME TO MY SHOP\n*********************************\nMenu:\n[ 1 ] Coffee @ 100.00\n[ 2 ] Tea @ 90.00\n[ 3 ] Water @ 20.00'");
        System.out.print("\n\nEnter your choice: ");
        int choice = input.nextInt();
        System.out.print("Enter quantity: ");
        int quantity = input.nextInt();

        float total;

        if (choice == 1) {
            total = coffee * quantity;
            System.out.printf("\n\nOrder Summary\n*****************************\n%d x Coffee @ %.2f\nTotal: %.2f\n\nGoodbye!", quantity, coffee, total);
        } else if (choice == 2) {
            total = tea * quantity;
            System.out.printf("\n\nOrder Summary\n*****************************\n%d x Tea @ %.2f\nTotal: %.2f\n\nGoodbye!", quantity, tea, total);
        } else if (choice == 3) {
            total = water * quantity;
            System.out.printf("\n\nOrder Summary\n*****************************\n%d x Water @ %.2f\nTotal: %.2f\n\nGoodbye!", quantity, water, total);
        } else if (!(choice < 0) && !(choice < 4)) {
            System.out.print("\n\nInvalid choice");
        }

        input.close();
    }
}
