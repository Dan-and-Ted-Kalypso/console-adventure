package game;


import java.util.Scanner;

public class TrollBattle {

    private int[] heroArray;
    private final Hero hero;
    private final Troll troll;
    private final Scanner scanner;
    private final String name;

    public TrollBattle(int[] heroArray, String name) {
        this.heroArray = heroArray;
        this.hero = new Hero(heroArray, name);
        this.troll = new Troll();
        this.scanner = new Scanner(System.in);
        this.name = name;
    }

    public void battle() {

        System.out.println(ConsoleColors.BLUE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
        System.out.println("");

        System.out.println(ConsoleColors.BLUE + "                           __.--|~|--.__                               ,,;/;");
        System.out.println("                         /~     | |    ;~\\                          ,;;;/;;'");
        System.out.println("                        /|      | |    ;~\\\\                      ,;;;;/;;;'");
        System.out.println("                       |/|      \\_/   ;;;|\\                    ,;;;;/;;;;'");
        System.out.println("                       |/ \\          ;;;/  )                 ,;;;;/;;;;;'");
        System.out.println("                   ___ | ______     ;_____ |___....__      ,;;;;/;;;;;'");
        System.out.println("             ___.-~ \\\\(| \\  \\.\\ \\__/ /./ /:|)~   ~   \\   ,;;;;/;;;;;'");
        System.out.println("         /~~~    ~\\    |  ~-.     |   .-~: |//  _.-~~--,;;;;/;;;;;'");
        System.out.println("        (.-~___     \\.'|    | /-.__.-\\|::::| //~     ,;;;;/;;;;;'");
        System.out.println("        /      ~~--._ \\|   /          `\\:: |/      ,;;;;/;;;;;'");
        System.out.println("     .-|             ~~|   |  /V\"\"\"\"V\\ |:  |     ,;;;;/;;;;;' \\");
        System.out.println("    /                   \\  |  ~`^~~^'~ |  /    ,;;;;/;;;;;'    ;");
        System.out.println("   (        \\             \\|`\\._____./'|/    ,;;;;/;;;;;'      '\\");
        System.out.println("  / \\        \\                             ,;;;;/;;;;;'     /    |");
        System.out.println(" |            |                          ,;;;;/;;;;;'      |     |");
        System.out.println("|`-._          |                       ,;;;;/;;;;;'              \\");
        System.out.println("|             /                      ,;;;;/;;;;;'  \\              \\__________");
        System.out.println("(             )                 |  ,;;;;/;;;;;'      |        _.--~");
        System.out.println(" \\          \\/ \\              ,  ;;;;;/;;;;;'       /(     .-~_..--~~~~~~~~~~");
        System.out.println(" \\__         '  `       ,     ,;;;;;/;;;;;'    .   /  \\   / /~");
        System.out.println(" /          \\'  |`._______ ,;;;;;;/;;;;;;'    /   :    \\/'/'       /|_/|   ``|");
        System.out.println("| _.-~~~~-._ |   \\ __   .,;;;;;;/;;;;;;' ~~~~'   .'    | |       /~ (/\\/    ||");
        System.out.println("/~ _.-~~~-._\\    /~/   ;;;;;;;/;;;;;;;'          |    | |       / ~/_-'|-   /|");
        System.out.println("(/~         \\| /' |   ;;;;;;/;;;;;;;;            ;   | |       (.-~;  /-   / |");
        System.out.println("|            /___ `-,;;;;;/;;;;;;;;'            |   | |      ,/)  /  /-   /  |");
        System.out.println(" \\            \\  `-.`---/;;;;;;;;;' |          _'   | |    /'('  /  /|- _/  //");
        System.out.println("   \\           /~~/ `-. |;;;;;''    ______.--~~ ~\\  | |  ,~)')  /   | \\~-==//");
        System.out.println("     \\      /~(   `-\\  `-.`-;   /|    ))   __-####\\ | |   (,   /|    |  \\");
        System.out.println("       \\  /~.  `-.   `-.( `-.`~~ /##############'~~)| |   '   / |    |   ~\\");
        System.out.println("        \\(   \\    `-._ /~)_/|  /############'       | |      /  \\     \\_\\  `\\");
        System.out.println("        ,~`\\  `-._  / )#####|/############'   /     | |  _--~ _/ | .-~~____--'");
        System.out.println("       ,'\\  `-._  ~)~~ `################'           | | ((~>/~   \\ (((' -_");
        System.out.println("     ,'   `-.___)~~      `#############             | |           ~-_     ~\\_");
        System.out.println(" _.,'        ,'           `###########              | |            _-~-__    (");
        System.out.println("|  `-.     ,'              `#########       \\       | |          ((.-~~~-~_--~");
        System.out.println("`\\    `-.;'                  `#####\"                | |           \"     ((.-~~");
        System.out.println("  `-._   )               \\     |   |        .       |  \\                 \"");
        System.out.println("      `~~  _/                  |    \\               |   `---------------------");
        System.out.println("        |/~                `.  |     \\        .     |       __.---------------");
        System.out.println("         |                   \\ ;      \\             |   _.-~");
        System.out.println("         |                    |        |            |  /  |");
        System.out.println("          |                   |         |           |/'  |" + ConsoleColors.RESET);

        System.out.println(ConsoleColors.BLUE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);

        System.out.println(ConsoleColors.BLUE + "It's a troll! He's huge and he smells terrible!" + ConsoleColors.RESET);
        System.out.println("Press enter to continue.");
        System.out.println(ConsoleColors.BLUE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
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
                        troll.changeEnemyHP(attackValue * -1);
                        System.out.println(ConsoleColors.BLUE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        System.out.printf(ConsoleColors.GREEN + "You hit the troll for %d points!%n" + ConsoleColors.RESET, attackValue);
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                        System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                    }
                    if (troll.getEnemyHP() <= 0) {
                        System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        System.out.println(ConsoleColors.GREEN + "The troll has 0 health points remaining!" + ConsoleColors.RESET);
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                        System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        winTrollBattle();
                        break label;
                    } else {
                        System.out.println(ConsoleColors.YELLOW + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        System.out.printf(ConsoleColors.YELLOW + "The troll has %d health points remaining.%n" + ConsoleColors.RESET, troll.getEnemyHP());
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                        System.out.println(ConsoleColors.YELLOW + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        int enemyAttackValue = troll.generateAttackValue();
                        if (enemyAttackValue == 0) {
                            System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                            System.out.println(ConsoleColors.GREEN + "The troll's attack missed!" + ConsoleColors.RESET);
                            System.out.println("Press enter to continue.");
                            scanner.nextLine();
                            System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        } else {
                            hero.changeHealthPoints(enemyAttackValue * -1);
                            System.out.println(ConsoleColors.RED + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                            System.out.printf(ConsoleColors.YELLOW + "The troll hits you for %d points!%n" + ConsoleColors.RESET, enemyAttackValue);
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
                    int enemyAttackValue = troll.generateAttackValue();
                    if (enemyAttackValue == 0) {
                        System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        System.out.println(ConsoleColors.GREEN + "The troll's attack missed!" + ConsoleColors.RESET);
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                        System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                    } else {
                        hero.changeHealthPoints(enemyAttackValue * -1);
                        System.out.println(ConsoleColors.RED + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                        System.out.printf(ConsoleColors.RED + "The troll hits you for %d points!%n" + ConsoleColors.RESET, enemyAttackValue);
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
                            System.out.println(ConsoleColors.RED + "The troll manages to hit you as you run away! You have lost half of your remaining health points!" + ConsoleColors.RESET);

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

    public void winTrollBattle() {
        System.out.println(ConsoleColors.PURPLE + "You have defeated the troll!" + ConsoleColors.RESET);
        System.out.println("Press enter to continue.");
        scanner.nextLine();
        System.out.println(ConsoleColors.GREEN + "You find a potion and 10 gold!" + ConsoleColors.RESET);
        System.out.println("Press enter to continue.");
        scanner.nextLine();
        hero.changePotionCount(1);
        hero.changeGold(10);
        hero.changeMountainWins();
        while (true) {
            System.out.println(ConsoleColors.BLUE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN + "Would you like to stay in the mountains?" + ConsoleColors.RESET);

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

            System.out.println(ConsoleColors.CYAN + "1: Stay in the mountains." + ConsoleColors.RESET);
            System.out.println(ConsoleColors.YELLOW + "2: Go back to the crossroads." + ConsoleColors.RESET);
            String action = scanner.nextLine();
            System.out.println(ConsoleColors.BLUE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
            if (action.equals("1")) {
                System.out.println(ConsoleColors.BLUE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                Mountain mountain = new Mountain();
                mountain.stayOrGo(hero.getHero(), name);
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
