package game;


import java.util.Scanner;

public class OrcBattle {

    private int[] heroArray;
    private final Hero hero;
    private final Orc orc;
    private final Scanner scanner;
    private final String name;

    public OrcBattle(int[] heroArray, String name) {
        this.heroArray = heroArray;
        this.hero = new Hero(heroArray, name);
        this.orc = new Orc();
        this.scanner = new Scanner(System.in);
        this.name = name;
    }

    public void battle() {



        System.out.println("");

        System.out.println("                   (    )");
        System.out.println("                  ((((()))");
        System.out.println("                  |o\\ /o)|");
        System.out.println("                  ( (  _')");
        System.out.println("                   (._.  /\\__");
        System.out.println("                  ,\\___,/ '  ')");
        System.out.println("    '.,_,,       (  .- .   .    )");
        System.out.println("     \\   \\\\     ( '        )(    )");
        System.out.println("      \\   \\\\    \\.  _.__ ____( .  |");
        System.out.println("       \\  /\\\\   .(   .'  /\\  '.  )");
        System.out.println("        \\(  \\\\.-' ( /    \\/    \\)");
        System.out.println("         '  ()) _'.-|/\\/\\/\\/\\/\\|");
        System.out.println("             '\\ .( |\\/\\/\\/\\/\\/|");
        System.out.println("               '((  \\    /\\    /");
        System.out.println("               ((((  '.__\\/__.')");
        System.out.println("                ((,) /   ((()   )");
        System.out.println("                 \"..-,  (()(\"   /");
        System.out.println("                  _//.   ((() .\"");
        System.out.println("          _____ //,/\" ___ ((( ', ___");
        System.out.println("                           ((  )");
        System.out.println("                            / /");
        System.out.println("                          _/,/'");
        System.out.println("                        /,/,\"");

        System.out.println("");


        System.out.println("It's an orc! He looks nasty!");
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
                        orc.changeEnemyHP(attackValue * -1);
                        System.out.printf("You hit the orc for %d points!%n", attackValue);
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                    }
                    if (orc.getEnemyHP() <= 0) {
                        System.out.println("The orc has 0 health points remaining!");
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                        winOrcBattle();
                        break label;
                    } else {
                        System.out.printf("The orc has %d health points remaining.%n", orc.getEnemyHP());
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                        int enemyAttackValue = orc.generateAttackValue();
                        if (enemyAttackValue == 0) {
                            System.out.println("The orc's attack missed!");
                            System.out.println("Press enter to continue.");
                            scanner.nextLine();
                        } else {
                            hero.changeHealthPoints(enemyAttackValue * -1);
                            System.out.printf("The orc hits you for %d points!%n", enemyAttackValue);
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
                    int enemyAttackValue = orc.generateAttackValue();
                    if (enemyAttackValue == 0) {
                        System.out.println("The orc's attack missed!");
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                    } else {
                        hero.changeHealthPoints(enemyAttackValue * -1);
                        System.out.printf("The orc hits you for %d points!%n", enemyAttackValue);
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
                            System.out.println("The orc manages to hit you as you run away! You have lost half of your remaining health points!");
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

    public void winOrcBattle() {
        System.out.println("You have defeated the orc!");
        System.out.println("Press enter to continue.");
        scanner.nextLine();
        System.out.println("You find a potion and 10 gold!");
        System.out.println("Press enter to continue.");
        scanner.nextLine();
        hero.changePotionCount(1);
        hero.changeGold(10);
        hero.changeMountainWins();
        while (true) {
            System.out.println("Would you like to stay in the mountains?");
            this.heroArray = hero.getHero();
            System.out.printf("Current health points: %d.%n", heroArray[1]);
            System.out.printf("Current potion count: %d.%n", heroArray[0]);
            System.out.println("1: Stay in the mountains.");
            System.out.println("2: Go back to the crossroads.");
            String action = scanner.nextLine();
            if (action.equals("1")) {
                Mountain mountain = new Mountain();
                mountain.stayOrGo(hero.getHero(), name);
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
