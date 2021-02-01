package game;

import java.util.*;

public class ForestBattle {

    private final int[] heroArray;
    private final int forestWins;
    private final Scanner scanner;

    public ForestBattle(int[] heroArray) {
        this.heroArray = heroArray;
        this.forestWins = heroArray[2];
        this.scanner = new Scanner(System.in);
    }

    public void battle() {
        if (forestWins == 0) {
            fightSpider();
        } else if (forestWins == 1) {
            fightWolf();
        } else if (forestWins == 2) {
            fightRous();
        } else {
            System.out.println("Dude. You've already killed everything in the forest. Go somewhere else.");
            System.out.println("Press enter to continue.");
            scanner.nextLine();
            Crossroads crossroads = new Crossroads(heroArray);
            crossroads.choosePath();
        }
    }

    public void fightSpider() {
        SpiderBattle spiderBattle = new SpiderBattle(heroArray);
        spiderBattle.battle();
    }

    public void fightWolf() {
        WolfBattle wolfBattle = new WolfBattle(heroArray);
        wolfBattle.battle();
    }

    public void fightRous() {
        RousBattle rousBattle = new RousBattle(heroArray);
        rousBattle.battle();
    }


}
