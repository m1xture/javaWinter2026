package com.app.rps;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.random.RandomGenerator;

public class GameService {

    Map<RPS, RPS> winCases = Map.ofEntries(Map.entry(RPS.ROCK, RPS.SCISSORS), Map.entry(RPS.PAPER, RPS.ROCK), Map.entry(RPS.SCISSORS, RPS.PAPER));

    private void showStartMenu() {
        System.out.println("---RPS---");
        short i = 0;
        for (RPS val : RPS.values()) {
            System.out.printf("%d) %s%n", ++i, val);
        }
    }

    private RPS getPlayerChoice() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            try {
                System.out.print("Make your choice: ");
                choice = scanner.nextInt();
                if (choice < 1 || choice > RPS.values().length) {
                    throw new InputMismatchException("Invalid value");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid value");
                scanner.nextLine();
                choice = 0;
            }
        } while (choice < 1 || choice > RPS.values().length);
        scanner.close();
        return RPS.values()[choice - 1];
    }

    private GameResult calculateWinner(RPS playerChoice, RPS computerChoice) {
        if (playerChoice == computerChoice) {
            return GameResult.DRAW;
        }
        if (winCases.get(playerChoice) == computerChoice) {
            return GameResult.WIN;
        } else {
            return GameResult.LOSE;
        }
    }

    public void startGame() {
        showStartMenu();
        RPS playerChoice = getPlayerChoice();
        RPS computerChoice = RPS.values()[(int) (Math.random() * (RPS.values().length))];
        System.out.printf("%nyour choice: %s%n", playerChoice);
        System.out.printf("computer's choice: %s%n", computerChoice);
        GameResult res = calculateWinner(playerChoice, computerChoice);
        System.out.printf("Result: %s", res);
    }
}
