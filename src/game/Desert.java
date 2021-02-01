package game;

import java.util.Scanner;

public class Desert {

    public void stayOrGo(int[] heroArray, String name) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("");
        System.out.println(ConsoleColors.YELLOW + "                /||\\");
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
        System.out.println("\\/  .   .    \\/     \\/    __..--..    .    . \\/   __...--..__..__       .     \\/ " + ConsoleColors.RESET);

        System.out.println(ConsoleColors.YELLOW + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.YELLOW + "Welcome to the desert!" + ConsoleColors.RESET);

        while (true) {

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

            System.out.println("Press enter to continue.");

            System.out.println(ConsoleColors.YELLOW + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
            scanner.nextLine();
            System.out.println(ConsoleColors.YELLOW + "What do you want to do?" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED + "1: Look for enemies." + ConsoleColors.RESET);
            System.out.println(ConsoleColors.GREEN + "2: Leave." + ConsoleColors.RESET);

            String action = scanner.nextLine();

            if (action.equals("1")) {
                System.out.println(ConsoleColors.YELLOW + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                DesertBattle desertBattle = new DesertBattle(heroArray, name);
                desertBattle.battle();
                break;
            } else if (action.equals("2")) {
                System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                Crossroads crossroads = new Crossroads(heroArray, name);
                crossroads.choosePath();
                break;
            } else {
                System.out.println(ConsoleColors.YELLOW + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                System.out.println("That is not a valid action. Let's try this again.");
                System.out.println(ConsoleColors.YELLOW + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
            }
        }
    }
}
