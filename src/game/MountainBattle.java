package game;

import java.util.*;

public class MountainBattle {

    private int[] heroArray;
    private int mountainWins;

    public MountainBattle(int[] heroArray) {
        this.heroArray = heroArray;
        this.mountainWins = heroArray[4];
    }

    public void battle() {
        if (mountainWins == 3) {
            //orcBattle
        } else if (mountainWins == 1) {
            //trollBattle
        } else if (mountainWins == 2) {
            //urukBattle
        } else {
            System.out.println("Dude. You've already killed everything in the mountains. Go somewhere else.");
            Crossroads crossroads = new Crossroads(heroArray);
            crossroads.choosePath();
        }
    }

    public void orcBattle() {
        Orc orc = new Orc();
    }

}


