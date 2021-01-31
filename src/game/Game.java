package game;

import java.util.Scanner;

public class Game {

    protected Hero hero;
    protected Scanner scanner;

    public void beginGame() {
        this.scanner = new Scanner(System.in);
        System.out.println("Welcome to your adventure! What is your name?");
        Scanner nameScanner = new Scanner(System.in);
        String name = nameScanner.nextLine();
        if (name.isEmpty()) {
            System.out.println("Don't want to tell me your name? Ok then. I shall call you Bartholomew!");
            System.out.println("Hello, Bartholomew! You are about to embark on a wild journey of heroism and chivalry! Let's begin!");
        } else {
            System.out.printf("Hello, %s! You are about to embark on a wild journey of heroism and chivalry! Let's begin!%n", name);
        }

        goToCrossroads();

    }


    public void goToCrossroads() {
        Crossroads crossroads = new Crossroads();
        crossroads.choosePath();
    }

}
