package game;

import java.util.Scanner;

public class Inn {

    private final Hero hero;
    private final Scanner scanner;
    private final String name;


    public Inn(int[] heroArray, String name) {

        this.hero = new Hero(heroArray, name);
        this.scanner = new Scanner(System.in);
        this.name = name;
    }



    public void stayOrGo() {

        System.out.println("");
        System.out.println(ConsoleColors.CYAN + "                           (   )");
        System.out.println("                          (    )");
        System.out.println("                           (    )");
        System.out.println("                          (    )");
        System.out.println("                            )  )");
        System.out.println("                           (  (                  /\\");
        System.out.println("                            (_)                 /  \\  /\\");
        System.out.println("                    ________[_]________      /\\/    \\/  \\");
        System.out.println("           /\\      /\\        ______    \\    /   /\\/\\  /\\/\\");
        System.out.println("          /  \\    //_\\       \\    /\\    \\  /\\/\\/    \\/    \\");
        System.out.println("   /\\    / /\\/\\  //___\\       \\__/  \\    \\/");
        System.out.println("  /  \\  /\\/    \\//_____\\       \\ |[]|     \\");
        System.out.println(" /\\/\\/\\/       //_______\\       \\|__|      \\");
        System.out.println("/      \\      /XXXXXXXXXX\\                  \\");
        System.out.println("        \\    /_I_II  I__I_\\__________________\\");
        System.out.println("               I_I|  I__I_____[]_|_[]_____I");
        System.out.println("               I_II  I__I_____[]_|_[]_____I");
        System.out.println("               I II__I  I     XXXXXXX     I");
        System.out.println("            ~~~~~\"   \"~~~~~~~~~~~~~~~~~~~~~~~~" + ConsoleColors.RESET);

        System.out.println(ConsoleColors.CYAN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);

        label:
        while (true) {
            if (hero.getHealthPoints() > (hero.getMaxHP() / 3) + (hero.getMaxHP() / 3)) {
                System.out.printf(ConsoleColors.GREEN + "Your health points: %d.%n" + ConsoleColors.RESET, hero.getHealthPoints());
            } else if (hero.getHealthPoints() < (hero.getMaxHP() / 3) + 1) {
                System.out.printf(ConsoleColors.RED + "Your health points: %d.%n" + ConsoleColors.RESET, hero.getHealthPoints());
            } else {
                System.out.printf(ConsoleColors.YELLOW + "Your health points: %d.%n" + ConsoleColors.RESET, hero.getHealthPoints());
            }
            System.out.printf(ConsoleColors.YELLOW + "Your current gold: %d.%n" + ConsoleColors.RESET, hero.getGold());
            if (hero.getPotionCount() == 0) {
                System.out.printf(ConsoleColors.RED + "Your potion count: %d.%n" + ConsoleColors.RESET, hero.getPotionCount());
            } else if (hero.getPotionCount() < 3) {
                System.out.printf(ConsoleColors.YELLOW + "Your potion count: %d.%n" + ConsoleColors.RESET, hero.getPotionCount());
            } else {
                System.out.printf(ConsoleColors.GREEN + "Your potion count: %d.%n" + ConsoleColors.RESET, hero.getPotionCount());
            }
            System.out.println("Press enter to continue.");
            scanner.nextLine();
            System.out.println(ConsoleColors.CYAN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN + "What do you want to do?" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.GREEN + "1: Stay for the night and recharge your health points (10 gold)." + ConsoleColors.RESET);
            System.out.println(ConsoleColors.PURPLE + "2: Visit the merchant." + ConsoleColors.RESET);
            System.out.println(ConsoleColors.YELLOW + "3: Leave." + ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    checkInn();
                    break label;
                case "2":
                    visitMerchant();
                    break label;
                case "3":
                    System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                    Crossroads crossroads = new Crossroads(hero.getHero(), name);
                    crossroads.choosePath();
                    break label;
                default:
                    System.out.println(ConsoleColors.CYAN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                    System.out.println("That is not a valid action. Let's try this again.");
                    System.out.println(ConsoleColors.CYAN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                    break;
            }
        }


    }

    public void checkInn() {

        if (hero.getHealthPoints() == hero.getMaxHP()) {
            System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.GREEN + "You are already at maximum health!" + ConsoleColors.RESET);
            System.out.println("Press enter to continue.");
            scanner.nextLine();
            System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
            stayOrGo();
        } else if (hero.getGold() < 10) {
            System.out.println(ConsoleColors.YELLOW + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.YELLOW + "You don't have enough gold to stay at The Inn!" + ConsoleColors.RESET);
            System.out.println("Press enter to continue.");
            scanner.nextLine();
            System.out.println(ConsoleColors.YELLOW + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
            stayOrGo();
        } else {
            confirmInn();
        }
    }

    public void confirmInn() {

        while (true) {
            System.out.println(ConsoleColors.CYAN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
            System.out.printf(ConsoleColors.CYAN + "Are you sure you wish to stay at the Inn? It costs 10 gold and you currently have %d gold.%n" + ConsoleColors.RESET, hero.getGold());
            System.out.println(ConsoleColors.GREEN + "1: Stay at The Inn." + ConsoleColors.RESET);
            System.out.println(ConsoleColors.YELLOW + "2: Cancel." + ConsoleColors.RESET);
            String input = scanner.nextLine();

            if (input.equals("1")) {
                System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                stayAtInn();
                break;
            } else if (input.equals("2")) {
                System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                stayOrGo();
                break;
            } else {
                System.out.println(ConsoleColors.CYAN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                System.out.println("That is not a valid action. Let's try this again.");
                System.out.println(ConsoleColors.CYAN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
            }
        }

    }

    public void stayAtInn() {
        int amountToGive = hero.getMaxHP() - hero.getHealthPoints();
        hero.changeHealthPoints(amountToGive);
        hero.changeGold(-10);
        System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + "After a night at the inn, you feel fully refreshed." + ConsoleColors.RESET);
        System.out.println(ConsoleColors.CYAN + "You head downstairs to the main floor of The Inn." + ConsoleColors.RESET);
        System.out.println("Press enter to continue.");
        scanner.nextLine();
        System.out.println(ConsoleColors.CYAN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
        stayOrGo();
    }

    public void visitMerchant() {

        if (hero.getLevel() == 1 && hero.getDagger() == 0) {
            merchantDagger();
        } else {
            merchantPotions();
        }
    }

    public void merchantDagger() {

        label:
        while (true) {
            System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.PURPLE + "The merchant has potions for sale, as well as a dagger." + ConsoleColors.RESET);
            System.out.printf(ConsoleColors.YELLOW + "You have %d gold.%n" + ConsoleColors.RESET, hero.getGold());

            if (hero.getPotionCount() == 0) {
                System.out.printf(ConsoleColors.RED + "Your potion count: %d.%n" + ConsoleColors.RESET, hero.getPotionCount());
            } else if (hero.getPotionCount() < 3) {
                System.out.printf(ConsoleColors.YELLOW + "Your potion count: %d.%n" + ConsoleColors.RESET, hero.getPotionCount());
            } else {
                System.out.printf(ConsoleColors.GREEN + "Your potion count: %d.%n" + ConsoleColors.RESET, hero.getPotionCount());
            }
            System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.GREEN + "1. Buy a potion (4 gold)." + ConsoleColors.RESET);
            System.out.println(ConsoleColors.PURPLE + "2: Buy a dagger (5 gold)." + ConsoleColors.RESET);
            System.out.println(ConsoleColors.YELLOW + "3: Leave merchant." + ConsoleColors.RESET);

            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    confirmPotion();
                    break label;
                case "2":
                    confirmDagger();
                    break label;
                case "3":
                    Inn inn = new Inn(hero.getHero(), name);
                    System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                    System.out.println(ConsoleColors.PURPLE + "You leave the merchant and head back to the main part of The Inn." + ConsoleColors.RESET);
                    System.out.println("Press enter to continue.");
                    scanner.nextLine();
                    System.out.println(ConsoleColors.CYAN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                    inn.stayOrGo();
                    break label;
                default:
                    System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                    System.out.println("That is not a valid action. Let's try this again.");
                    System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                    break;
            }
        }


    }

    public void merchantPotions() {
        while (true) {
            System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.PURPLE + "The merchant has potions for sale." + ConsoleColors.RESET);
            System.out.printf(ConsoleColors.YELLOW + "You have %d gold.%n" + ConsoleColors.RESET, hero.getGold());

            if (hero.getPotionCount() == 0) {
                System.out.printf(ConsoleColors.RED + "Your potion count: %d.%n" + ConsoleColors.RESET, hero.getPotionCount());
            } else if (hero.getPotionCount() < 3) {
                System.out.printf(ConsoleColors.YELLOW + "Your potion count: %d.%n" + ConsoleColors.RESET, hero.getPotionCount());
            } else {
                System.out.printf(ConsoleColors.GREEN + "Your potion count: %d.%n" + ConsoleColors.RESET, hero.getPotionCount());
            }
            System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.GREEN + "1. Buy a potion (4 gold)." + ConsoleColors.RESET);
            System.out.println(ConsoleColors.YELLOW + "2: Leave merchant." + ConsoleColors.RESET);

            String input = scanner.nextLine();
            if (input.equals("1")) {
                confirmPotion();
                break;
            } else if (input.equals("2")) {

                Inn inn = new Inn(hero.getHero(), name);
                System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.PURPLE + "You leave the merchant and head back to the main part of The Inn." + ConsoleColors.RESET);
                System.out.println("Press enter to continue.");
                scanner.nextLine();
                System.out.println(ConsoleColors.CYAN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                inn.stayOrGo();
                break;

            } else {
                System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                System.out.println("That is not a valid action. Let's try this again.");
                System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
            }
        }
    }

    public void confirmPotion() {
        if (hero.getGold() < 4) {
            System.out.println(ConsoleColors.RED + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED + "You don't have enough gold to buy a potion!" + ConsoleColors.RESET);
            System.out.println("Press enter to continue.");
            scanner.nextLine();
            System.out.println(ConsoleColors.RED + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
            visitMerchant();
        } else {
            while (true) {
                System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.PURPLE + "Are you sure you wish to buy a potion? It costs 4 gold." + ConsoleColors.RESET);
                System.out.println(ConsoleColors.CYAN + "1: Buy potion." + ConsoleColors.RESET);
                System.out.println(ConsoleColors.YELLOW + "2: Cancel." + ConsoleColors.RESET);
                String input = scanner.nextLine();
                if (input.equals("1")) {
                    hero.changeGold(-4);
                    hero.changePotionCount(1);
                    System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                    System.out.println(ConsoleColors.CYAN + "You bought a potion!" + ConsoleColors.RESET);
                    if (hero.getPotionCount() == 0) {
                        System.out.printf(ConsoleColors.RED + "Your potion count: %d.%n" + ConsoleColors.RESET, hero.getPotionCount());
                    } else if (hero.getPotionCount() < 3) {
                        System.out.printf(ConsoleColors.YELLOW + "Your potion count: %d.%n" + ConsoleColors.RESET, hero.getPotionCount());
                    } else {
                        System.out.printf(ConsoleColors.GREEN + "Your potion count: %d.%n" + ConsoleColors.RESET, hero.getPotionCount());
                    }
                    System.out.println("Press enter to continue.");
                    scanner.nextLine();
                    visitMerchant();
                    break;
                } else if (input.equals("2")) {
                    visitMerchant();
                    break;
                } else {
                    System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                    System.out.println("That is not a valid action. Let's try this again.");
                    System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                }
            }


        }


    }

    public void confirmDagger() {
        if (hero.getGold() < 5) {
            System.out.println(ConsoleColors.RED + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED + "You don't have enough gold to buy a dagger!" + ConsoleColors.RESET);
            System.out.println("Press enter to continue.");
            scanner.nextLine();
            System.out.println(ConsoleColors.RED + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
            visitMerchant();
        } else {
            while (true) {
                System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.PURPLE + "Are you sure you wish to buy a dagger? It costs 5 gold." + ConsoleColors.RESET);
                System.out.println(ConsoleColors.CYAN + "1: Buy dagger." + ConsoleColors.RESET);
                System.out.println(ConsoleColors.YELLOW + "2: Cancel." + ConsoleColors.RESET);
                String input = scanner.nextLine();
                if (input.equals("1")) {
                    hero.changeGold(-5);
                    hero.addDagger();
                    System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                    System.out.println("       .---.");
                    System.out.println("       |---|");
                    System.out.println("       |---|");
                    System.out.println("       |---|");
                    System.out.println("   .---^ - ^---.");
                    System.out.println("   :___________:");
                    System.out.println("      |  |//|");
                    System.out.println("      |  |//|");
                    System.out.println("      |  |//|");
                    System.out.println("      |  |//|");
                    System.out.println("      |  |//|");
                    System.out.println("      |  |//|");
                    System.out.println("      |  |.-|");
                    System.out.println("      |.-'**|");
                    System.out.println("       \\***/");
                    System.out.println("        \\*/");
                    System.out.println("         V");

                    System.out.println(ConsoleColors.CYAN + "You bought a dagger!" + ConsoleColors.RESET);
                    System.out.println("Press enter to continue.");
                    scanner.nextLine();
                    visitMerchant();
                    break;
                } else if (input.equals("2")) {
                    visitMerchant();
                    break;
                } else {
                    System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                    System.out.println("That is not a valid action. Let's try this again.");
                    System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                }
            }


        }
    }
}
