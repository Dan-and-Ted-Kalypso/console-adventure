package game;


import java.util.Scanner;

public class MummyBattle {

    private final Hero hero;
    private final Mummy mummy;
    private final Scanner scanner;
    private final String name;

    public MummyBattle(int[] heroArray, String name) {

        this.hero = new Hero(heroArray, name);
        this.mummy = new Mummy();
        this.scanner = new Scanner(System.in);
        this.name = name;
    }

    public void battle() {

        System.out.println("");

        System.out.println("             ,-===-.");
        System.out.println("     ,-.    /=,(o).=\\");
        System.out.println("        \\  /==|o_0|==\\");
        System.out.println("         \\(===\\ - /===)");
        System.out.println("          \\`=.=|J|=,=',-.");
        System.out.println("           X `=' `=' X  |\\");
        System.out.println("          / \\       / \\ | \\");
        System.out.println("         /  /|\\`x'/|\\  \\`--'");
        System.out.println("        ( `\"\"`-'_`-'\"\"' )");
        System.out.println("         `--T\"\"\\  \"\"T--'");
        System.out.println("            ]   \\   [");
        System.out.println("            [\"\"-o\\\"\"]");

        System.out.println("");

        System.out.println("What's that? Behind the pyramid? Eek! It's a mummy!");
        System.out.println("Press enter to continue.");
        scanner.nextLine();

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
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                    } else {
                        mummy.changeEnemyHP(attackValue * -1);
                        System.out.printf("You hit the mummy for %d points!%n", attackValue);
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                    }
                    if (mummy.getEnemyHP() <= 0) {
                        System.out.println("The mummy has 0 health points remaining!");
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                        winMummyBattle();
                        break label;
                    } else {
                        System.out.printf("The mummy has %d health points remaining.%n", mummy.getEnemyHP());
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                        int enemyAttackValue = mummy.generateAttackValue();
                        if (enemyAttackValue == 0) {
                            System.out.println("The mummy's attack missed!");
                            System.out.println("Press enter to continue.");
                            scanner.nextLine();
                        } else {
                            hero.changeHealthPoints(enemyAttackValue * -1);
                            System.out.printf("The mummy hits you for %d points!%n", enemyAttackValue);
                            System.out.println("Press enter to continue.");
                            scanner.nextLine();
                        }
                        if (hero.getHealthPoints() <= 0) {
                            System.out.println("You have no health points remaining! Oh no!");
                            System.out.println("Press enter to continue.");
                            scanner.nextLine();
                            hero.die();
                            break label;
                        } else {
                            System.out.printf("You have %d health points remaining.%n", hero.getHealthPoints());
                            System.out.println("Press enter to continue.");
                            scanner.nextLine();
                        }
                    }


                    break;
                case "2":

                    hero.usePotion();
                    int enemyAttackValue = mummy.generateAttackValue();
                    if (enemyAttackValue == 0) {
                        System.out.println("The mummy's attack missed!");
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                    } else {
                        hero.changeHealthPoints(enemyAttackValue * -1);
                        System.out.printf("The mummy hits you for %d points!%n", enemyAttackValue);
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                    }
                    if (hero.getHealthPoints() <= 0) {
                        System.out.println("You have no health points remaining! Oh no!");
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                        hero.die();
                        break label;
                    } else {
                        System.out.printf("You have %d health points remaining.%n", hero.getHealthPoints());
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                    }

                    break;
                case "3":
                    int runSuccess = hero.attemptRun();
                    if (runSuccess == 1) {
                        System.out.println("You got away safely!");
                        System.out.println("You return to the crossroads.");
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                        Crossroads crossroads = new Crossroads(hero.getHero(), name);
                        crossroads.choosePath();
                    } else {

                        if (hero.getHealthPoints() == 1) {
                            System.out.println("You got away safely!");
                            System.out.println("You return to the crossroads.");
                            System.out.println("Press enter to continue.");
                            scanner.nextLine();
                            Crossroads crossroads = new Crossroads(hero.getHero(), name);
                            crossroads.choosePath();
                        } else {
                            System.out.println("The mummy manages to hit you as you run away! You have lost half of your remaining health points!");
                            hero.changeHealthPoints((hero.getHealthPoints() / 2) * -1);
                            System.out.printf("You now have %d health points remaining.%n", hero.getHealthPoints());
                            System.out.println("You return to the crossroads.");
                            System.out.println("Press enter to continue.");
                            scanner.nextLine();
                            Crossroads crossroads = new Crossroads(hero.getHero(), name);
                            crossroads.choosePath();
                        }
                    }
                    break label;
                default:
                    System.out.println("That is not a valid action. Let's try this again.");
                    System.out.println("");
                    break;
            }
        }
    }

    public void winMummyBattle() {
        System.out.println("You have defeated the cursed mummy!");
        System.out.println("Press enter to continue.");
        scanner.nextLine();
        System.out.println("You find a potion and 9 gold!");
        System.out.println("Press enter to continue.");
        scanner.nextLine();
        System.out.println("You feel yourself getting stronger! You have leveled up!");
        System.out.println("Press enter to continue.");
        scanner.nextLine();
        hero.levelUp();

        System.out.println("");

        System.out.println("                                           _.gd8888888bp._");
        System.out.println("                                        .g88888888888888888p.");
        System.out.println("                                      .d8888P\"\"       \"\"Y8888b.");
        System.out.println("                                      \"Y8P\"               \"Y8P'");
        System.out.println("                                         `.               ,'");
        System.out.println("                                           \\     .-.     /");
        System.out.println("                                            \\   (___)   /");
        System.out.println(" .------------------._______________________:__________j");
        System.out.println("/                   |                      |           |`-.,_");
        System.out.println("\\###################|######################|###########|,-'`");
        System.out.println(" `------------------'                       :    ___   l");
        System.out.println("                                            /   (   )   \\");
        System.out.println("                                           /     `-'     \\");
        System.out.println("                                         ,'               `.");
        System.out.println("                                      .d8b.               .d8b.");
        System.out.println("                                      \"Y8888p..       ,.d8888P\"");
        System.out.println("                                        \"Y88888888888888888P\"");
        System.out.println("                                           \"\"YY8888888PP\"\"");

        System.out.println("");

        System.out.println("You find a hefty battleaxe half-buried in the sand. This could definitely do some damage to your enemies!");
        System.out.println("Press enter to continue.");
        scanner.nextLine();
        hero.addBattleAxe();
        hero.changePotionCount(1);
        hero.changeGold(9);
        hero.changeDesertWins();
        System.out.println("You have conquered all of the evil foes in the desert!");
        System.out.println("You decide to return to the crossroads.");
        System.out.println("Press enter to continue.");
        scanner.nextLine();
        Crossroads crossroads = new Crossroads(hero.getHero(), name);
        crossroads.choosePath();
    }
}
