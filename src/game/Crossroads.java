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
        while (true) {
            System.out.println("You are standing at a crossroads. Choose a path by selecting a number: ");
            System.out.println("0: The Inn");
            System.out.println("1: Forest");
            System.out.println("2: Desert");
            System.out.println("3: Mountains");
            System.out.println("4: The Great Volcano");

            String direction = scanner.nextLine();

            if (direction.equals("0")) {
                confirmMountain(heroArray);
                break;
            } else if (direction.equals("1")) {
                confirmMountain(heroArray);
                break;
            } else if (direction.equals("2")) {
                confirmMountain(heroArray);
                break;
            } else if (direction.equals("3")) {
                confirmMountain(heroArray);
                break;
            } else if (direction.equals("4")) {
                confirmMountain(heroArray);
                break;
            } else {
                System.out.println("That is not a valid path. Please enter a number (0, 1, 2, 3, 4) to choose your path.");
            }

        }

    }

    public void confirmInn(int[] heroArray) {
        while (true) {
            System.out.println("Are you sure you wish to travel to The Inn?");
            String confirm = scanner.nextLine();
            if (!confirm.equals("1") && !confirm.equals("2")) {
                System.out.println("That is not a valid choice. Let's try this again.");
            } else if (confirm.equals("1")) {
                goToInn(heroArray);
                break;
            } else {
                choosePath();
            }
        }

    }

    public void goToInn(int[] heroArray) {
        Mountain mountain = new Mountain();
        mountain.stayOrGo(heroArray);
    }

    public void confirmForest(int[] heroArray) {
        while (true) {
            System.out.println("Are you sure you wish to travel to The Forest?");
            String confirm = scanner.nextLine();
            if (!confirm.equals("1") && !confirm.equals("2")) {
                System.out.println("That is not a valid choice. Let's try this again.");
            } else if (confirm.equals("1")) {
                goToForest(heroArray);
                break;
            } else {
                choosePath();
            }
        }

    }

    public void goToForest(int[] heroArray) {
        Forest forest = new Forest();
        forest.stayOrGo(heroArray);
    }

    public void confirmMountain(int[] heroArray) {
        while (true) {
            System.out.println("Are you sure you wish to travel to the mountains? The enemies there are very challenging. Type 1 to go forward anyway or 2 to choose a different path.");
            String confirm = scanner.nextLine();
            if (!confirm.equals("1") && !confirm.equals("2")) {
                System.out.println("That is not a valid choice. Let's try this again.");
            } else if (confirm.equals("1")) {
                goToMountain(heroArray);
                break;
            } else {
                choosePath();
            }
        }

    }

    public void goToMountain(int[] heroArray) {
        Mountain mountain = new Mountain();
        mountain.stayOrGo(heroArray);
    }
}
