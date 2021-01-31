package game;


import java.util.Scanner;

public class UrukBattle {

    private int[] heroArray;
    private Hero hero;
    private Uruk uruk;
    private Scanner scanner;

    public UrukBattle(int[] heroArray) {
        this.heroArray = heroArray;
        this.hero = new Hero(heroArray);
        this.uruk = new Uruk();
        this.scanner = new Scanner(System.in);
    }

    public void battle() {
        int enemyHP = uruk.getEnemyHP();
        int heroHP = hero.getHealthPoints();

        System.out.println("It's an Uruk-Hai! He looks like he's hungry, and meat's back on the menu!");

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
                        uruk.changeEnemyHP(attackValue * -1);
                        System.out.printf("You hit the Uruk-Hai for %d points!%n", attackValue);
                    }
                    if (uruk.getEnemyHP() <= 0) {
                        System.out.println("The Uruk-Hai has 0 health points remaining!");
                        winUrukBattle();
                        break label;
                    } else {
                        System.out.printf("The Uruk-Hai has %d health points remaining.%n", uruk.getEnemyHP());
                        int enemyAttackValue = uruk.generateAttackValue();
                        if (enemyAttackValue == 0) {
                            System.out.println("The Uruk-Hai's attack missed!");
                        } else {
                            hero.changeHealthPoints(enemyAttackValue * -1);
                            System.out.printf("The Uruk-Hai hits you for %d points!%n", enemyAttackValue);
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
                    int runSuccess = hero.attemptRun();
                    if (runSuccess == 1) {
                        System.out.println("You got away safely!");
                        System.out.println("You return to the crossroads.");
                        Crossroads crossroads = new Crossroads(hero.getHero());
                        crossroads.choosePath();
                    } else {

                        if (hero.getHealthPoints() == 1) {
                            System.out.println("You got away safely!");
                            System.out.println("You return to the crossroads.");
                            Crossroads crossroads = new Crossroads(hero.getHero());
                            crossroads.choosePath();
                        } else {
                            System.out.println("The Uruk-Hai manages to hit you as you run away! You have lost half of your remaining health points!");
                            hero.changeHealthPoints((hero.getHealthPoints() / 2) * -1);
                            System.out.printf("You now have %d health points remaining.%n", hero.getHealthPoints());
                            System.out.println("You return to the crossroads.");
                            Crossroads crossroads = new Crossroads(hero.getHero());
                            crossroads.choosePath();
                        }
                    }
                    break label;
                default:
                    System.out.println("That is not a valid action. Let's try this again.");
                    break;
            }
        }
    }

    public void winUrukBattle() {
        System.out.println("You beat the Uruk-Hai!");
        System.out.println("You find a potion and 10 gold!");
        System.out.println("You feel yourself getting stronger! You have leveled up!");
        hero.levelUp();
        System.out.println("You search the Uruk-Hai's cave and find a huge, glittering sword! It looks powerful.");
        hero.addExcalibur();
        hero.changePotionCount(1);
        hero.changeGold(10);
        hero.changeMountainWins();

        System.out.println("You have conquered all of the evil foes in the mountains!");
        System.out.println("You decide to return to the crossroads.");
        Crossroads crossroads = new Crossroads(hero.getHero());
        crossroads.choosePath();

    }
}
