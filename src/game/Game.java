package game;

import java.util.Scanner;

public class Game {

    public void beginGame() {

        System.out.println("");

        System.out.println("                  /¯¯\\");
        System.out.println("                  \\__/");
        System.out.println("                   ||");
        System.out.println("                   ||");
        System.out.println("                  |  |");
        System.out.println("                  |  |");
        System.out.println("                  |  |");
        System.out.println("                  |  |");
        System.out.println("                  |  |");
        System.out.println("                  |  |");
        System.out.println("              .--.----.--.");
        System.out.println("            .-----\\__/-----.");
        System.out.println("    ___---¯¯////¯¯|\\/|¯¯\\\\\\\\¯¯---___");
        System.out.println(" /¯¯ __O_--////   |  |   \\\\\\\\--_O__ ¯¯\\");
        System.out.println("| O?¯      ¯¯¯    |  |    ¯¯¯      ¯?O |");
        System.out.println("|  '    _.-.      |  |      .-._    '  |");
        System.out.println("|O|    ?..?      ./  \\.      ?..?    |O|");
        System.out.println("| |     '?. .-.  | /\\ |  .-. .?'     | |");
        System.out.println("| ---__  ¯?__?  /|\\¯¯/|\\  ?__?¯  __--- |");
        System.out.println("|O     \\         ||\\/ |         /     O|");
        System.out.println("|       \\  /¯?_  ||   |  _?¯\\  /       |");
        System.out.println("|       / /    - ||   | -    \\ \\       |");
        System.out.println("|O   __/  | __   ||   |   __ |  \\__   O|");
        System.out.println("| ---     |/  -_/||   |\\_-  \\|     --- |");
        System.out.println("|O|            \\ ||   | /            |O|");
        System.out.println("\\ '              ||   |        ^~DLF ' /");
        System.out.println(" \\O\\    _-¯?.    ||   |    .?¯-_    /O/");
        System.out.println("  \\ \\  /  /¯¯¯?  ||   |  ?¯¯¯\\  \\  / /");
        System.out.println("   \\O\\/   |      ||   |      |   \\/O/");
        System.out.println("    \\     |      ||   |      |     /");
        System.out.println("     '.O  |_     ||   |     _|  O.'");
        System.out.println("        '._O'.__/||   |\\__.'O_.'");
        System.out.println("           '._ O ||   | O _.'");
        System.out.println("              '._||   |_.'");
        System.out.println("                 ||   |");
        System.out.println("                 ||   |");
        System.out.println("                 | \\/ |");
        System.out.println("                 |  | |");
        System.out.println("                  \\ |/");
        System.out.println("                   \\/");

        System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);

        System.out.println(ConsoleColors.PURPLE + "Welcome to your adventure! What is your name?" + ConsoleColors.RESET);
        Scanner nameScanner = new Scanner(System.in);
        String name = nameScanner.nextLine();
        if (name.isEmpty()) {
            name = "Bartholomew";
            System.out.println(ConsoleColors.PURPLE + "Don't want to tell me your name? Ok then. I shall call you Bartholomew!" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.PURPLE + "Hello, Bartholomew! You are about to embark on a wild journey of heroism and chivalry! Let's begin!" + ConsoleColors.RESET);
        } else {
            System.out.printf(ConsoleColors.PURPLE + "Hello, %s! You are about to embark on a wild journey of heroism and chivalry! Let's begin!%n" + ConsoleColors.RESET, name);
        }
        System.out.println("Press enter to continue.");
        System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
        nameScanner.nextLine();
        goToCrossroads(name);
    }


    public void goToCrossroads(String name) {
        Crossroads crossroads = new Crossroads(name);
        crossroads.choosePath();
    }
}


