package game;

import java.util.Scanner;

public class Forest {

    public void stayOrGo(int[] heroArray) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("                                       oxoxoo    ooxoo");
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
        System.out.println("    \\\\/ ._\\//_/__/  ,\\_//__\\\\/.  \\_//__/____/    \\____// \\_/___//||||\\___");

        System.out.println("");
        System.out.println("Welcome to the forest!");

        while (true) {


            System.out.printf("Your health points: %d.%n", heroArray[1]);
            System.out.printf("Your potion count: %d.%n", heroArray[0]);
            System.out.println("What do you want to do?");
            System.out.println("1: Look for enemies.");
            System.out.println("2: Leave.");

            String action = scanner.nextLine();

            if (action.equals("1")) {
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
