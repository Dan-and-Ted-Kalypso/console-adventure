package game;


import java.util.Scanner;

public class SnakeBattle {

    private int[] heroArray;
    private Hero hero;
    private Snake snake;
    private Scanner scanner;

    public SnakeBattle(int[] heroArray) {
        this.heroArray = heroArray;
        this.hero = new Hero(heroArray);
        this.snake = new Snake();
        this.scanner = new Scanner(System.in);
    }

    public void battle() {
        int enemyHP = snake.getEnemyHP();
        int heroHP = hero.getHealthPoints();

        System.out.println("A giant snake explodes from out of the sand! Those fangs are massive!");

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
                        snake.changeEnemyHP(attackValue * -1);
                        System.out.printf("You hit the snake for %d points!%n", attackValue);
                    }
                    if (snake.getEnemyHP() <= 0) {
                        System.out.println("The snake has 0 health points remaining!");
                        winSnakeBattle();
                        break label;
                    } else {
                        System.out.printf("The snake has %d health points remaining.%n", snake.getEnemyHP());
                        int enemyAttackValue = snake.generateAttackValue();
                        if (enemyAttackValue == 0) {
                            System.out.println("The snake's attack missed!");
                        } else {
                            hero.changeHealthPoints(enemyAttackValue * -1);
                            System.out.printf("The snake hits you for %d points!%n", enemyAttackValue);
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
                            System.out.println("The snake manages to hit you as you run away! You have lost half of your remaining health points!");
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

    public void winSnakeBattle() {
        System.out.println("You have defeated the giant snake!");
        System.out.println("You find a potion and 8 gold!");
        hero.changePotionCount(1);
        hero.changeGold(8);
        hero.changeDesertWins();
        while (true) {
            System.out.println("Would you like to stay in the desert?");
            this.heroArray = hero.getHero();
            System.out.printf("Current health points: %d.%n", heroArray[1]);
            System.out.printf("Current potion count: %d.%n", heroArray[0]);
            System.out.println("1: Stay in the desert.");
            System.out.println("2: Go back to the crossroads.");
            String action = scanner.nextLine();
            if (action.equals("1")) {
                Desert desert = new Desert();
                desert.stayOrGo(hero.getHero());
                break;
            } else if (action.equals("2")) {
                Crossroads crossroads = new Crossroads(hero.getHero());
                crossroads.choosePath();
            } else {
                System.out.println("That is not a valid action. Let's try this again.");
            }
        }

    }
}
