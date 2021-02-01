package game;


import java.util.Scanner;

public class UrukBattle {

    private final Hero hero;
    private final Uruk uruk;
    private final Scanner scanner;
    private final String name;

    public UrukBattle(int[] heroArray, String name) {

        this.hero = new Hero(heroArray, name);
        this.uruk = new Uruk();
        this.scanner = new Scanner(System.in);
        this.name = name;
    }

    public void battle() {

        System.out.println("");

        System.out.println("                 /\\");
        System.out.println("                 ||");
        System.out.println("                 ||");
        System.out.println("                 ||");
        System.out.println("                 ||");
        System.out.println("               __||__");
        System.out.println("                 \\/");
        System.out.println("                 P3");
        System.out.println("                 ||");
        System.out.println(" @@@@      _T_  /\\;");
        System.out.println("@||||@ .-.[:|:]^\\/");
        System.out.println(" \\||/ /\\|  \"'\" \\/");
        System.out.println("  E]_|\\/ \\--|--/");
        System.out.println("  \"  `'  '=[:]='");
        System.out.println("         /\"\"\"\"\"\\");
        System.out.println("        /\"\"\"\"\"\"\"\\");
        System.out.println("       []\"/\"\"\"\\\"[]");
        System.out.println("       | \\     / |");
        System.out.println("       | |     | | ");
        System.out.println("     <\\\\\\)     (///>");

        System.out.println("");

        System.out.println("It's an Uruk-Hai! He looks like he's hungry, and meat's back on the menu!");
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
                        uruk.changeEnemyHP(attackValue * -1);
                        System.out.printf("You hit the Uruk-Hai for %d points!%n", attackValue);
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                    }
                    if (uruk.getEnemyHP() <= 0) {
                        System.out.println("The Uruk-Hai has 0 health points remaining!");
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                        winUrukBattle();
                        break label;
                    } else {
                        System.out.printf("The Uruk-Hai has %d health points remaining.%n", uruk.getEnemyHP());
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                        int enemyAttackValue = uruk.generateAttackValue();
                        if (enemyAttackValue == 0) {
                            System.out.println("The Uruk-Hai's attack missed!");
                            System.out.println("Press enter to continue.");
                            scanner.nextLine();
                        } else {
                            hero.changeHealthPoints(enemyAttackValue * -1);
                            System.out.printf("The Uruk-Hai hits you for %d points!%n", enemyAttackValue);
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
                    int enemyAttackValue = uruk.generateAttackValue();
                    if (enemyAttackValue == 0) {
                        System.out.println("The Uruk-Hai's attack missed!");
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                    } else {
                        hero.changeHealthPoints(enemyAttackValue * -1);
                        System.out.printf("The Uruk-Hai hits you for %d points!%n", enemyAttackValue);
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
                            System.out.println("The Uruk-Hai manages to hit you as you run away! You have lost half of your remaining health points!");
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

    public void winUrukBattle() {
        System.out.println("You have defeated the Uruk-Hai!");
        System.out.println("Press enter to continue.");
        scanner.nextLine();
        System.out.println("You find a potion and 10 gold!");
        System.out.println("Press enter to continue.");
        scanner.nextLine();
        System.out.println("You feel yourself getting stronger! You have leveled up!");
        System.out.println("Press enter to continue.");
        scanner.nextLine();
        hero.levelUp();

        System.out.println("");

        System.out.println("        )");
        System.out.println("          (");
        System.out.println("        '    }");
        System.out.println("      (    '");
        System.out.println("     '      (");
        System.out.println("      )  |    )");
        System.out.println("    '   /|\\    `");
        System.out.println("   )   / | \\  ` )");
        System.out.println("  {    | | |  {");
        System.out.println(" }     | | |  .");
        System.out.println("  '    | | |    )");
        System.out.println(" (    /| | |\\    .");
        System.out.println("  .  / | | | \\  (");
        System.out.println("}    \\ \\ | / /  .");
        System.out.println(" (    \\ `-' /    }");
        System.out.println(" '    / ,-. \\    '");
        System.out.println("  }  / / | \\ \\  }");
        System.out.println(" '   \\ | | | /   }");
        System.out.println("  (   \\| | |/  (");
        System.out.println("    )  | | |  )");
        System.out.println("    .  | | |  '");
        System.out.println("       J | L");
        System.out.println(" /|    J_|_L    |\\");
                System.out.println(" \\ \\___/ o \\___/ /");
        System.out.println("  \\_____ _ _____/");
        System.out.println("        |-|");
        System.out.println("        |-|");
        System.out.println("        |-|");
        System.out.println("       ,'-'.");
        System.out.println("       '---'");

        System.out.println("");

        System.out.println("You search the Uruk-Hai's cave and find a huge, glittering sword! It looks powerful.");
        System.out.println("Press enter to continue.");
        scanner.nextLine();
        hero.addExcalibur();
        hero.changePotionCount(1);
        hero.changeGold(10);
        hero.changeMountainWins();

        System.out.println("You have conquered all of the evil foes in the mountains!");
        System.out.println("You decide to return to the crossroads.");
        System.out.println("Press enter to continue.");
        scanner.nextLine();
        Crossroads crossroads = new Crossroads(hero.getHero(), name);
        crossroads.choosePath();
    }
}
