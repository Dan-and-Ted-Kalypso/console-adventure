package game;

import java.util.Scanner;

public class DesertBattle {

    private final int[] heroArray;
    private final int desertWins;
    private final Scanner scanner;
    private final String name;

    public DesertBattle(int[] heroArray, String name) {
        this.name = name;
        this.heroArray = heroArray;
        this.desertWins = heroArray[3];
        this.scanner = new Scanner(System.in);
    }

    public void battle() {
        if (desertWins == 0) {
            fightSnake();
        } else if (desertWins == 1) {
            fightScorpion();
        } else if (desertWins == 2) {
            fightMummy();
        } else {
            System.out.println(ConsoleColors.RED + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.YELLOW + "Dude. You've already killed everything in the desert. Go somewhere else." + ConsoleColors.RESET);
            System.out.println("Press enter to continue.");
            scanner.nextLine();
            System.out.println(ConsoleColors.RED + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
            Crossroads crossroads = new Crossroads(heroArray, name);
            crossroads.choosePath();
        }
    }

    public void fightSnake() {
        SnakeBattle snakeBattle = new SnakeBattle(heroArray, name);
        snakeBattle.battle();
    }

    public void fightScorpion() {
        ScorpionBattle scorpionBattle = new ScorpionBattle(heroArray, name);
        scorpionBattle.battle();
    }

    public void fightMummy() {
        MummyBattle mummyBattle = new MummyBattle(heroArray, name);
        mummyBattle.battle();
    }

}
