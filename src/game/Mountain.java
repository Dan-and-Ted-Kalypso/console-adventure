package game;

import java.util.*;

public class Mountain {

    public void stayOrGo(int[] heroArray) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("                                 _");
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
        System.out.println(" `::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::'");

        System.out.println("");
        System.out.println("Welcome to the mountains!");

        while (true) {

            System.out.printf("Your health points: %d.%n", heroArray[1]);
            System.out.printf("Your potion count: %d.%n", heroArray[0]);
            System.out.println("What do you want to do?");
            System.out.println("1: Look for enemies.");
            System.out.println("2: Leave.");

            String action = scanner.nextLine();

            if (action.equals("1")) {
                MountainBattle mountainBattle = new MountainBattle(heroArray);
                mountainBattle.battle();
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
