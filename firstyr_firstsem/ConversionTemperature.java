import java.util.Scanner;

public class ConversionTemperature {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // scan for user input
        int choice = 0;
        while (true) { // loop until the user gives valid inputs
            System.out.print("What would you like to convert? Celcius to fahrenheit(1) or fahrenheit to celsius(2): "); // ask for which conversion method the user would like to use
            // check if the input is valid, if not then loop
            if (input.hasNextInt()) {
                choice = input.nextInt();
                if (choice != 1 || choice != 1)
                    System.out.println("Invalid Input. Try again.");
                else
                    break;
            } else {
                System.out.println("Invalid Input. Try again.");
                input.next();
            }
        }
        // according to what the user asked, use the appropriate formula and ask for the temperature number
        if (choice == 1) {
            System.out.print("Enter your celsius to be converted to fahrenheit: ");
            double celsius = input.nextDouble();
            System.out.printf("%.2f celsius is %.2f fahrenheit\n", celsius, celsiusToFahrenheit(celsius));
        } else {
            System.out.print("Enter your fahrenheit to be converted to celsius: ");
            double fahrenheit = input.nextDouble();
            System.out.printf("%.2f fahrenheit is %.2f celsius\n", fahrenheit, celsiusToFahrenheit(fahrenheit));
        }
        input.close(); // close scanner
    }

    public static double celsiusToFahrenheit(double celsius) {
        return celsius * (9 / 5) + 32; // calculate celsius to fahrenheit
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * (5 / 9); // calculate fahrenheit to celsius
    }
}