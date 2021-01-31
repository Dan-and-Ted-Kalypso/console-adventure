package game;


import java.util.Scanner;

public class MummyBattle {

    private Hero hero;
    private Mummy mummy;
    private Scanner scanner;

    public MummyBattle(int[] heroArray) {

        this.hero = new Hero(heroArray);
        this.mummy = new Mummy();
        this.scanner = new Scanner(System.in);
    }

    public void battle() {

        System.out.println("What's that? Behind the pyramid? Eek! It's a mummy!");

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
                        mummy.changeEnemyHP(attackValue * -1);
                        System.out.printf("You hit the mummy for %d points!%n", attackValue);
                    }
                    if (mummy.getEnemyHP() <= 0) {
                        System.out.println("The mummy has 0 health points remaining!");
                        winMummyBattle();
                        break label;
                    } else {
                        System.out.printf("The mummy has %d health points remaining.%n", mummy.getEnemyHP());
                        int enemyAttackValue = mummy.generateAttackValue();
                        if (enemyAttackValue == 0) {
                            System.out.println("The mummy's attack missed!");
                        } else {
                            hero.changeHealthPoints(enemyAttackValue * -1);
                            System.out.printf("The mummy hits you for %d points!%n", enemyAttackValue);
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
                            System.out.println("The mummy manages to hit you as you run away! You have lost half of your remaining health points!");
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

    public void winMummyBattle() {
        System.out.println("You have defeated the cursed mummy!");
        System.out.println("You find a potion and 9 gold!");
        System.out.println("You feel yourself getting stronger! You have leveled up!");
        hero.levelUp();
        System.out.println("You find a hefty battleaxe half-buried in the sand. This could definitely do some damage to your enemies!");
        hero.addBattleAxe();
        hero.changePotionCount(1);
        hero.changeGold(9);
        hero.changeDesertWins();

        System.out.println("You have conquered all of the evil foes in the desert!");
        System.out.println("You decide to return to the crossroads.");
        Crossroads crossroads = new Crossroads(hero.getHero());
        crossroads.choosePath();
    }
}
