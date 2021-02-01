package game;


import java.util.Scanner;

public class TrollBattle {

    private int[] heroArray;
    private final Hero hero;
    private final Troll troll;
    private final Scanner scanner;

    public TrollBattle(int[] heroArray) {
        this.heroArray = heroArray;
        this.hero = new Hero(heroArray);
        this.troll = new Troll();
        this.scanner = new Scanner(System.in);
    }

    public void battle() {

        System.out.println("");

        System.out.println("                           __.--|~|--.__                               ,,;/;");
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
        System.out.println("          |                   |         |           |/'  |");

        System.out.println("");

        System.out.println("It's a troll! He's huge and he smells terrible!");
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
                        troll.changeEnemyHP(attackValue * -1);
                        System.out.printf("You hit the troll for %d points!%n", attackValue);
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                    }
                    if (troll.getEnemyHP() <= 0) {
                        System.out.println("The troll has 0 health points remaining!");
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                        winTrollBattle();
                        break label;
                    } else {
                        System.out.printf("The troll has %d health points remaining.%n", troll.getEnemyHP());
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                        int enemyAttackValue = troll.generateAttackValue();
                        if (enemyAttackValue == 0) {
                            System.out.println("The troll's attack missed!");
                            System.out.println("Press enter to continue.");
                            scanner.nextLine();
                        } else {
                            hero.changeHealthPoints(enemyAttackValue * -1);
                            System.out.printf("The troll hits you for %d points!%n", enemyAttackValue);
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
                            System.out.println("The troll manages to hit you as you run away! You have lost half of your remaining health points!");
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

    public void winTrollBattle() {
        System.out.println("You have defeated the troll!");
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
            System.out.printf("You have %d health points.%n", heroArray[1]);
            System.out.printf("You have %d potions.%n", heroArray[0]);
            System.out.println("1: Stay in the mountains.");
            System.out.println("2: Go back to the crossroads.");
            String action = scanner.nextLine();
            if (action.equals("1")) {
                Mountain mountain = new Mountain();
                mountain.stayOrGo(hero.getHero());
                break;
            } else if (action.equals("2")) {
                Crossroads crossroads = new Crossroads(hero.getHero());
                crossroads.choosePath();
                break;
            } else {
                System.out.println("That is not a valid action. Let's try this again.");
                System.out.println("");
            }
        }
    }
}
