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
        if (mountainWins == 0) {
            fightOrc();
        } else if (mountainWins == 1) {
            fightTroll();
        } else if (mountainWins == 2) {
            fightUruk();
        } else {
            System.out.println("Dude. You've already killed everything in the mountains. Go somewhere else.");
            Crossroads crossroads = new Crossroads(heroArray);
            crossroads.choosePath();
        }
    }

    public void fightOrc() {
        OrcBattle orcBattle = new OrcBattle(heroArray);
        orcBattle.battle();
    }

    public void fightTroll() {
        TrollBattle trollBattle = new TrollBattle(heroArray);
        trollBattle.battle();
    }

    public void fightUruk() {
        UrukBattle urukBattle = new UrukBattle(heroArray);
        urukBattle.battle();
    }

    /*
    OrcBattle orcBattle new OrcBattle(heroArray);
    orcBattle.battle();

    OrcBattle ->
    new Hero(heroArray);
    new Orc();

    battle() ->
    hit each other until ded


    if dead
    deadMethod();

    if not ded:
    make sure to set HP to current value after battle in heroArray
    get items -> set heroArray
    get level-up? -> set HeroArray


    else choose:

    Mountain mountain = new Mountain();
    mountain.stayOrGo(heroArray)

    OR

    Crossroads crossroads = new Crossroads(heroArray);
    crossroads.choosePath();



    probably need:

    winCount (for levels) -> actually we have that nvm lol

    level element of heroArray

    max HP for healing and levelUp purposes




     */

}
