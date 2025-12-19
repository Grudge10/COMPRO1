import java.util.Scanner;

public class HangmanBetter {
    public static Scanner input = new Scanner(System.in); // make the scanner public

    public static void main(String[] args) {
        // initialize the needed variables
        int playerCount = 0;
        int[] playerScores = new int[50];
        String[] playerNames = new String[50],
                easyWordBank = { "sun", "bed", "use", "pan", "owl", "net", "inn", "add", "die", "car", "bus", "job",
                        "van", "fat", "sex", "ban", "gap", "get", "tie", "bag", "act", "map", "day", "due", "shy",
                        "lay", "ant", "jaw", "ear", "ask", "mix", "put", "bad", "hit", "cap", "sit", "bat", "fly",
                        "rib", "fit", "cry", "bar", "tip", "hut", "jet", "set", "mug", "dog", "fax", "pit" },
                mediumWordBank = { "trial", "scene", "fairy", "shine", "image", "match", "beach", "ideal", "weigh",
                        "glare", "siege", "shock", "dairy", "grass", "bride", "torch", "climb", "crude", "scale",
                        "ankle", "north", "rider", "speed", "house", "clean", "ghost", "admit", "venus", "still",
                        "issue", "greet", "ditch", "mayor", "aisle", "width", "drain", "rumor", "charm", "strap",
                        "rally", "punch", "salad", "sugar", "tight", "coach", "stage", "witch", "orbit", "drink",
                        "watch" },
                hardWordBank = { "retirement", "television", "assignment", "incredible", "vegetation", "occupation",
                        "appearance", "compliance", "prediction", "exhibition", "indication", "overcharge",
                        "goalkeeper", "absorption", "convention", "earthquake", "generation", "conscience",
                        "conference", "background", "innovation", "mechanical", "convulsion", "excavation",
                        "diplomatic", "assumption", "management", "preference", "philosophy", "motorcycle",
                        "illustrate", "depression", "domination", "attractive", "simplicity", "difficulty",
                        "reputation", "continuous", "decoration", "engagement", "perception", "conspiracy",
                        "psychology", "repetition", "inhabitant", "restaurant", "commitment", "correspond",
                        "definition", "connection" };

        // loop until theres above 50 players
        while (playerCount < 50) {
            while (true) { // get the player's name and not accept empty names
                System.out.print("Player Name: ");
                playerNames[playerCount] = input.nextLine().trim();
                if (playerNames[playerCount].length() > 0)
                    break;
                System.out.println("Name cannot be empty!");
            }

            System.out.println(); // for formatting purposes

            // initialize needed variables that has to be reset each loop
            String[] wordBank = new String[50];
            int maxScore = 0;

            // let the player choose the difficulty and check for invalid inputs
            while (true) {
                System.out.printf("Choose your difficulty easy(1), medium(2), hard(3): ");
                if (input.hasNextInt()) {
                    int difficultyChoice = input.nextInt();
                    input.nextLine();
                    if (difficultyChoice == 1) {
                        wordBank = easyWordBank;
                        maxScore = 3;
                        break;
                    } else if (difficultyChoice == 2) {
                        wordBank = mediumWordBank;
                        maxScore = 5;
                        break;
                    } else if (difficultyChoice == 3) {
                        wordBank = hardWordBank;
                        maxScore = 10;
                        break;
                    } else
                        System.out.println("Invalid Input! choose 1, 2, or 3");
                } else {
                    System.out.println("Invalid Input! choose 1, 2, or 3");
                    input.nextLine();
                }
            }

            // let the player play the game and log their score into playerScores array
            playerScores[playerCount] = playGame(wordBank, 3, maxScore);

            // once the game ends, display player's score
            System.out.printf("Your final score, %s, is %d %s\n\n", playerNames[playerCount],
                    playerScores[playerCount], playerScores[playerCount] == 1 ? "point" : "points");

            playerCount++; // +1 to playerCount

            // check if there will be another player
            if (!anotherPlayer())
                break; // if no, break the loop
        }

        // sort the players from highest to lowest
        for (int i = 0; i < playerCount; i++) { // makes sure that all scores are sorted
            for (int o = 0; o < playerCount - 1; o++) { // sorts the scores from highest to lowest
                // swap if the current score is less than the next score
                if (playerScores[o] < playerScores[o + 1]) {
                    // swap scores
                    int tempScore = playerScores[o]; // temporary placeholder for swapping
                    playerScores[o] = playerScores[o + 1];
                    playerScores[o + 1] = tempScore;

                    // swap names
                    String tempName = playerNames[o]; // another temporary placeholder for swapping
                    playerNames[o] = playerNames[o + 1];
                    playerNames[o + 1] = tempName;
                }
            }
        }

        // once sorted, display leaderboard
        System.out.println("\n===== LEADERBOARD =====");
        for (int i = 0; i < playerCount; i++) {
            System.out.printf("%s - %d %s\n", playerNames[i], playerScores[i],
                    playerScores[i] == 1 ? "point" : "points");
        }
    }

