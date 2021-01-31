package game;

import java.util.Scanner;

public class Inn {

    protected Hero hero;
    protected Scanner scanner;
    protected int[] heroArray;

    public Inn(int[] heroArray) {

        this.hero = new Hero(heroArray);
        this.heroArray = hero.getHero();
        this.scanner = new Scanner(System.in);
    }



    public void stayOrGo() {

        System.out.println("                           (   )");
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
        System.out.println("            ~~~~~\"   \"~~~~~~~~~~~~~~~~~~~~~~~~");

        while (true) {
            System.out.printf("Your current health points: %d.%n", hero.getHealthPoints());
            System.out.printf("Your current gold: %d.%n", hero.getGold());
            System.out.printf("Your current potion count: %d.%n", hero.getPotionCount());
            System.out.println("What do you want to do?");
            System.out.println("1: Stay for the night and recharge your health points (10 gold).");
            System.out.println("2: Visit the merchant.");
            System.out.println("3: Leave.");

            String input = scanner.nextLine();
            if (input.equals("1")) {
                checkInn();
            } else if (input.equals("2")) {
                visitMerchant();
                break;
            } else if (input.equals("3")) {
                Crossroads crossroads = new Crossroads(heroArray);
                crossroads.choosePath();
                break;
            } else {
                System.out.println("That is not a valid input. Let's try this again.");
            }
        }


    }

    public void checkInn() {

        if (hero.getHealthPoints() == hero.getMaxHP()) {
            System.out.println("You are already at maximum health!");
        } else if (hero.getGold() < 10) {
            System.out.println("You don't have enough gold to stay at The Inn!");
        } else {
            confirmInn();
        }
    }

    public void confirmInn() {

        while (true) {
            System.out.printf("Are you sure you wish to stay at the Inn? It costs 10 gold and you currently have %d gold.%n", hero.getGold());
            System.out.println("1: Stay at The Inn.");
            System.out.println("2: Cancel.");
            String input = scanner.nextLine();

            if (input.equals("1")) {
                stayAtInn();
                break;
            } else if (input.equals("2")) {
                stayOrGo();
                break;
            } else {
                System.out.println("That is not a valid action. Let's try this again.");
            }
        }

    }

    public void stayAtInn() {
        int amountToGive = hero.getMaxHP() - hero.getHealthPoints();
        hero.changeHealthPoints(amountToGive);
        System.out.println("After a night at the inn, you feel fully refreshed.");
        System.out.println("You head downstairs to the main floor of The Inn.");
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

        while (true) {
            System.out.println("The merchant has potions for sale, as well as a dagger.");
            System.out.printf("You have %d gold.%n", hero.getGold());
            System.out.printf("Your total potion count is: %d.%n", hero.getPotionCount());
            System.out.println("1. Buy a potion (4 gold).");
            System.out.println("2: Buy a dagger (5 gold).");
            System.out.println("3: Leave merchant.");

            String input = scanner.nextLine();
            if (input.equals("1")) {
                confirmPotion();
                break;
            } else if (input.equals("2")) {
                confirmDagger();
                break;
            } else if (input.equals("3")) {
                Inn inn = new Inn(hero.getHero());
                System.out.println("You leave the merchant and head back to the main part of The Inn.");
                inn.stayOrGo();
                break;
            } else {
                System.out.println("That is not a valid action. Let's try this again.");
            }
        }


    }

    public void merchantPotions() {
        while (true) {
            System.out.println("The merchant has potions for sale.");
            System.out.printf("You have %d gold.%n", hero.getGold());
            System.out.printf("Your total potion count is: %d.%n", hero.getPotionCount());
            System.out.println("1. Buy a potion (4 gold).");
            System.out.println("2: Leave merchant.");

            String input = scanner.nextLine();
            if (input.equals("1")) {
                confirmPotion();
                break;
            } else if (input.equals("2")) {
                Inn inn = new Inn(hero.getHero());
                System.out.println("You leave the merchant and head back to the main part of The Inn.");
                inn.stayOrGo();
                break;
            } else {
                System.out.println("That is not a valid action. Let's try this again.");
            }
        }
    }

    public void confirmPotion() {
        if (hero.getGold() < 4) {
            System.out.println("You don't have enough gold to buy a potion!");
        } else {
            while (true) {
                System.out.println("Are you sure you wish to buy a potion? It costs 4 gold.");
                System.out.println("1: Buy potion.");
                System.out.println("2: Cancel.");
                String input = scanner.nextLine();
                if (input.equals("1")) {
                    hero.changeGold(-4);
                    hero.changePotionCount(1);
                    System.out.println("You bought a potion!");
                    System.out.printf("Your total potion count is: %d.%n", hero.getPotionCount());
                    visitMerchant();
                    break;
                } else if (input.equals("2")) {
                    visitMerchant();
                    break;
                } else {
                    System.out.println("That is not a valid action. Let's try this again.");
                }
            }


        }


    }

    public void confirmDagger() {
        if (hero.getGold() < 5) {
            System.out.println("You don't have enough gold to buy a dagger!");
        } else {
            while (true) {
                System.out.println("Are you sure you wish to buy a dagger? It costs 5 gold.");
                System.out.println("1: Buy dagger.");
                System.out.println("2: Cancel.");
                String input = scanner.nextLine();
                if (input.equals("1")) {
                    hero.changeGold(-5);
                    hero.addDagger();
                    System.out.println("You bought a dagger!");
                    visitMerchant();
                    break;
                } else if (input.equals("2")) {
                    visitMerchant();
                    break;
                } else {
                    System.out.println("That is not a valid action. Let's try this again.");
                }
            }


        }


    }
}


/*








 */