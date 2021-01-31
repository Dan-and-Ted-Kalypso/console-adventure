package game;

import java.util.Random;

public class Rous {

    private int healthPoints;

    public Rous() {
        this.healthPoints = 15;
    }

    public int generateAttackValue() {
        Random random = new Random();
        return random.nextInt(8);
    }

    public void changeEnemyHP(int amountToChange) {
        this.healthPoints += amountToChange;
    }

    public int getEnemyHP() {
        return this.healthPoints;
    }
}
