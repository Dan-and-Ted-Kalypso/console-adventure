package game;


import java.util.Scanner;

public class RousBattle {

    private final Hero hero;
    private final Rous rous;
    private final Scanner scanner;
    private final String name;

    public RousBattle(int[] heroArray, String name) {

        this.hero = new Hero(heroArray, name);
        this.rous = new Rous();
        this.scanner = new Scanner(System.in);
        this.name = name;
    }

    public void battle() {

        System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
        System.out.println("");

        System.out.println(ConsoleColors.GREEN + "             .-\"\"\"-.");
        System.out.println("            /       \\");
        System.out.println("            \\       /");
        System.out.println("     .-\"\"\"-.-`.-.-.<  _");
        System.out.println("    /      _,-\\ ()()_/:)");
        System.out.println("    \\     / ,  `     `|");
        System.out.println("     '-..-| \\-.,___,  /");
        System.out.println("           \\ `-.__/  /");
        System.out.println("          / `-.__.-\\`");
        System.out.println("         / /|    ___\\");
        System.out.println("        ( ( |.-\"`   `'\\");
        System.out.println("         \\ \\/    {}{}  |");
        System.out.println("          \\|           /");
        System.out.println("           \\        , /");
        System.out.println("           ( __`;-;'__`)");
        System.out.println("           `//'`   `||`");
        System.out.println("          _//       ||");
        System.out.println("  .-\"-._,(__)     .(__).-\"\"-.");
        System.out.println(" /          \\    /           \\");
        System.out.println(" \\          /    \\           /");
        System.out.println("  `'-------`      `--------'`" + ConsoleColors.RESET);

        System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);

        System.out.println(ConsoleColors.GREEN + "What's that? Sprinting towards you through the trees? It's a Rodent of Unusual Size! I thought they didn't exist!" + ConsoleColors.RESET);
        System.out.println("Press enter to continue.");
        System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
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
                        System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        System.out.println(ConsoleColors.RED + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        System.out.println(ConsoleColors.RED + "Your attack missed!" + ConsoleColors.RESET);
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                        System.out.println(ConsoleColors.RED + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                    } else {
                        rous.changeEnemyHP(attackValue * -1);
                        System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        System.out.printf(ConsoleColors.GREEN + "You hit the R.O.U.S. for %d points!%n" + ConsoleColors.RESET, attackValue);
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                        System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                    }
                    if (rous.getEnemyHP() <= 0) {
                        System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        System.out.println(ConsoleColors.GREEN + "The R.O.U.S. has 0 health points remaining!" + ConsoleColors.RESET);
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                        System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        winRousBattle();
                        break label;
                    } else {
                        System.out.println(ConsoleColors.YELLOW + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        System.out.printf(ConsoleColors.YELLOW + "The R.O.U.S. has %d health points remaining.%n" + ConsoleColors.RESET, rous.getEnemyHP());
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                        System.out.println(ConsoleColors.YELLOW + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        int enemyAttackValue = rous.generateAttackValue();
                        if (enemyAttackValue == 0) {
                            System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                            System.out.println(ConsoleColors.GREEN + "The R.O.U.S.' attack missed!" + ConsoleColors.RESET);
                            System.out.println("Press enter to continue.");
                            scanner.nextLine();
                            System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        } else {
                            hero.changeHealthPoints(enemyAttackValue * -1);
                            System.out.println(ConsoleColors.RED + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                            System.out.printf(ConsoleColors.RED + "The R.O.U.S. hits you for %d points!%n" + ConsoleColors.RESET, enemyAttackValue);
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

                    System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                    int checker = hero.checkPotion();
                    if (checker == 0) {
                        hero.usePotion();
                        break;
                    } else if (checker == 1) {
                        hero.usePotion();
                        break;
                    } else {
                        hero.usePotion();
                    }
                    int enemyAttackValue = rous.generateAttackValue();
                    if (enemyAttackValue == 0) {
                        System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        System.out.println(ConsoleColors.GREEN + "The R.O.U.S.' attack missed!" + ConsoleColors.RESET);
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                        System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                    } else {
                        hero.changeHealthPoints(enemyAttackValue * -1);
                        System.out.println(ConsoleColors.RED + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        System.out.printf(ConsoleColors.RED + "The R.O.U.S. hits you for %d points!%n" + ConsoleColors.RESET, enemyAttackValue);
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
                            System.out.println(ConsoleColors.RED + "The R.O.U.S. manages to hit you as you run away! You have lost half of your remaining health points!" + ConsoleColors.RESET);

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

    public void winRousBattle() {
        System.out.println(ConsoleColors.PURPLE + "You have defeated the Rodent of Unusual Size!" + ConsoleColors.RESET);
        System.out.println("Press enter to continue.");
        scanner.nextLine();
        System.out.println(ConsoleColors.GREEN + "You find a potion and 7 gold!" + ConsoleColors.RESET);
        System.out.println("Press enter to continue.");
        scanner.nextLine();
        System.out.println(ConsoleColors.CYAN + "You feel yourself getting stronger! You have leveled up!" + ConsoleColors.RESET);
        System.out.println("Press enter to continue.");
        scanner.nextLine();
        hero.levelUp();

        System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
        System.out.println("");

        System.out.println("   _,---,_");
        System.out.println(" /'_______`\\");
        System.out.println("(/'       `\\|___________----------\"\"\"\"\"\"\"------,");
        System.out.println(" \\#########||______                          /'");
        System.out.println("  ^^^^^^^^^||      \"\"\"\"\"\"-----_____        /'");
        System.out.println("            \\                      \"\"\"--_/'");

        System.out.println("");

        System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);

        System.out.println(ConsoleColors.BLUE + "You find a wicked sharp scimitar in the underbrush. This will undoubtedly make your monster-slaying efforts go much more smoothly!" + ConsoleColors.RESET);
        System.out.println("Press enter to continue.");
        scanner.nextLine();
        hero.addScimitar();
        hero.changePotionCount(1);
        hero.changeGold(7);
        hero.changeForestWins();
        System.out.println(ConsoleColors.BLUE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + "You have conquered all of the evil foes in the forest!" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.PURPLE + "You decide to return to the crossroads." + ConsoleColors.RESET);
        System.out.println("Press enter to continue.");
        scanner.nextLine();
        System.out.println(ConsoleColors.BLUE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
        Crossroads crossroads = new Crossroads(hero.getHero(), name);
        crossroads.choosePath();
    }
}
