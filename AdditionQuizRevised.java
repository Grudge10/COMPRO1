import java.util.Scanner;

public class AdditionQuizRevised {
    public static void main(String[] args) {
        byte n1 = (byte) (System.currentTimeMillis() % 10);
        byte n2 = (byte) (System.currentTimeMillis() / 10 % 10);
        byte n3 = (byte) (System.currentTimeMillis() / 100 % 10);

        Scanner input = new Scanner(System.in);

        System.out.printf("What is %d + %d + %d? ", n1, n2, n3);

        byte answer = input.nextByte();

        boolean trueOrFalse = n1 + n2 + n3 == answer;

        System.out.printf("%d + %d + %d = %d is %b", n1, n2, n3, answer, trueOrFalse);

        input.close();
    }
}
