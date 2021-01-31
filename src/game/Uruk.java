package game;

import java.util.Random;

public class Uruk {

    private int healthPoints;

    public Uruk() {
        this.healthPoints = 45;
    }

    public int generateAttackValue() {
        Random random = new Random();
        return random.nextInt(31);
    }

    public void changeEnemyHP(int amountToChange) {
        this.healthPoints += amountToChange;
    }

    public int getEnemyHP() {
        return this.healthPoints;
    }
}
