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

        System.out.println("");

        System.out.println("Welcome to your adventure! What is your name?");
        Scanner nameScanner = new Scanner(System.in);
        String name = nameScanner.nextLine();
        if (name.isEmpty()) {
            name = "Bartholomew";
            System.out.println("Don't want to tell me your name? Ok then. I shall call you Bartholomew!");
            System.out.println("Hello, Bartholomew! You are about to embark on a wild journey of heroism and chivalry! Let's begin!");
        } else {
            System.out.printf("Hello, %s! You are about to embark on a wild journey of heroism and chivalry! Let's begin!%n", name);
        }
        System.out.println("Press enter to continue.");
        nameScanner.nextLine();
        goToCrossroads(name);
    }


    public void goToCrossroads(String name) {
        Crossroads crossroads = new Crossroads(name);
        crossroads.choosePath();
    }
}
