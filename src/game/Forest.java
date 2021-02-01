package game;

import java.util.Scanner;

public class Forest {

    public void stayOrGo(int[] heroArray, String name) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("");
        System.out.println(ConsoleColors.GREEN + "                                       oxoxoo    ooxoo");
        System.out.println("                                      ooxoxo oo  oxoxooo");
        System.out.println("                                     oooo xxoxoo ooo ooox    ccee88oo");
        System.out.println("               ,@@@@@@@,             oxo o oxoxo  xoxxoxo C8O8O8Q8PoOb o8oo");
        System.out.println("       ,,,.   ,@@@@@@/@@,  .oo8888o.  oxo xooxoooo o ooo dOB69QO8PdUOpugoO9bD");
        System.out.println("    ,&%%&%&&%,@@@@@/@@@@@@,8888\\88/8o   ooo\\oo\\  /o/o   CgggbU8OU qOp qOdoUOdcb");
        System.out.println("   ,%&\\%&&%&&%,@@@\\@@@/@@@88\\88888/88'      \\  \\/ /         6OuU  /p u goCodeuP");
        System.out.println("   %&&%&%&/%&&%@@\\@@/ /@@@88888\\88888'       |   /            \\\\\\//  /douUP");
        System.out.println("   %&&%/ %&%%&&@@\\ V /@@' `88\\8 `/88'        |  |              \\\\\\////");
        System.out.println("   `&%\\ ` /%&'    |.|        \\ '|8'          | D|               |||/\\");
        System.out.println("       |o|        | |         | |            |  |               |||\\/");
        System.out.println("       |.|        | |         | |            |  |               |||||");
        System.out.println("    \\\\/ ._\\//_/__/  ,\\_//__\\\\/.  \\_//__/____/    \\____// \\_/___//||||\\___" + ConsoleColors.RESET);

        System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + "Welcome to the forest!" + ConsoleColors.RESET);

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

            System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
            scanner.nextLine();
            System.out.println(ConsoleColors.YELLOW + "What do you want to do?" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED + "1: Look for enemies." + ConsoleColors.RESET);
            System.out.println(ConsoleColors.GREEN + "2: Leave." + ConsoleColors.RESET);

            String action = scanner.nextLine();

            if (action.equals("1")) {
                System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                ForestBattle forestBattle = new ForestBattle(heroArray, name);
                forestBattle.battle();
                break;
            } else if (action.equals("2")) {
                System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                Crossroads crossroads = new Crossroads(heroArray, name);
                crossroads.choosePath();
                break;
            } else {
                System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                System.out.println("That is not a valid action. Let's try this again.");
                System.out.println(ConsoleColors.GREEN + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
            }
        }
    }
}
