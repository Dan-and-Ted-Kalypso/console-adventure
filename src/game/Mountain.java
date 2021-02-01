package game;

import java.util.*;

public class Mountain {

    public void stayOrGo(int[] heroArray, String name) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("");
        System.out.println(ConsoleColors.BLUE + "                                 _");
        System.out.println("                       .-.      / \\        _");
        System.out.println("           ^^         /   \\    /^./\\__   _/ \\");
        System.out.println("         _        .--'\\/\\_ \\__/.      \\ /    \\  ^^  ___");
        System.out.println("        / \\_    _/ ^      \\/  __  :'   /\\/\\  /\\  __/   \\");
        System.out.println("       /    \\  /    .'   _/  /  \\   ^ /    \\/  \\/ .`'\\_/\\");
        System.out.println("      /\\/\\  /\\/ :' __  ^/  ^/    `--./.'  ^  `-.\\ _    _:\\ _");
        System.out.println("     /    \\/  \\  _/  \\-' __/.' ^ _   \\_   .'\\   _/ \\ .  __/ \\");
        System.out.println("   /\\  .-   `. \\/     \\ / -.   _/ \\ -. `_/   \\ /    `._/  ^  \\");
        System.out.println("  /  `-.__ ^   / .-'.--'    . /    `--./ .-'  `-.  `-. `.  -  `.");
        System.out.println("@/        `.  / /      `-.   /  .-'   / .   .'   \\    \\  \\  .-  \\%");
        System.out.println("@(88%@)@%% @)&@&(88&@.-_=_-=_-=_-=_-=_.8@% &@&&8(8%@%8)(8@%8 8%@)%");
        System.out.println("@88:::&(&8&&8::JGS:&`.~-_~~-~~_~-~_~-~~=.'@(&%::::%@8&8)::&#@8::::");
        System.out.println("`::::::8%@@%:::::@%&8:`.=~~-.~~-.~~=..~'8::::::::&@8:::::&8::::::'");
        System.out.println(" `::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::'" + ConsoleColors.RESET);

        System.out.println(ConsoleColors.BLUE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE + "Welcome to the mountains!" + ConsoleColors.RESET);

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

            System.out.println(ConsoleColors.BLUE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);

            scanner.nextLine();
            System.out.println(ConsoleColors.YELLOW + "What do you want to do?" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED + "1: Look for enemies." + ConsoleColors.RESET);
            System.out.println(ConsoleColors.GREEN + "2: Leave." + ConsoleColors.RESET);

            String action = scanner.nextLine();

            if (action.equals("1")) {
                System.out.println(ConsoleColors.BLUE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                MountainBattle mountainBattle = new MountainBattle(heroArray, name);
                mountainBattle.battle();
                break;
            } else if (action.equals("2")) {
                System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                Crossroads crossroads = new Crossroads(heroArray, name);
                crossroads.choosePath();
                break;
            } else {
                System.out.println(ConsoleColors.BLUE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                System.out.println("That is not a valid action. Let's try this again.");
                System.out.println(ConsoleColors.BLUE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
            }
        }

    }
}
