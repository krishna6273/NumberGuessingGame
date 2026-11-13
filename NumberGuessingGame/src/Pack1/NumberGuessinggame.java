package Pack1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessinggame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        ArrayList<String> roundHistory = new ArrayList<>();

        int roundsPlayed = 0;
        int wins = 0;
        boolean playAgain = true;

        System.out.println("***********************************");
        System.out.println("       NUMBER GUESSING GAME        ");
        System.out.println("***********************************");

        while (playAgain) {

            roundsPlayed++;

            int min = 1;
            int max;
            int maxAttempts;

            System.out.println("\nSelect Difficulty:");
            System.out.println("1. Easy   (1-50, 10 attempts)");
            System.out.println("2. Medium (1-100, 7 attempts)");
            System.out.println("3. Hard   (1-200, 5 attempts)");

            int choice = 0;

            while (choice < 1 || choice > 3) {
                System.out.print("Enter your choice (1-3): ");

                try {
                    choice = Integer.parseInt(sc.nextLine().trim());

                    if (choice < 1 || choice > 3) {
                        System.out.println("Please select 1, 2 or 3.");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                }
            }

            if (choice == 1) {
                max = 50;
                maxAttempts = 10;
                System.out.println("Easy Mode Selected!");
            } else if (choice == 2) {
                max = 100;
                maxAttempts = 7;
                System.out.println("Medium Mode Selected!");
            } else {
                max = 200;
                maxAttempts = 5;
                System.out.println("Hard Mode Selected!");
            }

            int secretNumber = random.nextInt(max - min + 1) + min;

            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nGuess the number between "
                    + min + " and " + max);

            while (attempts < maxAttempts) {

                System.out.println("\nAttempt "
                        + (attempts + 1) + " of " + maxAttempts);

                System.out.print("Enter your guess: ");

                int guess;

                try {
                    guess = Integer.parseInt(sc.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Enter a number.");
                    continue;
                }

                if (guess < min || guess > max) {
                    System.out.println("Please enter a number between "
                            + min + " and " + max);
                    continue;
                }

                attempts++;

                if (guess < secretNumber) {
                    System.out.println("Too Low! Try a higher number.");
                } else if (guess > secretNumber) {
                    System.out.println("Too High! Try a lower number.");
                } else {
                    System.out.println("\nCorrect! Congratulations!");
                    System.out.println("You guessed it in "
                            + attempts + " attempts.");

                    guessedCorrectly = true;
                    wins++;
                    break;
                }
            }

            if (guessedCorrectly) {
                roundHistory.add("Round " + roundsPlayed
                        + " - guessed in " + attempts + " attempts");
            } else {
                System.out.println("\nYou Lost!");
                System.out.println("The correct number was: "
                        + secretNumber);

                roundHistory.add("Round " + roundsPlayed
                        + " - Not guessed");
            }

            System.out.println("\nDo you want to play again? (yes/no)");

            while (true) {
                System.out.print("Enter your choice: ");
                String answer = sc.nextLine().trim();

                if (answer.equalsIgnoreCase("yes")
                        || answer.equalsIgnoreCase("y")) {
                    playAgain = true;
                    break;
                } else if (answer.equalsIgnoreCase("no")
                        || answer.equalsIgnoreCase("n")) {
                    playAgain = false;
                    break;
                } else {
                    System.out.println("Please enter yes or no.");
                }
            }
        }

        System.out.println("\n************************************");
        System.out.println("            FINAL SCORE             ");
        System.out.println("************************************");

        for (String result : roundHistory) {
            System.out.println(result);
        }

        System.out.println("\nTotal Rounds Played: " + roundsPlayed);
        System.out.println("Total Wins: " + wins);
        System.out.println("Total Losses: " + (roundsPlayed - wins));

        System.out.println("\nThank you for playing!");

        sc.close();
    }
}
