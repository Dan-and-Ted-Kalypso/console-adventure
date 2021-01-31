package game;

import java.util.Random;

public class Orc {

    private int healthPoints;

    public Orc() {
        this.healthPoints = 35;
    }

    public int generateAttackValue() {
        Random random = new Random();
        return random.nextInt(24);
    }

    public void changeEnemyHP(int amountToChange) {
        this.healthPoints += amountToChange;
    }

    public int getEnemyHP() {
        return this.healthPoints;
    }
}
