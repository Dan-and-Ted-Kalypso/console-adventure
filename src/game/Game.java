package game;
import java.util.Scanner;

public class Game {

    public Hero hero;
    public Scanner scanner;

    public void beginGame() {
        this.scanner = new Scanner(System.in);
        System.out.println("Welcome to your adventure! What is your name?");
        Scanner nameScanner = new Scanner(System.in);
        String name = nameScanner.nextLine();
        this.hero = new Hero(name);
        System.out.printf("Hello, %s! You are about to embark on a wild journey of heroism and chivalry! Let's begin!%n", name);
        while (!this.hero.isCoward && !this.hero.defeatedBoss) {
            battle();
        }

    }

    public void battle() {
        if (this.hero.winCounter < 3) {
            System.out.println("A challenger approaches! fight/run?");
            while (true) {
                String fightRun = scanner.nextLine();
                if (fightRun.equalsIgnoreCase("fight")) {
                    System.out.println("Let the battle begin!");
                    battleLoop();
                    break;
                } else if (fightRun.equalsIgnoreCase("run")) {
                    this.hero.isCoward = true;
                    System.out.println("You are a coward and unworthy of the title of hero. Game over!");
                    break;
                } else {
                    System.out.println("That is not a valid action. Fight or run?");
                }
            }
        } else {
            bossApproaches();
        }

    }

    public void battleLoop() {
        Enemy enemy = new Enemy();
        while (true) {
            if (this.hero.healthPoints <= 0) {
                System.out.println("You have died. Alas.");
                break;
            }

            while (true) {
                System.out.println("Do you wish to attack or drink potion?");
                String action = scanner.nextLine();
                if (action.equalsIgnoreCase("attack")) {
                    int attackValue = this.hero.attack(this.hero.hasSword);
                    System.out.printf("You attack the enemy, scoring a hit of %d points!%n", attackValue);
                    enemy.healthPoints -= attackValue;
                    System.out.printf("The enemy has %dHP remaining!%n", enemy.healthPoints);
                    break;
                } else if (action.equalsIgnoreCase("drink potion")) {
                    this.hero.usePotion();
                    break;
                } else {
                    System.out.println("That is not a valid action.");
                }
            }

            if (enemy.healthPoints <= 0) {
                System.out.println("Victory!");
                this.hero.winCounter++;
                if (this.hero.winCounter == 3) {
                    System.out.println("You have found a sword! This will make your attacks a lot stronger!\n");
                    this.hero.hasSword = true;
                } else {
                    this.hero.potionCount++;
                    System.out.printf("You have found a potion! Number of potions: %d%n", this.hero.potionCount);
                }
                break;
            }
            int enemyAttackValue = enemy.attack();
            System.out.printf("The enemy attacks you, scoring a hit of %d points!%n", enemyAttackValue);
            this.hero.healthPoints -= enemyAttackValue;
            System.out.printf("You have %dHP remaining!%n", this.hero.healthPoints);
        }
    }

    public void bossApproaches() {
        System.out.println("Uh oh! Here comes the big boss! And he looks angry! Fight or run?");

        while (true) {
            String action = scanner.nextLine();
            if (action.equalsIgnoreCase("fight")) {
                bossBattle();
                break;
            } else if (action.equalsIgnoreCase("run")) {
                hero.isCoward = true;
                System.out.println("You are a coward and unworthy of the title of hero. Game over!");
                break;
            } else {
                System.out.println("That is not a valid action. Fight or run?");
            }
        }
    }

    public void bossBattle() {
        Boss boss = new Boss();
        while (true) {

            if (this.hero.healthPoints <= 0) {
                System.out.println("You have died. Alas.");
                break;
            }
            while (true) {
                System.out.println("Do you wish to attack or drink potion?");
                String action = scanner.nextLine();
                if (action.equalsIgnoreCase("attack")) {
                    int attackValue = this.hero.attack(hero.hasSword);
                    System.out.printf("You attack the enemy, scoring a hit of %d points!%n", attackValue);
                    boss.healthPoints -= attackValue;
                    System.out.printf("The enemy has %dHP remaining!%n", boss.healthPoints);
                    break;
                } else if (action.equalsIgnoreCase("drink potion")) {
                    this.hero.usePotion();
                    break;
                } else {
                    System.out.println("That is not a valid action.");
                }
            }
            if (boss.healthPoints <= 0) {
                System.out.println("Congratulations! You have defeated the evil boss and restored peace to the lands. Your name will go down in the annals of history!");
                this.hero.defeatedBoss = true;
                break;
            }
            int bossAttackValue = boss.attack();
            System.out.printf("The enemy attacks you, scoring a hit of %d points!%n", bossAttackValue);
            this.hero.healthPoints -= bossAttackValue;
            System.out.printf("You have %dHP remaining!%n", this.hero.healthPoints);
        }
    }

}