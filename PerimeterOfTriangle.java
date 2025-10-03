import java.util.*;

public class PerimeterOfTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input
        System.out.print("Input three edges of a triangle(ex. 4 2 3): ");
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();

        // Check if invalid
        if (a + b <= c) {
            System.out.println("Invalid Input: Make sure a + b > c");
            System.exit(0);
        } else if (b + c <= a) {
            System.out.println("Invalid Input: Make sure b + c > a");
            System.exit(0);
        } else if (a + c <= b) {
            System.out.println("Invalid Input: Make sure a + c > b");
            System.exit(0);
        }

        input.close(); // Close Scanner

        // Compute
        int perimeterOfTriangle = a + b + c;

        // Display
        System.out.printf("The perimeter of this triangle is %d", perimeterOfTriangle);
    }
}
