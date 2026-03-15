package org.example.design_patterns.State;

import java.util.Scanner;

public class GameApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameCharacter hero = new GameCharacter("Morgana");

        while (!(hero.getLevelName().contains("Master"))) {
            hero.displayStatus();
            System.out.print("Actions: (1) Train (2) Meditate (3) Fight (4) Quit: ");
            int choice = scanner.nextInt();

            if (choice == 1) hero.train();
            else if (choice == 2) hero.meditate();
            else if (choice == 3) hero.fight();
            else break;
        }
        System.out.println("Congratulations! You have reached Master level!");
    }
}
