package game;

import java.util.*;

public class Crossroads {

    protected Hero hero;
    protected Scanner scanner;
    protected int[] heroArray;

    public Crossroads() {
        this.hero = new Hero();
        this.heroArray = this.hero.getHero();
        this.scanner = new Scanner(System.in);
    }

    public Crossroads(int[] heroArray) {
        this.hero = new Hero(heroArray);
        this.heroArray = heroArray;
        this.scanner = new Scanner(System.in);
    }

    public void choosePath() {
        label:
        while (true) {

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

            System.out.println("");

            System.out.println("You are standing at a crossroads.");
            System.out.printf("Your health points: %d.%n", heroArray[1]);
            System.out.printf("Your potion count: %d.%n", heroArray[0]);
            System.out.println("Choose a path by selecting a number: ");
            System.out.println("0: The Inn");
            System.out.println("1: Forest");
            System.out.println("2: Desert");
            System.out.println("3: Mountains");
            System.out.println("4: The Great Volcano");

            String direction = scanner.nextLine();

            switch (direction) {
                case "0":
                    confirmInn(heroArray);
                    break label;
                case "1":
                    confirmForest(heroArray);
                    break label;
                case "2":
                    confirmDesert(heroArray);
                    break label;
                case "3":
                    confirmMountain(heroArray);
                    break label;
                case "4":
                    confirmBoss(heroArray);
                    break label;
                default:
                    System.out.println("That is not a valid path. Please enter a number (0, 1, 2, 3, 4) to choose your path.");
                    break;
            }

        }

    }

    public void confirmInn(int[] heroArray) {
        while (true) {
            System.out.println("Are you sure you wish to travel to The Inn?");
            System.out.println("1: Travel.");
            System.out.println("2: Cancel.");
            String confirm = scanner.nextLine();
            if (!confirm.equals("1") && !confirm.equals("2")) {
                System.out.println("That is not a valid choice. Let's try this again.");
            } else if (confirm.equals("1")) {
                goToInn(heroArray);
                break;
            } else {
                choosePath();
                break;
            }
        }

    }

    public void goToInn(int[] heroArray) {
        System.out.println("Welcome to The Inn! You can rest and recharge your health points here for 10 gold, or you can visit the merchant.");
        Inn inn = new Inn(heroArray);
        inn.stayOrGo();
    }

    public void confirmForest(int[] heroArray) {
        while (true) {
            System.out.println("Are you sure you wish to travel to The Forest?");
            System.out.println("1: Travel.");
            System.out.println("2: Cancel.");
            String confirm = scanner.nextLine();
            if (!confirm.equals("1") && !confirm.equals("2")) {
                System.out.println("That is not a valid choice. Let's try this again.");
            } else if (confirm.equals("1")) {
                goToForest(heroArray);
                break;
            } else {
                choosePath();
                break;
            }
        }

    }

    public void goToForest(int[] heroArray) {
        Forest forest = new Forest();
        forest.stayOrGo(heroArray);
    }

    public void confirmDesert(int[] heroArray) {
        while (true) {
            System.out.println("Are you sure you wish to travel to The Desert? The enemies there may pose somewhat of a challenge.");
            System.out.println("1: Travel.");
            System.out.println("2: Cancel.");
            String confirm = scanner.nextLine();
            if (!confirm.equals("1") && !confirm.equals("2")) {
                System.out.println("That is not a valid choice. Let's try this again.");
            } else if (confirm.equals("1")) {
                goToDesert(heroArray);
                break;
            } else {
                choosePath();
                break;
            }
        }

    }

    public void goToDesert(int[] heroArray) {
        Desert desert = new Desert();
        desert.stayOrGo(heroArray);
    }

    public void confirmMountain(int[] heroArray) {
        while (true) {
            System.out.println("Are you sure you wish to travel to the mountains? The enemies there are very challenging.");
            System.out.println("1: Travel.");
            System.out.println("2: Cancel.");
            String confirm = scanner.nextLine();
            if (!confirm.equals("1") && !confirm.equals("2")) {
                System.out.println("That is not a valid choice. Let's try this again.");
            } else if (confirm.equals("1")) {
                goToMountain(heroArray);
                break;
            } else {
                choosePath();
                break;
            }
        }

    }

    public void goToMountain(int[] heroArray) {
        Mountain mountain = new Mountain();
        mountain.stayOrGo(heroArray);
    }

    public void confirmBoss(int[] heroArray) {
        while (true) {
            System.out.println("Are you sure you wish to travel to the Great Volcano? The big boss lives there and he can squash adventurers like a bug if they are unprepared.");
            System.out.println("1: Travel.");
            System.out.println("2: Cancel.");
            String confirm = scanner.nextLine();
            if (!confirm.equals("1") && !confirm.equals("2")) {
                System.out.println("That is not a valid choice. Let's try this again.");
            } else if (confirm.equals("1")) {
                goToBoss(heroArray);
                break;
            } else {
                choosePath();
                break;
            }
        }

    }

    public void goToBoss(int[] heroArray) {
        Boss boss = new Boss();
        boss.stayOrGo(heroArray);
    }

}
