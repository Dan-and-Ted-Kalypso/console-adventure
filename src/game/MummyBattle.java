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

        System.out.println(ConsoleColors.YELLOW + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
        System.out.println("");

        System.out.println(ConsoleColors.YELLOW +"             ,-===-.");
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
        System.out.println("            [\"\"-o\\\"\"]" + ConsoleColors.RESET);

        System.out.println(ConsoleColors.YELLOW + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);

        System.out.println(ConsoleColors.YELLOW + "What's that? Behind the pyramid? Eek! It's a mummy!" + ConsoleColors.RESET);
        System.out.println("Press enter to continue.");
        System.out.println(ConsoleColors.YELLOW + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
        scanner.nextLine();


        label:
        while (true) {
            System.out.println(ConsoleColors.PURPLE + "What would you like to do?" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN + "1: Attack." + ConsoleColors.RESET);
            System.out.println(ConsoleColors.GREEN + "2: Drink potion." + ConsoleColors.RESET);
            System.out.println(ConsoleColors.YELLOW + "3: Run." + ConsoleColors.RESET);
            String action = scanner.nextLine();

            switch (action) {
                case "1":
                    int attackValue = hero.generateAttackValue();
                    if (attackValue == 0) {
                        System.out.println(ConsoleColors.YELLOW + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        System.out.println(ConsoleColors.RED + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        System.out.println(ConsoleColors.RED + "Your attack missed!" + ConsoleColors.RESET);
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                        System.out.println(ConsoleColors.RED + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                    } else {
                        mummy.changeEnemyHP(attackValue * -1);
                        System.out.println(ConsoleColors.YELLOW + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        System.out.printf(ConsoleColors.GREEN + "You hit the mummy for %d points!%n" + ConsoleColors.RESET, attackValue);
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                        System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                    }
                    if (mummy.getEnemyHP() <= 0) {
                        System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        System.out.println(ConsoleColors.GREEN + "The mummy has 0 health points remaining!" + ConsoleColors.RESET);
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                        System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        winMummyBattle();
                        break label;
                    } else {
                        System.out.println(ConsoleColors.YELLOW + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        System.out.printf(ConsoleColors.YELLOW + "The mummy has %d health points remaining.%n" + ConsoleColors.RESET, mummy.getEnemyHP());
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                        System.out.println(ConsoleColors.YELLOW + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        int enemyAttackValue = mummy.generateAttackValue();
                        if (enemyAttackValue == 0) {
                            System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                            System.out.println(ConsoleColors.GREEN + "The mummy's attack missed!" + ConsoleColors.RESET);
                            System.out.println("Press enter to continue.");
                            scanner.nextLine();
                            System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        } else {
                            hero.changeHealthPoints(enemyAttackValue * -1);
                            System.out.println(ConsoleColors.RED + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                            System.out.printf(ConsoleColors.RED + "The mummy hits you for %d points!%n" + ConsoleColors.RESET, enemyAttackValue);
                            System.out.println("Press enter to continue.");
                            scanner.nextLine();
                            System.out.println(ConsoleColors.RED + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        }
                        if (hero.getHealthPoints() <= 0) {
                            System.out.println(ConsoleColors.RED + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                            System.out.println(ConsoleColors.RED + "You have no health points remaining! Oh no!" + ConsoleColors.RESET);
                            System.out.println("Press enter to continue.");
                            scanner.nextLine();
                            System.out.println(ConsoleColors.RED + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                            hero.die();
                            break label;
                        } else {
                            if (hero.getHealthPoints() > (hero.getMaxHP() / 3) + (hero.getMaxHP() / 3)) {
                                System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                                System.out.printf(ConsoleColors.GREEN + "You have %d health points remaining.%n" + ConsoleColors.RESET, hero.getHealthPoints());
                                System.out.println("Press enter to continue.");
                                scanner.nextLine();
                                System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                            } else if (hero.getHealthPoints() < (hero.getMaxHP() / 3) + 1) {
                                System.out.println(ConsoleColors.RED + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                                System.out.printf(ConsoleColors.RED + "You have %d health points remaining.%n" + ConsoleColors.RESET, hero.getHealthPoints());
                                System.out.println("Press enter to continue.");
                                scanner.nextLine();
                                System.out.println(ConsoleColors.RED + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                            } else {
                                System.out.println(ConsoleColors.YELLOW + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                                System.out.printf(ConsoleColors.YELLOW + "You have %d health points remaining.%n" + ConsoleColors.RESET, hero.getHealthPoints());
                                System.out.println("Press enter to continue.");
                                scanner.nextLine();
                                System.out.println(ConsoleColors.YELLOW + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                            }
                        }
                    }


                    break;
                case "2":

                    hero.usePotion();
                    int enemyAttackValue = mummy.generateAttackValue();
                    if (enemyAttackValue == 0) {
                        System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        System.out.println(ConsoleColors.GREEN + "The mummy's attack missed!" + ConsoleColors.RESET);
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                        System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                    } else {
                        hero.changeHealthPoints(enemyAttackValue * -1);
                        System.out.println(ConsoleColors.RED + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        System.out.printf(ConsoleColors.RED + "The mummy hits you for %d points!%n" + ConsoleColors.RESET, enemyAttackValue);
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                        System.out.println(ConsoleColors.RED + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                    }
                    if (hero.getHealthPoints() <= 0) {
                        System.out.println(ConsoleColors.RED + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        System.out.println(ConsoleColors.RED + "You have no health points remaining! Oh no!" + ConsoleColors.RESET);
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                        System.out.println(ConsoleColors.RED + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        hero.die();
                        break label;
                    } else {
                        if (hero.getHealthPoints() > (hero.getMaxHP() / 3) + (hero.getMaxHP() / 3)) {
                            System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                            System.out.printf(ConsoleColors.GREEN + "You have %d health points remaining.%n" + ConsoleColors.RESET, hero.getHealthPoints());
                            System.out.println("Press enter to continue.");
                            scanner.nextLine();
                            System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        } else if (hero.getHealthPoints() < (hero.getMaxHP() / 3) + 1) {
                            System.out.println(ConsoleColors.RED + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                            System.out.printf(ConsoleColors.RED + "You have %d health points remaining.%n" + ConsoleColors.RESET, hero.getHealthPoints());
                            System.out.println("Press enter to continue.");
                            scanner.nextLine();
                            System.out.println(ConsoleColors.RED + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        } else {
                            System.out.println(ConsoleColors.YELLOW + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                            System.out.printf(ConsoleColors.YELLOW + "You have %d health points remaining.%n" + ConsoleColors.RESET, hero.getHealthPoints());
                            System.out.println("Press enter to continue.");
                            scanner.nextLine();
                            System.out.println(ConsoleColors.YELLOW + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        }
                    }

                    break;
                case "3":
                    int runSuccess = hero.attemptRun();
                    if (runSuccess == 1) {
                        System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        System.out.println(ConsoleColors.CYAN + "You got away safely!" + ConsoleColors.RESET);
                        System.out.println(ConsoleColors.BLUE + "You return to the crossroads." + ConsoleColors.RESET);
                        System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                        System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        Crossroads crossroads = new Crossroads(hero.getHero(), name);
                        crossroads.choosePath();
                    } else {

                        if (hero.getHealthPoints() == 1) {
                            System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                            System.out.println(ConsoleColors.CYAN + "You got away safely!" + ConsoleColors.RESET);
                            System.out.println(ConsoleColors.BLUE + "You return to the crossroads." + ConsoleColors.RESET);
                            System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                            System.out.println("Press enter to continue.");
                            scanner.nextLine();
                            System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                            Crossroads crossroads = new Crossroads(hero.getHero(), name);
                            crossroads.choosePath();
                        } else {
                            System.out.println(ConsoleColors.RED + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                            System.out.println(ConsoleColors.RED + "The mummy manages to hit you as you run away! You have lost half of your remaining health points!" + ConsoleColors.RESET);

                            hero.changeHealthPoints((hero.getHealthPoints() / 2) * -1);

                            if (hero.getHealthPoints() > (hero.getMaxHP() / 3) + (hero.getMaxHP() / 3)) {

                                System.out.printf(ConsoleColors.GREEN + "You have %d health points remaining.%n" + ConsoleColors.RESET, hero.getHealthPoints());


                            } else if (hero.getHealthPoints() < (hero.getMaxHP() / 3) + 1) {

                                System.out.printf(ConsoleColors.RED + "You have %d health points remaining.%n" + ConsoleColors.RESET, hero.getHealthPoints());

                            } else {

                                System.out.printf(ConsoleColors.YELLOW + "You have %d health points remaining.%n" + ConsoleColors.RESET, hero.getHealthPoints());

                            }



                            System.out.println(ConsoleColors.BLUE + "You return to the crossroads." + ConsoleColors.RESET);
                            System.out.println(ConsoleColors.RED + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                            System.out.println("Press enter to continue.");
                            scanner.nextLine();
                            System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                            Crossroads crossroads = new Crossroads(hero.getHero(), name);
                            crossroads.choosePath();
                        }
                    }
                    break label;
                default:
                    System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                    System.out.println("That is not a valid action. Let's try this again.");
                    System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                    break;
            }
        }
    }

    public void winMummyBattle() {
        System.out.println(ConsoleColors.PURPLE + "You have defeated the cursed mummy!" + ConsoleColors.RESET);
        System.out.println("Press enter to continue.");
        scanner.nextLine();
        System.out.println(ConsoleColors.GREEN + "You find a potion and 9 gold!" + ConsoleColors.RESET);
        System.out.println("Press enter to continue.");
        scanner.nextLine();
        System.out.println(ConsoleColors.CYAN + "You feel yourself getting stronger! You have leveled up!" + ConsoleColors.RESET);
        System.out.println("Press enter to continue.");
        scanner.nextLine();
        hero.levelUp();

        System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
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

        System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);

        System.out.println(ConsoleColors.BLUE + "You find a hefty battleaxe half-buried in the sand. This could definitely do some damage to your enemies!" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
        System.out.println("Press enter to continue.");
        scanner.nextLine();
        hero.addBattleAxe();
        hero.changePotionCount(1);
        hero.changeGold(9);
        hero.changeDesertWins();
        System.out.println(ConsoleColors.BLUE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + "You have conquered all of the evil foes in the desert!" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.PURPLE + "You decide to return to the crossroads." + ConsoleColors.RESET);
        System.out.println("Press enter to continue.");
        scanner.nextLine();
        System.out.println(ConsoleColors.BLUE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
        Crossroads crossroads = new Crossroads(hero.getHero(), name);
        crossroads.choosePath();
    }
}