    // see if there is another player that wants to play
    public static boolean anotherPlayer() {
        char choice = ' ';
        while (true) {
            System.out.print("Another Player? Enter y or n: ");
            String rawInput = input.nextLine().toLowerCase();
            if (rawInput.length() > 0) { // checks if input is a char
                choice = rawInput.charAt(0);
                if (choice == 'y' || choice == 'n') // checks if input is one of the valid inputs
                    break;
            }
            System.out.println("invalid choice");
        }
        return choice == 'y';
    }

    // the whole game's logic
    public static int playGame(String[] wordBank, int maxIncorrect, int maxScore) {
        // get a random word in the chosen word bank and hide the letters of the word
        // and initialize the needed variables
        String randomWord = wordBank[(int) Math.floor(Math.random() * wordBank.length)],
                currentHiddenWord = initializeHiddenWord(randomWord);
        int currentIncorrectGuesses = 0, index = 0, currentScore = 0;
        char[] guessedLetters = new char[100];

        // keep playing until max incorrect guesses reached or word fully guessed
        while (currentIncorrectGuesses < maxIncorrect && currentHiddenWord.indexOf('*') >= 0) {
            char guess = getLetterGuess(currentHiddenWord); // let the player guess a letter

            // check if the letter is already in the word. if yes, repeat loop
            if (letterAlreadyGuessed(guess, guessedLetters, index) == true) {
                System.out.printf("%s is already in the word\n", guess);
                continue;
            }

            guessedLetters[index] = guess; // add the guessed letter in the guessedLetters array

            // check if the guessed letter is in the word or not
            if (randomWord.indexOf(guess) >= 0) { // if yes, update the hidden word and add to the current score
                currentHiddenWord = updateHiddenWord(randomWord, currentHiddenWord, guess);
                currentScore = awardPointForCorrectLetter(true, currentScore);
            } else { // if no, tell the player and update the incorrect score
                System.out.printf("%s is not in the word\n", guess);
                currentIncorrectGuesses = updateIncorrectCount(randomWord.indexOf(guess) < 0, currentIncorrectGuesses);
            }
            index++; // change to the next index to be ready for the next guess
        }

        // check if the word has been fully guessed or not
        if (currentHiddenWord.indexOf('*') < 0) { // if yes, tell the player they won and calculate the player's
            System.out.printf("Congratulations! You guessed the word %s\n\n", randomWord);
            // give the max score minus the player's incorrect guesses
            currentScore = maxScore - currentIncorrectGuesses;
        } else // if no, tell the player they lost
            System.out.printf("GAME OVER\n\nThe word is %s.\n\n", randomWord);

        return currentScore; // return the player's score
    }

    // hides the chosen word with asterisks
    public static String initializeHiddenWord(String word) {
        String hiddenWord = "";
        for (int i = 0; i < word.length(); i++)
            hiddenWord += "*";
        return hiddenWord;
    }

    // gets the player's guess and checks for invalid input before returning the
    // guess
    public static char getLetterGuess(String currentHiddenWord) {
        char guess = ' ';
        while (true) {
            System.out.printf("Enter a letter in word %s > ", currentHiddenWord);
            if (input.hasNextLine()) {
                String rawInput = input.nextLine().toLowerCase();
                if (rawInput.length() == 1 && Character.isLetter(rawInput.charAt(0))) {
                    guess = rawInput.charAt(0);
                    break;
                }
            }
            System.out.println("Invalid Input! Enter a single letter");
        }
        return guess;
    }

    // checks whether the guessed letter is already guessed
    public static boolean letterAlreadyGuessed(char guess, char[] guessedLetters, int index) {
        for (int i = 0; i < index; i++) {
            if (guess == guessedLetters[i])
                return true;
        }
        return false;
    }

    // unhide the guessed letter
    public static String updateHiddenWord(String word, String hiddenWord, char guess) {
        String newHiddenWord = "";
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess)
                newHiddenWord += guess;
            else
                newHiddenWord += hiddenWord.charAt(i);
        }
        return newHiddenWord;
    }

    // +1 to the incorrect count when player incorrectly guesses
    public static int updateIncorrectCount(boolean correctGuess, int currentCount) {
        if (correctGuess)
            return ++currentCount;
        return currentCount;
    }

    // +1 to the correct count when player correctly guesses
    public static int awardPointForCorrectLetter(boolean correctGuess, int currentCount) {
        if (correctGuess)
            return ++currentCount;
        return currentCount;
    }
}
