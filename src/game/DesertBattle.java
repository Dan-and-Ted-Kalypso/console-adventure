package game;

import java.util.Scanner;

public class DesertBattle {

    private final int[] heroArray;
    private final int desertWins;
    private final Scanner scanner;

    public DesertBattle(int[] heroArray) {
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
            System.out.println("Dude. You've already killed everything in the desert. Go somewhere else.");
            System.out.println("Press enter to continue.");
            scanner.nextLine();
            Crossroads crossroads = new Crossroads(heroArray);
            crossroads.choosePath();
        }
    }

    public void fightSnake() {
        SnakeBattle snakeBattle = new SnakeBattle(heroArray);
        snakeBattle.battle();
    }

    public void fightScorpion() {
        ScorpionBattle scorpionBattle = new ScorpionBattle(heroArray);
        scorpionBattle.battle();
    }

    public void fightMummy() {
        MummyBattle mummyBattle = new MummyBattle(heroArray);
        mummyBattle.battle();
    }

}
