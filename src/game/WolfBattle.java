package game;


import java.util.Scanner;

public class WolfBattle {

    private int[] heroArray;
    private final Hero hero;
    private final Wolf wolf;
    private final Scanner scanner;
    private final String name;

    public WolfBattle(int[] heroArray, String name) {
        this.heroArray = heroArray;
        this.hero = new Hero(heroArray, name);
        this.wolf = new Wolf();
        this.scanner = new Scanner(System.in);
        this.name = name;
    }

    public void battle() {

        System.out.println("");

        System.out.println("                              __");
        System.out.println("                            .d$$b");
        System.out.println("                          .' TO$;\\");
        System.out.println("                         /  : TP._;");
        System.out.println("                        / _.;  :Tb|");
        System.out.println("                       /   /   ;j$j");
        System.out.println("                   _.-\"       d$$$$");
        System.out.println("                 .' ..       d$$$$;");
        System.out.println("                /  /P'      d$$$$P. |\\");
        System.out.println("               /   \"      .d$$$P' |\\^\"l");
        System.out.println("             .'           `T$P^\"\"\"\"\"  :");
        System.out.println("         ._.'      _.'                ;");
        System.out.println("      `-.-\".-'-' ._.       _.-\"    .-\"");
        System.out.println("    `.-\" _____  ._              .-\"");
        System.out.println("   -(.g$$$$$$$b.              .'");
        System.out.println("     \"\"^^T$$$P^)            .(:");
        System.out.println("       _/  -\"  /.'         /:/;");
        System.out.println("    ._.'-'`-'  \")/         /;/;");
        System.out.println(" `-.-\"..--\"\"   \" /         /  ;");
        System.out.println(".-\" ..--\"\"        -'          :");
        System.out.println("..--\"\"--.-\"         (\\      .-(\\");
        System.out.println("  ..--\"\"              `-\\(\\/;`");
        System.out.println("    _.                      :");
        System.out.println("                            ;`-");
        System.out.println("                           :\\");

        System.out.println("");

        System.out.println("You hear a low howl and a snarl. A large, vicious wolf is bearing down on you!");
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
                        wolf.changeEnemyHP(attackValue * -1);
                        System.out.printf("You hit the wolf for %d points!%n", attackValue);
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                    }
                    if (wolf.getEnemyHP() <= 0) {
                        System.out.println("The wolf has 0 health points remaining!");
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                        winWolfBattle();
                        break label;
                    } else {
                        System.out.printf("The wolf has %d health points remaining.%n", wolf.getEnemyHP());
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                        int enemyAttackValue = wolf.generateAttackValue();
                        if (enemyAttackValue == 0) {
                            System.out.println("The wolf's attack missed!");
                            System.out.println("Press enter to continue.");
                            scanner.nextLine();
                        } else {
                            hero.changeHealthPoints(enemyAttackValue * -1);
                            System.out.printf("The wolf hits you for %d points!%n", enemyAttackValue);
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
                    int enemyAttackValue = wolf.generateAttackValue();
                    if (enemyAttackValue == 0) {
                        System.out.println("The wolf's attack missed!");
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                    } else {
                        hero.changeHealthPoints(enemyAttackValue * -1);
                        System.out.printf("The wolf hits you for %d points!%n", enemyAttackValue);
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
                            System.out.println("The wolf manages to hit you as you run away! You have lost half of your remaining health points!");
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

    public void winWolfBattle() {
        System.out.println("You have defeated the wolf!");
        System.out.println("Press enter to continue.");
        scanner.nextLine();
        System.out.println("You find a potion and 6 gold!");
        System.out.println("Press enter to continue.");
        scanner.nextLine();
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
                forest.stayOrGo(hero.getHero(), name);
                break;
            } else if (action.equals("2")) {
                Crossroads crossroads = new Crossroads(hero.getHero(), name);
                crossroads.choosePath();
                break;
            } else {
                System.out.println("That is not a valid action. Let's try this again.");
                System.out.println("");
            }
        }
    }
}
