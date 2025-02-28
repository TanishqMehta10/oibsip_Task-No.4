package com.mycompany.javapractise;
import java.util.Random;
import java.util.Scanner;

public class NumGuessGame {
    private static final int MAX_ATTEMPTS = 10;
    private static final int MAX_ROUNDS = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalScore = 0;
        int[] roundScores = new int[MAX_ROUNDS];

        System.out.println("Welcome to Guess the Number Game!");
        
        for (int round = 1; round <= MAX_ROUNDS; round++) {
            int targetNumber = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;
            
            System.out.println("\nRound " + round + " begins! Try to guess the number between 1 and 100.");
            
            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;
                
                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    int score = (MAX_ATTEMPTS - attempts + 1) * 10;
                    totalScore += score;
                    roundScores[round - 1] = score;
                    guessedCorrectly = true;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }
            
            if (!guessedCorrectly) {
                System.out.println("Out of attempts! The correct number was: " + targetNumber);
                roundScores[round - 1] = 0;
            }
        }
        
        // Display score table
        System.out.println("\nGame Over! Here is your score summary:");
        System.out.println("---------------------------------");
        System.out.printf("| %-10s | %-10s |\n", "Round", "Score");
        System.out.println("---------------------------------");
        for (int i = 0; i < MAX_ROUNDS; i++) {
            System.out.printf("| %-10d | %-10d |\n", (i + 1), roundScores[i]);
        }
        System.out.println("---------------------------------");
        System.out.println("Total Score: " + totalScore);
        scanner.close();
    }
}


