package org.example.design_patterns.Template;
import java.util.Scanner;
import java.util.Random;

public class DiceGame extends Game {
    private int[] playerScores;
    private int targetScore = 30;
    private int winner;
    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void initializeGame(int numberOfPlayers) {
        playerScores = new int[numberOfPlayers];
        System.out.println("Starting a Dice Race! First to " + targetScore + " points wins.");
    }

    @Override
    public boolean endOfGame() {
        for (int i = 0; i < playerScores.length; i++) {
            if (playerScores[i] >= targetScore) {
                winner = i;
                return true;
            }
        }
        return false;
    }

    @Override
    public void playSingleTurn(int player) {
        System.out.println("\nPlayer " + (player + 1) + "'s turn. Press Enter to roll...");
        scanner.nextLine();

        int roll = random.nextInt(6) + 1;
        playerScores[player] += roll;

        System.out.println("You rolled a " + roll + "!");
        System.out.println("Total score for Player " + (player + 1) + ": " + playerScores[player]);
    }

    @Override
    public void displayWinner() {
        System.out.println("\n--- GAME OVER ---");
        System.out.println("The winner is Player " + (winner + 1) + "!");
    }
}
