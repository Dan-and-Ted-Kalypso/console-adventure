package game;

import java.util.*;


public class Hero {

    private int potionCount;
    private int healthPoints;
    private int winCounter;
    private boolean isCoward;
    private boolean hasSword;
    private boolean defeatedBoss;
    private int forestWins;
    private int desertWins;
    private int mountainWins;
    private int dagger;
    private int scimitar;
    private int battleAxe;
    private int excalibur;


    public Hero(int[] array) {
        this.potionCount = array[0];
        this.healthPoints = array[1];
        this.forestWins = array[2];
        this.desertWins = array[3];
        this.mountainWins = array[4];
        this.isCoward = array[5] == 1;
        this.defeatedBoss = array[6] == 1;
        this.dagger = array[7];
        this.scimitar = array[8];
        this.battleAxe = array[9];
        this.excalibur = array[10];
    }

    public int[] getHero() {
        int[] array = new int[11];
        array[0] = this.potionCount;
        array[1] = this.healthPoints;
        array[2] = this.forestWins;
        array[3] = this.desertWins;
        array[4] = this.mountainWins;
        if (this.isCoward) {
            array[5] = 1;
        } else {
            array[5] = 0;
        }
        if (this.defeatedBoss) {
            array[6] = 1;
        } else {
            array[6] = 0;
        }
        array[7] = this.dagger;
        array[8] = this.scimitar;
        array[9] = this.battleAxe;
        array[10] = this.excalibur;
        return array;
    }

    public Hero() {

        this.healthPoints = 50;
        this.potionCount = 2;
        this.winCounter = 0;
        this.isCoward = false;
        this.hasSword = false;
        this.defeatedBoss = false;
        this.forestWins = 0;
        this.desertWins = 0;
        this.mountainWins = 0;
        this.dagger = 0;
        this.scimitar = 0;
        this.battleAxe = 0;
        this.excalibur = 0;
    }


    public int getHealthPoints() {
        return this.healthPoints;
    }

    public void changeHealthPoints(int amountToChange) {
        //pass in positive value to add HP, negative to lower it
        this.healthPoints += amountToChange;
    }


    public int getPotionCount() {
        return this.potionCount;
    }

    public void changePotionCount(int amountToChange) {
        this.potionCount += amountToChange;
    }




    public int generateAttackValue() {
        Random random = new Random();
        if (this.hasSword) {
            return random.nextInt(26);
        }
        return random.nextInt(11);
    }

    public void usePotion() {
        if (getPotionCount() > 0) {
            changeHealthPoints(10);
            changePotionCount(-1);
            System.out.printf("You now have %d HP remaining. Potions remaining: %d%n", getHealthPoints(), getPotionCount());
        } else {
            System.out.println("You don't have any potions left!");
        }
    }



    public void giveSword() {
        this.hasSword = true;
    }

    public int getWinCounter() {
        return this.winCounter;
    }

    public void addWin() {
        this.winCounter++;
    }

    public boolean isCoward() {
        return this.isCoward;
    }

    public void runAway() {
        this.isCoward = true;
    }

    public boolean isDefeatedBoss() {
        return this.defeatedBoss;
    }

    public void defeatBoss() {
        this.defeatedBoss = true;
    }


}