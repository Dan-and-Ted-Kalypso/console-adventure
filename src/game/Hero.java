package game;

import java.util.Random;

public class Hero {

    private int potionCount;
    private int healthPoints;
    private int winCounter;
    private boolean offBalance;
    private boolean isPrepared;
    private boolean isCoward;
    private boolean hasSword;
    private boolean defeatedBoss;

    public Hero() {

        this.healthPoints = 50;
        this.potionCount = 2;
        this.winCounter = 0;
        this.offBalance = false;
        this.isPrepared = false;
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

    public boolean isOffBalance() {return this.offBalance;}

    public void setOffBalance(boolean state) {this.offBalance = state;}

    public void setPrepared(boolean state) {this.isPrepared = state;}

    public boolean isPrepared() {return this.isPrepared;}

    public int generateRecklessAttack() {
        Random random = new Random();
        int chanceOfOffBalance = random.nextInt(2);
        if (chanceOfOffBalance == 0) {this.setOffBalance(true);}
        return (int)Math.round(generateAttackValue() * 1.5);
        }


    public int generateCarefulAttack() {
        this.setPrepared(true);
        return (int)Math.round(generateAttackValue()*.5);
    }

    public double damageModifier() {
        if (this.isPrepared() && this.isOffBalance()) {return 1;}
        if (this.isPrepared()) {return .5;}
        else if (this.isOffBalance()) {return 1.5;}
        else {return 1;}
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