package game;

import java.util.Random;

public class Wolf {

    private int healthPoints;

    public Wolf() {
        this.healthPoints = 10;
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
