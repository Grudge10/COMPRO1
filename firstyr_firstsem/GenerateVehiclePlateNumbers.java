public class GenerateVehiclePlateNumbers {
    public static void main(String[] args) {
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
        System.out.println(plateNumber);
    }
}
