package game;

import java.util.*;

public class ForestBattle {

    private final int[] heroArray;
    private final int forestWins;
    private final Scanner scanner;
    private final String name;

    public ForestBattle(int[] heroArray, String name) {
        this.heroArray = heroArray;
        this.forestWins = heroArray[2];
        this.scanner = new Scanner(System.in);
        this.name = name;
    }

    public void battle() {
        if (forestWins == 0) {
            fightSpider();
        } else if (forestWins == 1) {
            fightWolf();
        } else if (forestWins == 2) {
            fightRous();
        } else {
            System.out.println(ConsoleColors.RED + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.YELLOW + "Dude. You've already killed everything in the forest. Go somewhere else." + ConsoleColors.RESET);
            System.out.println("Press enter to continue.");
            scanner.nextLine();
            System.out.println(ConsoleColors.RED + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
            Crossroads crossroads = new Crossroads(heroArray, name);
            crossroads.choosePath();
        }
    }

    public void fightSpider() {
        SpiderBattle spiderBattle = new SpiderBattle(heroArray, name);
        spiderBattle.battle();
    }

    public void fightWolf() {
        WolfBattle wolfBattle = new WolfBattle(heroArray, name);
        wolfBattle.battle();
    }

    public void fightRous() {
        RousBattle rousBattle = new RousBattle(heroArray, name);
        rousBattle.battle();
    }


}
