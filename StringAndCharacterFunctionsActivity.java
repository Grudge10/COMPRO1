import java.util.Scanner;

public class StringAndCharacterFunctionsActivity {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter two characters: ");
        String choice = input.nextLine();
        System.out.println(studentMajorAndStatus(choice));

        System.out.print("Enter a SSN: ");
        String SSN = input.nextLine();
        System.out.printf("%s is %s social security number\n", SSN, validateSSN(SSN));
        input.close();

        System.out.printf("Your plate number is %s\n", generateVehiclePlateNumbers());
    }

    public static String studentMajorAndStatus(String choice) {
        String majorAndStatus = "", choiceFixed = choice.toUpperCase();
        if (choiceFixed.charAt(0) == 'M' || choiceFixed.charAt(0) == 'C' || choiceFixed.charAt(0) == 'I') {
            switch (choiceFixed.charAt(0)) {
                case 'M':
                    majorAndStatus += "Mathematics ";
                    break;
                case 'C':
                    majorAndStatus += "Computer Science ";
                    break;
                case 'I':
                    majorAndStatus += "Information Technology ";
                    break;
            }
            if (choiceFixed.charAt(1) == '1' || choiceFixed.charAt(1) == '2' || choiceFixed.charAt(1) == '3' || choiceFixed.charAt(1) == '4') {
                switch (choiceFixed.charAt(1)) {
                    case '1':
                        majorAndStatus += "Freshman";
                        break;
                    case '2':
                        majorAndStatus += "Sophomore";
                        break;
                    case '3':
                        majorAndStatus += "Junior";
                        break;
                    case '4':
                        majorAndStatus += "Senior";
                        break;
                }
            } else
                return "Invalid input";
        } else
            return "Invalid input";
        return majorAndStatus;
    }

    public static String validateSSN(String SSN) {
        if (SSN.length() == 11) {
            for (int i = 0; i < 11; i++) {
                if ((i == 3 || i == 6) && SSN.charAt(i) != '-')
                    return "an invalid";
                if ((i == 0 || i == 1 || i == 2 || i == 4 || i == 5 || i == 7 || i == 8 || i == 9 || i == 10) && !Character.isDigit(SSN.charAt(i)))
                    return "an invalid";
            }
            return "a valid";
        } else
            return "an invalid";
    }

    public static String generateVehiclePlateNumbers() {
        String plateNumber = "";
        for (int i = 1; i <= 3; i++) {
            int randomNumber = 1 + (int) (Math.random() * 26);
            switch (randomNumber) {
                case 1:
                    plateNumber += "A";
                    break;
                case 2:
                    plateNumber += "B";
                    break;
                case 3:
                    plateNumber += "C";
                    break;
                case 4:
                    plateNumber += "D";
                    break;
                case 5:
                    plateNumber += "E";
                    break;
                case 6:
                    plateNumber += "F";
                    break;
                case 7:
                    plateNumber += "G";
                    break;
                case 8:
                    plateNumber += "H";
                    break;
                case 9:
                    plateNumber += "I";
                    break;
                case 10:
                    plateNumber += "J";
                    break;
                case 11:
                    plateNumber += "K";
                    break;
                case 12:
                    plateNumber += "L";
                    break;
                case 13:
                    plateNumber += "M";
                    break;
                case 14:
                    plateNumber += "N";
                    break;
                case 15:
                    plateNumber += "O";
                    break;
                case 16:
                    plateNumber += "P";
                    break;
                case 17:
                    plateNumber += "Q";
                    break;
                case 18:
                    plateNumber += "R";
                    break;
                case 19:
                    plateNumber += "S";
                    break;
                case 20:
                    plateNumber += "T";
                    break;
                case 21:
                    plateNumber += "U";
                    break;
                case 22:
                    plateNumber += "V";
                    break;
                case 23:
                    plateNumber += "W";
                    break;
                case 24:
                    plateNumber += "X";
                    break;
                case 25:
                    plateNumber += "Y";
                    break;
                case 26:
                    plateNumber += "Z";
                    break;
            }
        }
        plateNumber += Integer.toString(1000 + (int) (Math.random() * 9999));
        return plateNumber;
    }
}
