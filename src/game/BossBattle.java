package game;

import java.util.Scanner;

public class BossBattle {

    private int[] heroArray;
    private Hero hero;
    private Boss boss;
    private Scanner scanner;


    public BossBattle(int[] heroArray) {
        this.heroArray = heroArray;
        this.hero = new Hero(heroArray);
        this.boss = new Boss();
        this.scanner = new Scanner(System.in);

    }

    public void battle() {

        hero.changeHealthPoints(500);

        hero.addExcalibur();

        System.out.println("So it begins. The great battle of our time...");
        label:
        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("1: Attack.");
            System.out.println("2: Drink potion.");
            System.out.println("3: Run.");
            String action = scanner.nextLine();

            switch (action) {
                case "1":
                    int attackValue = hero.generateAttackValue();
                    if (attackValue == 0) {
                        System.out.println("Your attack missed!");
                    } else {
                        boss.changeEnemyHP(attackValue * -1);
                        System.out.printf("You hit the boss for %d points!%n", attackValue);
                    }
                    if (boss.getEnemyHP() <= 0) {
                        System.out.println("The boss has 0 health points remaining!");
                        winBossBattle();
                        break label;
                    } else {
                        System.out.printf("The boss has %d health points remaining.%n", boss.getEnemyHP());
                        int enemyAttackValue = boss.generateAttackValue();
                        if (enemyAttackValue == 0) {
                            System.out.println("The boss' attack missed! Whew!");
                        } else {
                            hero.changeHealthPoints(enemyAttackValue * -1);
                            System.out.printf("The boss hits you for %d points! Ouch!%n", enemyAttackValue);
                        }
                        if (hero.getHealthPoints() <= 0) {
                            System.out.println("You have no health points remaining! Oh no!");
                            hero.die();
                            break label;
                        } else {
                            System.out.printf("You have %d health points remaining.%n", hero.getHealthPoints());
                        }
                    }


                    break;
                case "2":

                    hero.usePotion();

                    break;
                case "3":
                    System.out.println("You can't run away! This is the BOSS BATTLE, ya dingus!");
                default:
                    System.out.println("That is not a valid action. Let's try this again.");
                    break;
            }
        }
    }

    public void winBossBattle() {
        System.out.println("You have defeated the great and powerful boss and ended his reign of tyranny o'er this land!");
        System.out.println("Your name will surely go down in the annals of history!");
    }
}
