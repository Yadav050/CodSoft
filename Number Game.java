import java.util.Scanner;
import java.util.Random;

class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Specify the lower bound of the range
        int lowerBound = 1;

        // Specify the upper bound of the range
        int upperBound = 50;
        int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;

        // Limit the number of attempts
        int maxAttempts = 3;

        System.out.println('\u263A' + " Welcome to the Number Guessing Game " + '\u263A');
        System.out.println("I've picked a number between " + lowerBound + " and " + upperBound + ".");
        System.out.println("Can you guess it?");

        // Option to play game
        System.out.print("Do You Want To Play ? (Yes/No): ");
        String playGame = scanner.next();
        if (playGame.equalsIgnoreCase("Yes")) {
            System.out.println('\u263A'+" Great "+'\u263A');
            System.out.println("Lets see can you guess it \nBest of Luck");
        } else {
            System.out.println("You Should Try at least once"); {
                return;
        }
}

        int attempts = 0;
        boolean guessedCorrectly = false;

        while (maxAttempts > attempts) {
            System.out.print("Enter your guess number: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == targetNumber) {
                guessedCorrectly = true;
                break;
            } else if (userGuess < targetNumber) {
                System.out.println("Low! Try again.");
            } else {
                System.out.println("High! Try again.");
            }
        }

        if (guessedCorrectly) {
            System.out.println("Congratulations! You guessed the correct number: " + targetNumber);
        } else {
            System.out.println("Sorry, you've reached the maximum number of attempts.");
            System.out.println("The correct number was: "+ targetNumber);
        }

        // Option to play again
        System.out.print("Play again? (yes/no): ");
        String playAgain = scanner.next();
        if (playAgain.equalsIgnoreCase("yes")) {
            main(args); // Recursive call to start a new round
        } else {
            System.out.println("Thanks for playing! Your score: " + (maxAttempts - attempts) + " attempts.");
        }

        scanner.close();
    }
}
