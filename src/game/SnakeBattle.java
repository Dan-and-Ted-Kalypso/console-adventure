package game;


import java.util.Scanner;

public class SnakeBattle {

    private int[] heroArray;
    private final Hero hero;
    private final Snake snake;
    private final Scanner scanner;
    private final String name;

    public SnakeBattle(int[] heroArray, String name) {
        this.heroArray = heroArray;
        this.hero = new Hero(heroArray, name);
        this.snake = new Snake();
        this.scanner = new Scanner(System.in);
        this.name = name;
    }

    public void battle() {

        System.out.println(ConsoleColors.YELLOW + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
        System.out.println("");

        System.out.println("                /||\\");
        System.out.println("                ||||");
        System.out.println("                ||||                      _____.-..-.");
        System.out.println("                |||| /|\\               .-~@@/ / q  p \\");
        System.out.println("           /|\\  |||| |||             .'@ _@/..\\-.__.-/");
        System.out.println("           |||  |||| |||            /@.-~/|~~~`\\|__|/");
        System.out.println("           |||  |||| |||            |'--<||     '~~'");
        System.out.println("           |||  |||| d||            |>--<\\@\\");
        System.out.println("           |||  |||||||/            \\>---<\\@`\\.");
        System.out.println("           ||b._||||~~'              `\\>---<`\\@`\\.");
        System.out.println("           \\||||||||                   `\\>----<`\\@`\\.");
        System.out.println("            `~~~||||               _     `\\>-----<`\\@`\\.");
        System.out.println("                ||||              (_)      `\\>-----<`\\.@`\\.");
        System.out.println("                ||||              (_)        `\\>------<`\\.@`\\.");
        System.out.println("~~~~~~~~~~~~~~~~||||~~~~~~~~~~~~~~(__)~~~~~~~~~`\\>-------<`\\.@`\\~~~~~~~~~~~~~");
        System.out.println("  \\/..__..--  . |||| \\/  .  ..____( _)@@@--..____\\..--\\@@@/~`\\@@>-._   \\/ .");
        System.out.println("\\/         \\/ \\/    \\/     / - -\\@@@@--@/- - \\@@@/ - - \\@/- -@@@@/- \\.   --._");
        System.out.println("   .   \\/    _..\\/-...--.. |- - -\\@@/ - -\\@@@@/~~~~\\@@@@/- - \\@@/- - |   .\\/");
        System.out.println("        .  \\/              | - - -@@ - - -\\@@/- - - \\@@/- - - @@- - -|      .");
        System.out.println(". \\/             .   \\/     ~-.__ - - - - -@@- - - - @@- - - - -__.-~  . \\/");
        System.out.println("   __...--..__..__       .  \\/   ~~~--..____- - - - -____..--~~~    \\/_..--..");
        System.out.println("\\/  .   .    \\/     \\/    __..--... \\/      ~~~~~~~~~     \\/ . \\/  .");

        System.out.println(ConsoleColors.YELLOW + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);

        System.out.println(ConsoleColors.YELLOW + "A giant snake explodes from out of the sand! Those fangs are massive!" + ConsoleColors.RESET);
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
                        System.out.println(ConsoleColors.BLUE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        System.out.println(ConsoleColors.RED + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        System.out.println(ConsoleColors.RED + "Your attack missed!" + ConsoleColors.RESET);
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                        System.out.println(ConsoleColors.RED + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                    } else {
                        snake.changeEnemyHP(attackValue * -1);
                        System.out.println(ConsoleColors.BLUE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        System.out.printf(ConsoleColors.GREEN + "You hit the snake for %d points!%n" + ConsoleColors.RESET, attackValue);
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                        System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                    }
                    if (snake.getEnemyHP() <= 0) {
                        System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        System.out.println(ConsoleColors.GREEN + "The snake has 0 health points remaining!" + ConsoleColors.RESET);
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                        System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        winSnakeBattle();
                        break label;
                    } else {
                        System.out.println(ConsoleColors.YELLOW + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        System.out.printf(ConsoleColors.YELLOW + "The snake has %d health points remaining.%n" + ConsoleColors.RESET, snake.getEnemyHP());
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                        System.out.println(ConsoleColors.YELLOW + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        int enemyAttackValue = snake.generateAttackValue();
                        if (enemyAttackValue == 0) {
                            System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                            System.out.println(ConsoleColors.GREEN + "The snake's attack missed!" + ConsoleColors.RESET);
                            System.out.println("Press enter to continue.");
                            scanner.nextLine();
                            System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        } else {
                            hero.changeHealthPoints(enemyAttackValue * -1);
                            System.out.println(ConsoleColors.RED + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                            System.out.printf(ConsoleColors.YELLOW + "The snake hits you for %d points!%n" + ConsoleColors.RESET, enemyAttackValue);
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
                    int enemyAttackValue = snake.generateAttackValue();
                    if (enemyAttackValue == 0) {
                        System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        System.out.println(ConsoleColors.GREEN + "The snake's attack missed!" + ConsoleColors.RESET);
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                        System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                    } else {
                        hero.changeHealthPoints(enemyAttackValue * -1);
                        System.out.println(ConsoleColors.RED + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        System.out.printf(ConsoleColors.RED + "The snake hits you for %d points!%n" + ConsoleColors.RESET, enemyAttackValue);
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
                            System.out.println(ConsoleColors.RED + "The snake manages to hit you as you run away! You have lost half of your remaining health points!" + ConsoleColors.RESET);

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

    public void winSnakeBattle() {
        System.out.println(ConsoleColors.PURPLE + "You have defeated the giant snake!" + ConsoleColors.RESET);
        System.out.println("Press enter to continue.");
        scanner.nextLine();
        System.out.println(ConsoleColors.GREEN + "You find a potion and 8 gold!" + ConsoleColors.RESET);
        System.out.println("Press enter to continue.");
        scanner.nextLine();
        hero.changePotionCount(1);
        hero.changeGold(8);
        hero.changeDesertWins();
        while (true) {
            System.out.println(ConsoleColors.YELLOW + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN + "Would you like to stay in the desert?" + ConsoleColors.RESET);



            if (hero.getHealthPoints() > (hero.getMaxHP() / 3) + (hero.getMaxHP() / 3)) {
                System.out.printf(ConsoleColors.GREEN + "Your health points: %d.%n" + ConsoleColors.RESET, hero.getHealthPoints());
            } else if (hero.getHealthPoints() < (hero.getMaxHP() / 3) + 1) {
                System.out.printf(ConsoleColors.RED + "Your health points: %d.%n" + ConsoleColors.RESET, hero.getHealthPoints());
            } else {
                System.out.printf(ConsoleColors.YELLOW + "Your health points: %d.%n" + ConsoleColors.RESET, hero.getHealthPoints());
            }

            if (hero.getPotionCount() == 0) {
                System.out.printf(ConsoleColors.RED + "Your potion count: %d.%n" + ConsoleColors.RESET, hero.getPotionCount());
            } else if (hero.getPotionCount() < 3) {
                System.out.printf(ConsoleColors.YELLOW + "Your potion count: %d.%n" + ConsoleColors.RESET, hero.getPotionCount());
            } else {
                System.out.printf(ConsoleColors.GREEN + "Your potion count: %d.%n" + ConsoleColors.RESET, hero.getPotionCount());
            }

            System.out.println(ConsoleColors.CYAN + "1: Stay in the desert." + ConsoleColors.RESET);
            System.out.println(ConsoleColors.YELLOW + "2: Go back to the crossroads." + ConsoleColors.RESET);
            String action = scanner.nextLine();
            System.out.println(ConsoleColors.YELLOW + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
            if (action.equals("1")) {
                System.out.println(ConsoleColors.YELLOW + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                Desert desert = new Desert();
                desert.stayOrGo(hero.getHero(), name);
                break;
            } else if (action.equals("2")) {
                System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                Crossroads crossroads = new Crossroads(hero.getHero(), name);
                crossroads.choosePath();
                break;
            } else {
                System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                System.out.println("That is not a valid action. Let's try this again.");
                System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
            }
        }
    }
}
