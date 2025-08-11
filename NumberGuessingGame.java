import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        final int MAX_ATTEMPTS = 8;
        int score = 0;
        int round = 0;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain = true;

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1; // random number between 1 and 100
            int attempts = 0;
            round++;
            boolean guessedCorrectly = false;

            System.out.println("\n🎯 Round " + round + ": Guess the number between 1 and 100!");

            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Enter your guess (" + (MAX_ATTEMPTS - attempts) + " attempts left): ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == numberToGuess) {
                    System.out.println("✅ Correct! You guessed the number in " + attempts + " attempt(s).");
                    score++;
                    guessedCorrectly = true;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("⬆️ Too low!");
                } else {
                    System.out.println("⬇️ Too high!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("❌ You've used all attempts. The correct number was: " + numberToGuess);
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            scanner.nextLine(); // consume newline
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes") || response.equals("y");
        }

        System.out.println("\n🎉 Game Over! You played " + round + " round(s) and guessed correctly " + score + " time(s).");
        scanner.close();
    }
}
