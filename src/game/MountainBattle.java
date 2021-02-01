package game;

import java.util.*;

public class MountainBattle {

    private final int[] heroArray;
    private final int mountainWins;
    private final Scanner scanner;
    private final String name;


    public MountainBattle(int[] heroArray, String name) {
        this.scanner = new Scanner(System.in);
        this.heroArray = heroArray;
        this.mountainWins = heroArray[4];
        this.name = name;
    }

    public void battle() {
        if (mountainWins == 0) {
            fightOrc();
        } else if (mountainWins == 1) {
            fightTroll();
        } else if (mountainWins == 2) {
            fightUruk();
        } else {
            System.out.println("Dude. You've already killed everything in the mountains. Go somewhere else.");
            System.out.println("Press enter to continue.");
            scanner.nextLine();
            Crossroads crossroads = new Crossroads(heroArray, name);
            crossroads.choosePath();
        }
    }

    public void fightOrc() {
        OrcBattle orcBattle = new OrcBattle(heroArray, name);
        orcBattle.battle();
    }

    public void fightTroll() {
        TrollBattle trollBattle = new TrollBattle(heroArray, name);
        trollBattle.battle();
    }

    public void fightUruk() {
        UrukBattle urukBattle = new UrukBattle(heroArray, name);
        urukBattle.battle();
    }

}
