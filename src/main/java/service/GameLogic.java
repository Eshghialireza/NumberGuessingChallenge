package service;

import java.util.Scanner;

public class GameLogic {
    static int userTries = 0;
    Scanner sc = new Scanner(System.in);

    public void start() {
        int numberToGuess = randomNumber();
        validate(asker(), numberToGuess);

    }

    private int randomNumber() {
        int lowerBound;
        int upperBound;
        try {
            System.out.println("Please enter the min number: ");
            lowerBound = sc.nextInt();
            System.out.println("please enter the max number: ");
            upperBound = sc.nextInt();
        } catch (Exception e) {
            System.out.println("please enter a valid number");
            return randomNumber();
        }
        if (lowerBound >= upperBound) {
            System.out.println("Minimum number must be less than the maximum number. Please try again.");
            return randomNumber();
        }
        return (int) (Math.random() * (upperBound - lowerBound + 1)) + lowerBound;
    }

    private int asker() {
        System.out.println("enter your guess : ");
        int guess;
        try {
            guess = sc.nextInt();
        } catch (Exception e) {
            System.out.println("please enter a valid number");
            return asker();
        }
        return guess;
    }

    private void validate(int userGuess, int correctNumber) {
        userTries++;
        if (userGuess == correctNumber) {
            System.out.println("You guessed correctly!");
            System.out.println(getTryCount());
        } else if (userGuess > correctNumber) {
            System.out.println("this guess is higher than the number. Please try again.");
            validate(asker(), correctNumber);
        } else if (userGuess < correctNumber) {
            System.out.println("this guess is lower than number. Please try again.");
            validate(asker(), correctNumber);
        }
    }

    public int getTryCount() {
        return userTries;
    }
}
