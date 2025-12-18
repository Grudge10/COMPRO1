import java.util.Scanner;

public class Hangman {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int playerCount = 0;
        int[] playerScores = new int[50];
        String[] playerNames = new String[50],
                easyWordBank = { "sun", "bed", "use", "pan", "owl", "net", "inn", "add", "die", "car", "bus", "job",
                        "van", "fat", "sex", "ban", "gap", "get", "tie", "bag", "act", "map", "day", "due", "shy",
                        "lay", "ant", "jaw", "ear", "ask", "mix", "put", "bad", "hit", "cap", "sit", "bat", "fly",
                        "rib", "fit", "cry", "bar", "tip", "hut", "jet", "set", "mug", "dog", "fax", "pit" },
                mediumWordBank = { "trial", "scene", "fairy", "shine", "image", "match", "beach", "ideal", "weigh",
                        "glare", "siege", "shock", "dairy", "grass", "bride", "torch", "climb", "crude", "scale",
                        "ankle", "north", "rider", "speed", "house", "clean", "ghost", "admit", "Venus", "still",
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

        while (playerCount < 50) {
            playerNames[playerCount] = getPlayerName();
            System.out.println();
            String[] wordBank = new String[50];
            int maxScore = 0;
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
            playerScores[playerCount] = playGame(wordBank, 3, maxScore);

            System.out.printf("Your final score %s is %d points\n\n", playerNames[playerCount],
                    playerScores[playerCount]);

            playerCount++;

            if (playerCount == 50)
                break;

            if (!anotherPlayer())
                break;
        }

        // sort the players from highest to lowest depending on their scores
        for (int i = 0; i < playerCount; i++) { // makes sure that all scores are sorted
            for (int o = 0; o < playerCount - 1; o++) { // sorts the scores from highest to lowest
                // if the current score is less than the next score swap the scores
                if (playerScores[o] < playerScores[o + 1]) {
                    // swap scores
                    int tempScore = playerScores[o]; // temporary placeholder for swapping
                    playerScores[o] = playerScores[o + 1];
                    playerScores[o + 1] = tempScore;

                    // swap names
                    String tempName = playerNames[o];
                    playerNames[o] = playerNames[o + 1];
                    playerNames[o + 1] = tempName;
                }
            }
        }

        System.out.println("\n===== LEADERBOARD =====");
        for (int i = 0; i < playerCount; i++) {
            System.out.printf("%s - %d points\n", playerNames[i], playerScores[i]);
        }
    }

    public static String getPlayerName() {
        System.out.print("Player Name: ");
        return input.nextLine();
    }

    public static boolean anotherPlayer() {
        char choice = ' ';
        while (true) {
            System.out.print("Another Player? Enter y or n: ");
            String rawInput = input.nextLine().toLowerCase();
            if (rawInput.length() > 0) {
                choice = rawInput.charAt(0);
                if (choice == 'y' || choice == 'n')
                    break;
            }
            System.out.println("invalid choice");
        }
        return choice == 'y' ? true : false;
    }

    public static int playGame(String[] wordBank, int maxIncorrect, int maxScore) {
        String randomWord = selectRandomWord(wordBank), currentHiddenWord = initializeHiddenWord(randomWord);
        int currentIncorrectGuesses = 0, index = 0, currentScore = 0;
        char[] guessedLetters = new char[100];
        while (currentIncorrectGuesses < maxIncorrect && !isWordFullyGuessed(currentHiddenWord)) {
            System.out.printf("Enter a letter in word %s > ", currentHiddenWord);
            char guess = getLetterGuess();
            if (letterAlreadyGuessed(guess, guessedLetters) == true) {
                System.out.printf("%s is already in the word\n", guess);
                continue;
            }
            updateGuessedLetters(guess, guessedLetters, index);
            if (randomWord.indexOf(guess) >= 0) {
                currentHiddenWord = updateHiddenWord(randomWord, currentHiddenWord, guess);
                currentScore = awardPointForCorrectLetter(true, currentScore);
            } else {
                System.out.printf("%s is not in the word\n", guess);
                currentIncorrectGuesses = updateIncorrectCount(isGuessCorrect(randomWord, guess),
                        currentIncorrectGuesses);
            }
            index++;
        }
        if (currentHiddenWord.indexOf('*') < 0) {
            System.out.printf("Congratulations! You guessed the word %s\n\n", randomWord);
            currentScore = calculateScore(true, maxScore, currentIncorrectGuesses);
        } else
            System.out.printf("GAME OVER\n\nThe word is %s.\n\n", randomWord);
        return currentScore;
    }

    public static String selectRandomWord(String[] wordBank) {
        return wordBank[(int) Math.floor(Math.random() * 50)];
    }

    public static String initializeHiddenWord(String word) {
        String hiddenWord = "";
        for (int i = 0; i < word.length(); i++)
            hiddenWord += "*";
        return hiddenWord;
    }

    public static char getLetterGuess() {
        char guess = ' ';
        while (true) {
            if (input.hasNextLine()) {
                String rawInput = input.nextLine().toLowerCase();
                if (rawInput.length() > 0 && rawInput.length() < 2) {
                    guess = rawInput.charAt(0);
                    if (guess != ' ')
                        break;
                }
            }
            System.out.println("Invalid Input! Enter a single letter");
        }
        return guess;
    }

    public static boolean letterAlreadyGuessed(char guess, char[] guessedLetters) {
        for (int i = 0; i < guessedLetters.length; i++) {
            if (guess == guessedLetters[i])
                return true;
        }
        return false;
    }

    public static void updateGuessedLetters(char guess, char[] guessedLetters, int index) {
        guessedLetters[index] = guess;
    }

    public static boolean isGuessCorrect(String word, char guess) {
        return word.indexOf(guess) >= 0;
    }

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

    public static int updateIncorrectCount(boolean correctGuess, int currentCount) {
        if (correctGuess == false)
            return ++currentCount;
        return currentCount;
    }

    public static boolean isWordFullyGuessed(String hiddenWord) {
        return hiddenWord.indexOf('*') < 0;
    }

    public static int calculateScore(boolean wholeWordGuessed, int maxScore, int incorrectCount) {
        if (wholeWordGuessed)
            return maxScore - incorrectCount;
        return 0;
    }

    public static int awardPointForCorrectLetter(boolean correctGuess, int currentCount) {
        if (correctGuess)
            return ++currentCount;
        return currentCount;
    }
}
