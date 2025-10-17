import java.util.Scanner;

public class BestOfFiveRPS {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int userWins = 0;
        int botWins = 0;
        int round = 1;
        while (userWins < 5 && botWins < 5) {
            System.out.print("""


                    Rock, Paper, Scissors!!!
                    (BEST OF FIVE!!)

                    [ 1 ] Rock
                    [ 2 ] Paper
                    [ 3 ] Scissors""");

            byte userInput = 0;
            boolean InvalidChoice = true;
            while (InvalidChoice) {
                System.out.print("\nChoose: ");
                if (input.hasNextByte()) {
                    userInput = input.nextByte();
                    if (userInput >= 1 && userInput <= 3) {
                        InvalidChoice = false;
                    } else {
                        System.out.print("Invalid Choice! Retry again.");
                    }
                } else {
                    System.out.print("Invalid Choice! Retry again.");
                    input.next();
                }
            }

            byte botInput = (byte) (Math.floor(Math.random() * 3) + 1);

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
                decide = "tie!!!";
            } else if ((userInput == 1 && botInput == 3) || (userInput == 2 && botInput == 1)
                    || (userInput == 3 && botInput == 2)) {
                decide = "win!!!";
                userWins++;

            } else {
                decide = "lose!!!";
                botWins++;

            }

            System.out.printf("""
                    ------------------
                    [ROUND %d]

                    You: %s
                    Bot: %s

                    %s
                    ------------------
                    """,
                    round, userChoice, botChoice, decide);

            round++;
        }

        if (userWins > botWins) {
            System.out.printf("You win!!! Your score is %d while the bot's score is %s", userWins, botWins);
        } else {
            System.out.printf("You lose!!! Your score is %d while the bot's score is %s", userWins, botWins);
        }

        input.close();
    }
}
