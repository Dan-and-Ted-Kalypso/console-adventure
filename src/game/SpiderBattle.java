package game;


import java.util.Scanner;

public class SpiderBattle {

    private int[] heroArray;
    private Hero hero;
    private Spider spider;
    private Scanner scanner;

    public SpiderBattle(int[] heroArray) {
        this.heroArray = heroArray;
        this.hero = new Hero(heroArray);
        this.spider = new Spider();
        this.scanner = new Scanner(System.in);
    }

    public void battle() {

        System.out.println("");

        System.out.println("           ;               ,");
        System.out.println("         ,;                 '.");
        System.out.println("        ;:                   :;");
        System.out.println("       ::                     ::");
        System.out.println("       ::                     ::");
        System.out.println("       ':                     :");
        System.out.println("        :.                    :");
        System.out.println("        ::                   ::");
        System.out.println("    .'  ';                   ;'  '.");
        System.out.println("   ::    :;                 ;:    ::");
        System.out.println("   ;      :;.             ,;:     ::");
        System.out.println("   :;      :;:           ,;\"      ::");
        System.out.println("   ::.      ':;  :.,.:  ;:'     ,.;:");
        System.out.println("    \"'\"...   '::,::::: ;:   .;.;\"\"'");
        System.out.println("        '\"\"\"....;:::::;,;.;\"\"\"");
        System.out.println("    .:::.....'\"':::::::'\",...;::::;.");
        System.out.println("   ;:' '\"\"'\"\";.,;:::::;.'\"\"\"\"\"\"  ':;");
        System.out.println("  ::'         ;::;:::;::..         :;");
        System.out.println(" ::         ,;:::::::::::;:..       ::");
        System.out.println(" ;'     ,;;:;::::::::::::::;\";..    ':.");
        System.out.println("::     ;:\"  ::::::\"\"\"\"::::::  \":     ::");
        System.out.println(" :.    ::   :::::::  :::::::   :     ;");
        System.out.println("  ;    ::   :::::::  :::::::   :    ;");
        System.out.println("   '   ::   ::::::....:::::'  ,:   '");
        System.out.println("       ::    :::::::::::::\"   ::");
        System.out.println("       ::     ':::::::::\"'    ::");
        System.out.println("       ':       \"\"\"\"\"\"\"'      ::");
        System.out.println("        ::                   ;:");
        System.out.println("        ':;                 ;:\"");
        System.out.println("         ';              ,;'");
        System.out.println("           '            '");

        System.out.println("");

        System.out.println("You hear a rustling in the undergrowth and turn to see a giant spider rushing towards you!");

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
                        spider.changeEnemyHP(attackValue * -1);
                        System.out.printf("You hit the spider for %d points!%n", attackValue);
                    }
                    if (spider.getEnemyHP() <= 0) {
                        System.out.println("The spider has 0 health points remaining!");
                        winSpiderBattle();
                        break label;
                    } else {
                        System.out.printf("The spider has %d health points remaining.%n", spider.getEnemyHP());
                        int enemyAttackValue = spider.generateAttackValue();
                        if (enemyAttackValue == 0) {
                            System.out.println("The spider's attack missed!");
                        } else {
                            hero.changeHealthPoints(enemyAttackValue * -1);
                            System.out.printf("The spider hits you for %d points!%n", enemyAttackValue);
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
                            System.out.println("The spider manages to hit you as you run away! You have lost half of your remaining health points!");
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

    public void winSpiderBattle() {
        System.out.println("You have defeated the giant spider!");
        System.out.println("You find a potion and 6 gold!");
        hero.changePotionCount(1);
        hero.changeGold(6);
        hero.changeForestWins();
        while (true) {
            System.out.println("Would you like to stay in the forest?");
            this.heroArray = hero.getHero();
            System.out.printf("Current health points: %d.%n", heroArray[1]);
            System.out.printf("Current potion count: %d.%n", heroArray[0]);
            System.out.println("1: Stay in the forest.");
            System.out.println("2: Go back to the crossroads.");
            String action = scanner.nextLine();
            if (action.equals("1")) {
                Forest forest = new Forest();
                forest.stayOrGo(hero.getHero());
                break;
            } else if (action.equals("2")) {
                Crossroads crossroads = new Crossroads(hero.getHero());
                crossroads.choosePath();
                break;
            } else {
                System.out.println("That is not a valid action. Let's try this again.");
            }
        }

    }
}
