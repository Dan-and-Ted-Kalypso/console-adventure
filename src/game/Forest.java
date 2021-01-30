package game;

import java.util.Scanner;

public class Forest {

    public void stayOrGo(int[] heroArray) {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Welcome to the forest!");
            System.out.printf("You have %d health points.%n", heroArray[1]);
            System.out.printf("You have %d potions.%n", heroArray[0]);
            System.out.println("What do you want to do?");
            System.out.println("1: Look for enemies.");
            System.out.println("2: Leave.");

            String action = scanner.nextLine();

            if (action.equals("1") && heroArray[2] < 3) {
                ForestBattle forestBattle = new ForestBattle(heroArray);
                forestBattle.battle();
                break;
            } else if (action.equals("2")) {
                Crossroads crossroads = new Crossroads(heroArray);
                crossroads.choosePath();
                break;
            } else {
                System.out.println("That is not a valid action. Let's try this again.");
            }
        }

    }
}
