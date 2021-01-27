package game;

import java.util.ArrayList;
import java.util.List;

public class Hero {

    public int heroPotion;
    public int healthPoints;
    public String heroName;
    public List<String> inv = new ArrayList<String>();


    public Hero(String name) {

        this.healthPoints = 50;
        this.heroName = name;
        this.heroPotion = 2;
        this.inv.add("Nothing");
    }


}