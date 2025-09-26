import java.util.*;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("""
                Rock, Paper, Scissors!!!

                [ 1 ] Rock
                [ 2 ] Paper
                [ 3 ] Scissors""");
        System.out.print("\nChoose: ");
        byte userInput = input.nextByte();

        // return if invalid choice
        if (userInput < 1 || userInput > 3) {
            System.out.print("Invalid Choice!");
            System.exit(0);
            ;
        }

        byte botInput = (byte) (Math.floor(Math.random() * 3) + 1);
        System.out.print(botInput);

        String decide, userChoice = "", botChoice = "";

        // add name for user input
        if (userInput == 1) {
            userChoice = "Rock";
        } else if (userInput == 2) {
            userChoice = "Paper";
        } else {
            userChoice = "Scissors";
        }

        // add name for bot input
        if (botInput == 1) {
            botChoice = "Rock";
        } else if (botInput == 2) {
            botChoice = "Paper";
        } else {
            botChoice = "Scissors";
        }

        // deciding the winner
        if (userInput == botInput) {
            decide = "It's a tie!!!";
        } else if ((userInput == 1 && botInput == 3) || (userInput == 2 && botInput == 1)
                || (userInput == 3 && botInput == 2)) {
            decide = "You win!!!";
        } else {
            decide = "You lose!!!";
        }

        System.out.printf("""


                You: %s
                Bot: %s

                %s

                GG""", userChoice, botChoice, decide);

        input.close();
    }
}