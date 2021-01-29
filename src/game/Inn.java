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



    public void stayOrGo(int[] heroArray) {
        System.out.println("Welcome to The Inn! You can rest and recharge your health points here.");

    }
}

/*
Make all enemies subclasses of enemy class?

Make all locations subclass of location class?
 */