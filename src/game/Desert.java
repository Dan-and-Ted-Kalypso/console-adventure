package game;

import java.util.Scanner;

public class Desert {

    public void stayOrGo(int[] heroArray, String name) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("");
        System.out.println("                /||\\");
        System.out.println("                ||||");
        System.out.println("                ||||");
        System.out.println("                |||| /|\\");
        System.out.println("           /|\\  |||| |||");
        System.out.println("           |||  |||| |||");
        System.out.println("           |||  |||| |||");
        System.out.println("           |||  |||| d||");
        System.out.println("           |||  |||||||/");
        System.out.println("           ||b._||||~~'");
        System.out.println("           \\||||||||");
        System.out.println("            `~~~||||");
        System.out.println("                ||||");
        System.out.println("                ||||");
        System.out.println("~~~~~~~~~~~~~~~~||||~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("  \\/..__..--  . |||| \\/  .  ..       .  \\/     ..     .    \\/    .     ..  \\/   .");
        System.out.println("\\/         \\/ \\/    \\/     .  ...         \\/     .    \\/ \\/    \\/   \\/         \\/");
        System.out.println("        .  \\/              \\/    .        .  \\/              \\/    .     \\/..__. ");
        System.out.println(". \\/             .   \\/     .      . \\/             .   \\/     .    \\/     \\/  . ");
        System.out.println("   __...--..__..__       .     \\/     \\/  .   .    \\/     \\/    __..--..         ");
        System.out.println("\\/  .   .    \\/     \\/    __..--..    .    . \\/   __...--..__..__       .     \\/ ");

        System.out.println("");
        System.out.println("Welcome to the desert!");

        while (true) {

            System.out.printf("Your health points: %d.%n", heroArray[1]);
            System.out.printf("Your potion count: %d.%n", heroArray[0]);
            System.out.println("Press enter to continue.");
            scanner.nextLine();
            System.out.println("What do you want to do?");
            System.out.println("1: Look for enemies.");
            System.out.println("2: Leave.");

            String action = scanner.nextLine();

            if (action.equals("1")) {
                DesertBattle desertBattle = new DesertBattle(heroArray, name);
                desertBattle.battle();
                break;
            } else if (action.equals("2")) {
                Crossroads crossroads = new Crossroads(heroArray, name);
                crossroads.choosePath();
                break;
            } else {
                System.out.println("That is not a valid action. Let's try this again.");
                System.out.println("");
            }
        }
    }
}
