package game;

import java.util.Random;

public class Enemy {

    private int healthPoints;

    public Enemy() {
        this.healthPoints = 20;
    }

    public int generateAttackValue() {
        Random random = new Random();
        return random.nextInt(6);
    }

    public void changeEnemyHP(int amountToChange) {
        this.healthPoints += amountToChange;
    }

    public int getEnemyHP() {
        return this.healthPoints;
    }
}

