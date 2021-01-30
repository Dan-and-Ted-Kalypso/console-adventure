package game;

import java.util.Scanner;

public class Inn {

    protected Hero hero;
    protected Scanner scanner;
    protected int[] heroArray;

    public Inn(int[] heroArray) {

        this.hero = new Hero(heroArray);
        this.heroArray = hero.getHero();
        this.scanner = new Scanner(System.in);
    }



    public void stayOrGo() {
        System.out.println("Welcome to The Inn! You can rest and recharge your health points here.");
        while (true) {
            System.out.println("What do you want to do?");
            System.out.println("1: Stay for the night and recharge your health points.");
            System.out.println("2: Leave.");

            String input = scanner.nextLine();
            if (input.equals("1")) {
                stayAtInn(heroArray);
            } else if (input.equals("2")) {
                Crossroads crossroads = new Crossroads(heroArray);
                crossroads.choosePath();
                break;
            } else {
                System.out.println("That is not a valid input. Let's try this again.");
            }
        }


    }

    public void stayAtInn(int[] heroArray) {
        heroArray[1] = 50;
        System.out.println("After a night at the inn, you feel refreshed. You leave and travel to the crossroads to continue your adventure");
        Crossroads crossroads = new Crossroads(heroArray);
        crossroads.choosePath();
    }
}

/*
Make all enemies subclasses of enemy class?

Make all locations subclass of location class?
 */