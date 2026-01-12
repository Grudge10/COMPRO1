public class MaxMethod {
    public static void main(String[] args) {
        max(0, 0);
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static int max(int a, int b, int c) {
        if (a > b && a > c) {
            return a;
        } else if (b > a && b > c) {
            return b;
        } else {
            return c;
        }
    }

    public static double max(double a, double b) {
        return a > b ? a : b;
    }
}
