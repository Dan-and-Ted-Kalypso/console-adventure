package game;

import java.util.*;

public class Main {

    public static String name;
    public static int heroHP;
    public static int winCounter = 0;
    public static boolean hasSword = false;
    public static int potionCount;
    public static boolean coward = false;
    public static boolean bossWin = false;

    public static void beginGame() {
        System.out.println("Welcome to your adventure! What is your name?");
        Scanner nameScanner = new Scanner(System.in);
        name = nameScanner.nextLine();
        System.out.printf("Hello, %s! You are about to embark on a wild journey of heroism and chivalry! Let's begin!%n", name);
    }

    public static void battle() {
        if (winCounter < 3) {
            System.out.println("A challenger approaches! fight/run?");
            Scanner scanner = new Scanner(System.in);

            while (true) {
                String fightRun = scanner.nextLine();
                if (fightRun.equalsIgnoreCase("fight")) {
                    System.out.println("Let the battle begin!");
                    battleLoop();
                    break;
                } else if (fightRun.equalsIgnoreCase("run")) {
                    coward = true;
                    System.out.println("You are a coward and unworthy of the title of hero. Game over!");
                    break;
                } else {
                    System.out.println("That is not a valid action. Fight or run?");
                }
            }
        } else {
          bossBattle();
        }

    }

    public static void bossBattle() {

        System.out.println("Uh oh! Here comes the big boss! And he looks angry! Fight or run?");
        Scanner bossScanner = new Scanner(System.in);


        while (true) {
            String action = bossScanner.nextLine();
            if (action.equalsIgnoreCase("fight")) {
                bossBattleLoop();
                break;
            } else if (action.equalsIgnoreCase("run")) {
                coward = true;
                System.out.println("You are a coward and unworthy of the title of hero. Game over!");
                break;
            } else {
                System.out.println("That is not a valid action. Fight or run?");
            }
        }

    }

    public static void battleLoop() {
        Scanner battleScanner = new Scanner(System.in);
        int enemyHP = 20;
        while (true) {
            if (heroHP <= 0) {
                System.out.println("You have died. Alas.");
                break;
            }

            while (true) {
                System.out.println("Do you wish to attack or drink potion?");
                String action = battleScanner.nextLine();
                if (action.equalsIgnoreCase("attack")) {
                    int attackValue = heroAttack();
                    System.out.printf("You attack the enemy, scoring a hit of %d points!%n", attackValue);
                    enemyHP -= attackValue;
                    System.out.printf("The enemy has %dHP remaining!%n", enemyHP);
                    break;
                } else if (action.equalsIgnoreCase("drink potion")) {
                    usePotion();
                    break;
                } else {
                    System.out.println("That is not a valid action.");
                }
            }

            if (enemyHP <= 0) {
                System.out.println("Victory!");
                winCounter++;
                if (winCounter == 3) {
                    System.out.println("You have found a sword! This will make your attacks a lot stronger!\n");
                    hasSword = true;
                } else {
                    potionCount++;
                    System.out.printf("You have found a potion! Number of potions: %d%n", potionCount);
                }
                break;
            }
            int enemyAttackValue = enemyAttack();
            System.out.printf("The enemy attacks you, scoring a hit of %d points!%n", enemyAttackValue);
            heroHP -= enemyAttackValue;
            System.out.printf("You have %dHP remaining!%n", heroHP);
        }
    }

    public static void bossBattleLoop() {
        Scanner scanner = new Scanner(System.in);
        int bossHP = 50;
        while (true) {

            if (heroHP <= 0) {
                System.out.println("You have died. Alas.");
                break;
            }
            while (true) {
                System.out.println("Do you wish to attack or drink potion?");
                String action = scanner.nextLine();
                if (action.equalsIgnoreCase("attack")) {
                    int attackValue = heroAttack();
                    System.out.printf("You attack the enemy, scoring a hit of %d points!%n", attackValue);
                    bossHP -= attackValue;
                    System.out.printf("The enemy has %dHP remaining!%n", bossHP);
                    break;
                } else if (action.equalsIgnoreCase("drink potion")) {
                    usePotion();
                    break;
                } else {
                    System.out.println("That is not a valid action.");
                }
            }
            if (bossHP <= 0) {
                System.out.println("Congratulations! You have defeated the evil boss and restored peace to the lands. Your name will go down in the annals of history!");
                bossWin = true;
                break;
            }
            int bossAttackValue = bossAttack();
            System.out.printf("The enemy attacks you, scoring a hit of %d points!%n", bossAttackValue);
            heroHP -= bossAttackValue;
            System.out.printf("You have %dHP remaining!%n", heroHP);
        }
    }

    public static int heroAttack() {
        if (hasSword) {
            return (int) ((Math.random() * (50 - 5)) + 5);
        }
        return (int) ((Math.random() * (100 - 50)) + 50);
    }

    public static int enemyAttack() {
        return (int) ((Math.random() * (5 - 1)) + 1);
    }

    public static int bossAttack() {
        return (int) ((Math.random() * (10 - 5)) + 5);
    }

    public static void usePotion() {
        if (potionCount > 0) {
            heroHP += 10;
            potionCount -= 1;
            System.out.printf("You now have %d HP remaining. Potions remaining: %d%n", heroHP, potionCount);
        } else {
            System.out.println("You don't have any potions left!");
        }
    }

    public static void main(String[] args) {
        beginGame();
        Hero yourHero = new Hero(name);
        heroHP = yourHero.healthPoints;
        potionCount = yourHero.heroPotion;
        while (!coward && !bossWin) {
            battle();
        }
    }
}
