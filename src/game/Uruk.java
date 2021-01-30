package game;

import java.util.Random;

public class Uruk {

    private int healthPoints;

    public Uruk() {
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
