package game;

import java.util.*;

public class Crossroads {

    private final Hero hero;
    private final Scanner scanner;
    private final int[] heroArray;
    private final String name;

    public Crossroads(String name) {
        this.name = name;
        this.hero = new Hero(name);
        this.heroArray = this.hero.getHero();
        this.scanner = new Scanner(System.in);
    }

    public Crossroads(int[] heroArray, String name) {
        this.name = name;
        this.hero = new Hero(heroArray, name);
        this.heroArray = heroArray;
        this.scanner = new Scanner(System.in);
    }

    public void choosePath() {
        label:
        while (true) {

            System.out.println("");
            System.out.println("                                   ,'-',");
            System.out.println("                                   '___'");
            System.out.println("                                 ,-'   '-,");
            System.out.println("                                /_       _\\");
            System.out.println("                                | |     | |");
            System.out.println("  -,,___                        | |_____| |                         ___,,-");
            System.out.println("  ,,___ ''---,,___              \\@|     |@/               ___,,---'' ___,,");
            System.out.println("       ''---,,___ ''---,,___     ||  |  ||      ___,,---'' ___,,---''");
            System.out.println("                 ''---,,__  '--,| |  |  | |,--'' ___,,---''");
            System.out.println("     _____________________'--,    |__|__|    ,--'_____________________");
            System.out.println("                                 ,'  '  ',");
            System.out.println("  ________________________        '--'--'        _________________________");
            System.out.println("                    __,--'    _,           ,_    '--,__");
            System.out.println("              __,--'      _,-' |           | '-,_      '--,__");
            System.out.println("        __,--'        _,-'    |             |    '-,_        '--,__");
            System.out.println("  __,--'          _,-'       |               |       '-,_          '--,__");
            System.out.println("              _,-'          |                 |          '-,_");
            System.out.println("          _,-'             |                   |             '-,_");
            System.out.println("      _,-'                |                     |                '-,_");

            System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);

            System.out.println(ConsoleColors.PURPLE + "You are standing at a crossroads." + ConsoleColors.RESET);
            if (heroArray[1] > (heroArray[11] / 3) + (heroArray[11] / 3)) {
                System.out.printf(ConsoleColors.GREEN + "Your health points: %d.%n" + ConsoleColors.RESET, heroArray[1]);
            } else if (heroArray[1] < (heroArray[11] / 3) + 1) {
                System.out.printf(ConsoleColors.RED + "Your health points: %d.%n" + ConsoleColors.RESET, heroArray[1]);
            } else {
                System.out.printf(ConsoleColors.YELLOW + "Your health points: %d.%n" + ConsoleColors.RESET, heroArray[1]);
            }

            if (heroArray[0] == 0) {
                System.out.printf(ConsoleColors.RED + "Your potion count: %d.%n" + ConsoleColors.RESET, heroArray[0]);
            } else if (heroArray[0] < 3) {
                System.out.printf(ConsoleColors.YELLOW + "Your potion count: %d.%n" + ConsoleColors.RESET, heroArray[0]);
            } else {
                System.out.printf(ConsoleColors.GREEN + "Your potion count: %d.%n" + ConsoleColors.RESET, heroArray[0]);
            }

            System.out.println(ConsoleColors.PURPLE + "Choose a path by selecting a number: " + ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN + "0: The Inn" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.GREEN + "1: Forest" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.YELLOW + "2: Desert" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.BLUE + "3: Mountains" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED + "4: The Great Volcano" + ConsoleColors.RESET);

            String direction = scanner.nextLine();

            switch (direction) {
                case "0":
                    confirmInn(heroArray, name);
                    break label;
                case "1":
                    confirmForest(heroArray, name);
                    break label;
                case "2":
                    confirmDesert(heroArray, name);
                    break label;
                case "3":
                    confirmMountain(heroArray, name);
                    break label;
                case "4":
                    confirmBoss(heroArray, name);
                    break label;
                default:
                    System.out.println("That is not a valid path. Please enter a number (0, 1, 2, 3, 4) to choose your path.");
                    System.out.println("Press enter to continue.");
                    scanner.nextLine();
                    System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                    break;
            }

        }

    }

    public void confirmInn(int[] heroArray, String name) {
        while (true) {
            System.out.println(ConsoleColors.CYAN + "Are you sure you wish to travel to The Inn?" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.GREEN + "1: Travel." + ConsoleColors.RESET);
            System.out.println(ConsoleColors.YELLOW + "2: Cancel." + ConsoleColors.RESET);
            String confirm = scanner.nextLine();
            if (!confirm.equals("1") && !confirm.equals("2")) {
                System.out.println("That is not a valid choice. Let's try this again.");
                System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
            } else if (confirm.equals("1")) {
                System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                goToInn(heroArray, name);
                break;
            } else {
                System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                choosePath();
                break;
            }
        }

    }

    public void goToInn(int[] heroArray, String name) {
        System.out.println("Welcome to The Inn! You can rest and recharge your health points here for 10 gold, or you can visit the merchant.");
        Inn inn = new Inn(heroArray, name);
        inn.stayOrGo();
    }

    public void confirmForest(int[] heroArray, String name) {
        while (true) {
            System.out.println(ConsoleColors.CYAN + "Are you sure you wish to travel to The Forest?" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.GREEN + "1: Travel." + ConsoleColors.RESET);
            System.out.println(ConsoleColors.YELLOW + "2: Cancel." + ConsoleColors.RESET);
            String confirm = scanner.nextLine();
            if (!confirm.equals("1") && !confirm.equals("2")) {
                System.out.println("That is not a valid choice. Let's try this again.");
                System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
            } else if (confirm.equals("1")) {
                System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                goToForest(heroArray, name);
                break;
            } else {
                System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                choosePath();
                break;
            }
        }

    }

    public void goToForest(int[] heroArray, String name) {
        Forest forest = new Forest();
        forest.stayOrGo(heroArray, name);
    }

    public void confirmDesert(int[] heroArray, String name) {
        while (true) {
            System.out.println(ConsoleColors.CYAN + "Are you sure you wish to travel to The Desert? The enemies there may pose somewhat of a challenge." + ConsoleColors.RESET);
            System.out.println(ConsoleColors.GREEN + "1: Travel." + ConsoleColors.RESET);
            System.out.println(ConsoleColors.YELLOW + "2: Cancel." + ConsoleColors.RESET);
            String confirm = scanner.nextLine();
            if (!confirm.equals("1") && !confirm.equals("2")) {
                System.out.println("That is not a valid choice. Let's try this again.");
                System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
            } else if (confirm.equals("1")) {
                System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                goToDesert(heroArray, name);
                break;
            } else {
                System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                choosePath();
                break;
            }
        }

    }

    public void goToDesert(int[] heroArray, String name) {
        Desert desert = new Desert();
        desert.stayOrGo(heroArray, name);
    }

    public void confirmMountain(int[] heroArray, String name) {
        while (true) {
            System.out.println(ConsoleColors.CYAN + "Are you sure you wish to travel to the mountains? The enemies there are very challenging." + ConsoleColors.RESET);
            System.out.println(ConsoleColors.GREEN + "1: Travel." + ConsoleColors.RESET);
            System.out.println(ConsoleColors.YELLOW + "2: Cancel." + ConsoleColors.RESET);
            String confirm = scanner.nextLine();
            if (!confirm.equals("1") && !confirm.equals("2")) {
                System.out.println("That is not a valid choice. Let's try this again.");
                System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
            } else if (confirm.equals("1")) {
                System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                goToMountain(heroArray, name);
                break;
            } else {
                System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                choosePath();
                break;
            }
        }

    }

    public void goToMountain(int[] heroArray, String name) {
        Mountain mountain = new Mountain();
        mountain.stayOrGo(heroArray, name);
    }

    public void confirmBoss(int[] heroArray, String name) {
        while (true) {
            System.out.println(ConsoleColors.YELLOW + "Are you sure you wish to travel to the Great Volcano? The Big Boss lives there and he can squash adventurers like a bug if they are unprepared!" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED + "1: Travel." + ConsoleColors.RESET);
            System.out.println(ConsoleColors.GREEN + "2: Cancel." + ConsoleColors.RESET);
            String confirm = scanner.nextLine();
            if (!confirm.equals("1") && !confirm.equals("2")) {
                System.out.println("That is not a valid choice. Let's try this again.");
                System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
            } else if (confirm.equals("1")) {
                System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                goToBoss(heroArray, name);
                break;
            } else {
                System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                choosePath();
                break;
            }
        }

    }

    public void goToBoss(int[] heroArray, String name) {
        Boss boss = new Boss();
        boss.stayOrGo(heroArray, name);
    }

}
