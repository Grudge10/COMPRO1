import java.util.Scanner;

public class EvenNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = input.nextInt();

        int x = 0;
        while (x <= n) {
            if (x % 2 == 0) {
                System.out.println(x);
            }
            x++;
        }
    }
}
