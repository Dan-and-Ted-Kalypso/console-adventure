package game;

import java.util.Random;

public class Hero {

    private int potionCount;
    private int healthPoints;
    private int winCounter;
    private boolean isCoward;
    private boolean hasSword;
    private boolean defeatedBoss;

    public Hero() {

        this.healthPoints = 50;
        this.potionCount = 2;
        this.winCounter = 0;
        this.isCoward = false;
        this.hasSword = false;
        this.defeatedBoss = false;
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