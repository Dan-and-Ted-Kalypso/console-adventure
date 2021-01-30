package game;

import java.util.*;


public class Hero {

    private int potionCount;
    private int healthPoints;
    private int forestWins;
    private int desertWins;
    private int mountainWins;
    private int dagger;
    private int scimitar;
    private int battleAxe;
    private int excalibur;
    private int gold;
    private int level;
    private int maxHP;


    public Hero() {

        this.potionCount = 2;
        this.healthPoints = 50;
        this.forestWins = 0;
        this.desertWins = 0;
        this.mountainWins = 0;
        this.dagger = 0;
        this.scimitar = 0;
        this.battleAxe = 0;
        this.excalibur = 0;
        this.gold = 5;
        this.level = 1;
        this.maxHP = 50;
    }

    public Hero(int[] array) {
        this.potionCount = array[0];
        this.healthPoints = array[1];
        this.forestWins = array[2];
        this.desertWins = array[3];
        this.mountainWins = array[4];
        this.dagger = array[5];
        this.scimitar = array[6];
        this.battleAxe = array[7];
        this.excalibur = array[8];
        this.gold = array[9];
        this.level = array[10];
        this.maxHP = array[11];
    }

    public int[] getHero() {
        int[] array = new int[12];
        array[0] = this.potionCount;
        array[1] = this.healthPoints;
        array[2] = this.forestWins;
        array[3] = this.desertWins;
        array[4] = this.mountainWins;
        array[5] = this.dagger;
        array[6] = this.scimitar;
        array[7] = this.battleAxe;
        array[8] = this.excalibur;
        array[9] = this.gold;
        array[10] = this.level;
        array[11] = this.maxHP;
        return array;
    }


    //POTIONS
    public int getPotionCount() {
        return this.potionCount;
    }

    public void changePotionCount(int amountToChange) {
        this.potionCount += amountToChange;
    }

    public void usePotion() {
        if (getPotionCount() == 0) {
            System.out.println("You don't have any potions!");
        } else if (getMaxHP() == getHealthPoints()){
            System.out.println("You are already at full health!");
        } else if (getMaxHP() - getHealthPoints() <= 10) {
            setHPtoMax();
            changePotionCount(-1);
            System.out.printf("You drink the potion. You now have full HP of %d points.%n", getHealthPoints());
            System.out.printf("Potions remaining: %d.%n", getPotionCount());
        } else {
            changeHealthPoints(10);
            changePotionCount(-1);
            System.out.printf("You drink the potion. You now have %d health points.%n", getHealthPoints());
            System.out.printf("Potions remaining: %d.%n", getPotionCount());
        }
    }


    //HEALTH POINTS
    public int getHealthPoints() {
        return this.healthPoints;
    }

    public void changeHealthPoints(int amountToChange) {
        //pass in positive value to add HP, negative to lower it
        this.healthPoints += amountToChange;
    }

    public void setHPtoMax() {
        this.healthPoints = this.maxHP;
    }

    //FOREST WINS
    public int getForestWins() {
        return this.forestWins;
    }

    public void changeForestWins() {
        this.forestWins++;
    }

    //DESERT WINS
    public int getDesertWins() {
        return this.desertWins;
    }

    public void changeDesertWins() {
        this.desertWins++;
    }

    //MOUNTAIN WINS
    public int getMountainWins() {
        return this.mountainWins;
    }

    public void changeMountainWins() {
        this.mountainWins++;
    }

    //DAGGER
    public int getDagger() {
        return this.dagger;
    }

    public void addDagger() {
        this.dagger = 1;
    }

    //SCIMITAR
    public int getScimitar() {
        return this.scimitar;
    }

    public void addScimitar() {
        this.scimitar = 1;
        System.out.println("Nice scimitar, dude.");
    }

    //BATTLEAXE
    public int getBattleAxe() {
        return this.battleAxe;
    }

    public void addBattleAxe() {
        this.battleAxe = 1;
    }

    //EXCALIBUR
    public int getExcalibur() {
        return this.excalibur;
    }

    public void addExcalibur() {
        this.excalibur = 1;
    }

    //GOLD
    public int getGold() {
        return this.gold;
    }

    public void changeGold(int amountToChange) {
        this.gold += amountToChange;
    }

    //LEVEL
    public int getLevel() {
        return this.level;
    }

    public void levelUp() {
        this.level++;
        changeMaxHP(level);
    }

    //MAXHP
    public int getMaxHP() {
        return this.maxHP;
    }

    public void changeMaxHP(int level) {
        if (level == 2) {
            this.maxHP = 60;
        } else if (level == 3) {
            this.maxHP = 70;
        } else {
            this.maxHP = 80;
        }
    }

    /*
    public int generateAttackValue() {
        Random random = new Random();
        if (this.hasSword) {
            return random.nextInt(26);
        }
        return random.nextInt(11);
    }

     */

    public int attemptRun() {
        Random random = new Random();
        return random.nextInt(2);
    }

    public void winBattle(int wins) {
        if (wins == 3) {
            System.out.println("Nice job on killing everything!");
            System.out.println("Sending you back to CR.");
            int[] heroArray = getHero();
            Crossroads crossroads = new Crossroads(heroArray);
            crossroads.choosePath();
        } else {

        }
    }

    public void die() {
        System.out.println("You're dead!");
        System.out.println("Bye!");
    }

}