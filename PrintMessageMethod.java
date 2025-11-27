public class PrintMessageMethod {
    public static void main(String[] args) {
        printMessage(null);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printMessage(String message, int n) {
        for (int x = 1; x <= n; x++) {
            System.out.println(message);
        }
    }
}
