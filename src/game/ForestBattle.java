package game;

import java.util.*;

public class ForestBattle {

    private int[] heroArray;
    private int forestWins;

    public ForestBattle(int[] heroArray) {
        this.heroArray = heroArray;
        this.forestWins = heroArray[2];
    }

    public void battle() {
        if (forestWins == 3) {
            //spiderBattle
        } else if (forestWins == 1) {
            //wolfBattle
        } else if (forestWins == 2) {
            //rousBattle
        } else {
            System.out.println("Dude. You've already killed everything in the forest. Go somewhere else.");
            Crossroads crossroads = new Crossroads(heroArray);
            crossroads.choosePath();
        }
    }
}
