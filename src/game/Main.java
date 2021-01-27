package game;

import java.util.*;

public class Main {

    public static String name;
    public static int heroHP;

    public static void beginGame() {
        System.out.println("Welcome to your adventure! What is your name?");
        Scanner nameScanner = new Scanner(System.in);
        name = nameScanner.nextLine();
        System.out.printf("Hello, %s! You are about to embark on a wild journey of heroism and chivalry! Let's begin!%n", name);
    }

    public static void battle() {
        System.out.println("A challenger approaches! fight/run?");
        Scanner scanner = new Scanner(System.in);
        String fightRun = scanner.nextLine();
        if (fightRun.equalsIgnoreCase("fight")) {
            System.out.println("Let the battle begin!");
            int enemyHP = 50;
            while (true) {
                if (heroHP <= 0) {
                    System.out.println("You have died. Alas.");
                    break;
                }
                System.out.println("Do you wish to attack or drink potion?");
                String action = scanner.nextLine();
                if (action.equalsIgnoreCase("attack")) {
                    int attackValue = heroAttack();
                    System.out.printf("You attack the enemy, scoring a hit of %d points!%n", attackValue);
                    enemyHP -= attackValue;
                    System.out.printf("The enemy has %dHP remaining!%n", enemyHP);
                } else {
                    usePotion();
                }
                if (enemyHP <= 0) {
                    System.out.println("Victory!");
                    break;
                }
                int enemyAttackValue = enemyAttack();
                System.out.printf("The enemy attacks you, scoring a hit of %d points!%n", enemyAttackValue);
                heroHP -= enemyAttackValue;
                System.out.printf("You have %dHP remaining!%n", heroHP);
            }
        } else {
            System.out.println("You are a coward and unworthy of the title of hero. Game over!");
        }
    }

    //attack
    //run
    //use potion

    public static int heroAttack() {
        return (int) ((Math.random() * (10 - 1)) + 1);
    }

    public static int enemyAttack() {
        return (int) ((Math.random() * (5 - 1)) + 1);
    }

    public static void usePotion() {
        heroHP += 10;
        System.out.printf("You now have %d HP remaining.%n", heroHP);
    }

    public static void main(String[] args) {
        beginGame();
        Hero yourHero = new Hero(name);
        heroHP = yourHero.healthPoints;

        battle();
    }
}
