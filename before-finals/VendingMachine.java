import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        final float coffee, tea, water;
        coffee = 100.00f;
        tea = 90.00f;
        water = 20.00f;

        System.out.print("*********************************\nWELCOME TO MY SHOP\n*********************************\nMenu:\n[ 1 ] Coffee @ 100.00\n[ 2 ] Tea @ 90.00\n[ 3 ] Water @ 20.00'");
        System.out.print("\n\nEnter your choice: ");
        int choice = input.nextInt();
        System.out.print("Enter quantity: ");
        int quantity = input.nextInt();

        String item;
        float itemPrice;

        if (choice == 1) {
            item = "Coffee";
            itemPrice = coffee;
        } else if (choice == 2) {
            item = "Tea";
            itemPrice = tea;
        } else if (choice == 3) {
            item = "Coffee";
            itemPrice = water;
        } else {
            System.out.print("\nInvalid choice");
            return;
        }

        float total = itemPrice * quantity;

        System.out.printf("\n\nOrder Summary\n*****************************\n%d x %s @ %.2f\nTotal: %.2f\n\nGoodbye!",quantity, item, itemPrice, total);

        input.close();
    }
}
