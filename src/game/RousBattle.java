package game;


import java.util.Scanner;

public class RousBattle {

    private final Hero hero;
    private final Rous rous;
    private final Scanner scanner;

    public RousBattle(int[] heroArray) {

        this.hero = new Hero(heroArray);
        this.rous = new Rous();
        this.scanner = new Scanner(System.in);
    }

    public void battle() {

        System.out.println("");

        System.out.println("             .-\"\"\"-.");
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
        System.out.println("  `'-------`      `--------'`");

        System.out.println("");

        System.out.println("What's that? Sprinting towards you through the trees? It's a Rodent of Unusual Size! I thought they didn't exist!");
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
                        rous.changeEnemyHP(attackValue * -1);
                        System.out.printf("You hit the R.O.U.S. for %d points!%n", attackValue);
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                    }
                    if (rous.getEnemyHP() <= 0) {
                        System.out.println("The R.O.U.S. has 0 health points remaining!");
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                        winRousBattle();
                        break label;
                    } else {
                        System.out.printf("The R.O.U.S. has %d health points remaining.%n", rous.getEnemyHP());
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                        int enemyAttackValue = rous.generateAttackValue();
                        if (enemyAttackValue == 0) {
                            System.out.println("The R.O.U.S.' attack missed!");
                            System.out.println("Press enter to continue.");
                            scanner.nextLine();
                        } else {
                            hero.changeHealthPoints(enemyAttackValue * -1);
                            System.out.printf("The R.O.U.S. hits you for %d points!%n", enemyAttackValue);
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

                    break;
                case "3":
                    int runSuccess = hero.attemptRun();
                    if (runSuccess == 1) {
                        System.out.println("You got away safely!");
                        System.out.println("You return to the crossroads.");
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                        Crossroads crossroads = new Crossroads(hero.getHero());
                        crossroads.choosePath();
                    } else {

                        if (hero.getHealthPoints() == 1) {
                            System.out.println("You got away safely!");
                            System.out.println("You return to the crossroads.");
                            System.out.println("Press enter to continue.");
                            scanner.nextLine();
                            Crossroads crossroads = new Crossroads(hero.getHero());
                            crossroads.choosePath();
                        } else {
                            System.out.println("The R.O.U.S. manages to hit you as you run away! You have lost half of your remaining health points!");
                            hero.changeHealthPoints((hero.getHealthPoints() / 2) * -1);
                            System.out.printf("You now have %d health points remaining.%n", hero.getHealthPoints());
                            System.out.println("You return to the crossroads.");
                            System.out.println("Press enter to continue.");
                            scanner.nextLine();
                            Crossroads crossroads = new Crossroads(hero.getHero());
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

    public void winRousBattle() {
        System.out.println("You have defeated the Rodent of Unusual Size!");
        System.out.println("Press enter to continue.");
        scanner.nextLine();
        System.out.println("You find a potion and 7 gold!");
        System.out.println("Press enter to continue.");
        scanner.nextLine();
        System.out.println("You feel yourself getting stronger! You have leveled up!");
        System.out.println("Press enter to continue.");
        scanner.nextLine();
        hero.levelUp();

        System.out.println("");

        System.out.println("   _,---,_");
        System.out.println(" /'_______`\\");
        System.out.println("(/'       `\\|___________----------\"\"\"\"\"\"\"------,");
        System.out.println(" \\#########||______                          /'");
        System.out.println("  ^^^^^^^^^||      \"\"\"\"\"\"-----_____        /'");
        System.out.println("            \\                      \"\"\"--_/'");

        System.out.println("");

        System.out.println("You find a wicked sharp scimitar in the underbrush. This will undoubtedly make your monster-slaying efforts go much more smoothly!");
        System.out.println("Press enter to continue.");
        scanner.nextLine();
        hero.addScimitar();
        hero.changePotionCount(1);
        hero.changeGold(7);
        hero.changeForestWins();
        System.out.println("You have conquered all of the evil foes in the forest!");
        System.out.println("You decide to return to the crossroads.");
        System.out.println("Press enter to continue.");
        scanner.nextLine();
        Crossroads crossroads = new Crossroads(hero.getHero());
        crossroads.choosePath();
    }
}
