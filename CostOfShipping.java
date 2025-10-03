import java.util.*;

public class CostOfShipping {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input
        System.out.print("Enter the weight of the package in pounds: ");
        float weight = input.nextFloat();

        input.close(); // Close scanner

        // Check if invalid or too heavy
        if (weight <= 0) {
            System.out.println("Invalid input");
            System.exit(0);
        } else if (weight > 20) {
            System.out.println("The package cannot be shipped");
            System.exit(0);
        }

        // Check for price
        float price = 0f;

        if (weight > 0 && weight <= 1) {
            price = 3.5f;
        } else if (weight > 1 && weight <= 3) {
            price = 5.5f;
        } else if (weight > 3 && weight <= 10) {
            price = 8.5f;
        } else {
            price = 10.5f;
        }

        // Display
        System.out.printf("The cost of shipping will be $%.1f", price);
    }
}
