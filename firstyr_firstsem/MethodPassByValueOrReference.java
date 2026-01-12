import java.util.Scanner;

public class MethodPassByValueOrReference {
    public static void main(String[] args) {
        // int num = 5;
        // someMethod(num);
        // System.out.println(num);

        // int[] numbers = { 6, 10, 15 };
        // someMethod(numbers);
        // System.out.println(numbers[0]);

        // int[] anotherRef = numbers;
        // anotherRef[2] = 7;
        // System.out.println(numbers[2]);
        // System.out.println(anotherRef[2]);

        Scanner scanner = new Scanner(System.in);
        // System.out.print("Enter size: ");
        // int size = scanner.nextInt();
        // int[] arr = new int[size];
        // System.out.println("Enter " + size + " numbers:");
        // for (int i = 0; i < arr.length; i++) {
        //     System.out.print("Number " + (i + 1) + ": ");
        //     arr[i] = scanner.nextInt();
        // }
        // System.out.println("The array contains: ");
        // printArr(arr);

        System.out.print("Enter size: ");
        int size2 = scanner.nextInt();
        int[] arr2 = new int[size2];
        int[] frequency = new int[51];
        System.out.print("Enter numbers: ");
        for (int i = 0; i < arr2.length; i++) {
            if (scanner.hasNextInt()) {
                arr2[i] = scanner.nextInt();
                if (arr2[i] < 1 || arr2[i] > 50) {
                    System.out.println("Invalid Input");
                    i--;
                } else
                    frequency[arr2[i]]++;
            } else {
                System.out.println("Invalid Input");
                i--;
            }
        }
        for (int i = 1; i < frequency.length; i++) {
            if (frequency[i] > 0)
                System.out.println(i + " - " + frequency[i]);
        }
    }

    public static void someMethod(int x) {
        x = 50;
    }

    public static void someMethod(int[] x) {
        x[0] = 35;
    }

    public static void printArr(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}