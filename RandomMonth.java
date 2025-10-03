public class RandomMonth {
    public static void main(String[] args) {
        byte randomMonth = (byte) (Math.floor(Math.random() * 12 + 1));

        System.out.println("Lets give you a random month.");

        switch (randomMonth) {
            case 1:
                System.out.println("You got January!");
                break;
            case 2:
                System.out.println("You got February!");
                break;
            case 3:
                System.out.println("You got March!");
                break;
            case 4:
                System.out.println("You got April!");
                break;
            case 5:
                System.out.println("You got May!");
                break;
            case 6:
                System.out.println("You got June!");
                break;
            case 7:
                System.out.println("You got July!");
                break;
            case 8:
                System.out.println("You got August!");
                break;
            case 9:
                System.out.println("You got September!");
                break;
            case 10:
                System.out.println("You got October!");
                break;
            case 11:
                System.out.println("You got November!");
                break;
            case 12:
                System.out.println("You got December!");
                break;

        }
    }
}
