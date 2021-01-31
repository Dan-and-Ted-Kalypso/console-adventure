package game;

import java.util.Random;

public class Mummy {

    private int healthPoints;

    public Mummy() {
        this.healthPoints = 30;
    }

    public int generateAttackValue() {
        Random random = new Random();
        return random.nextInt(19);
    }

    public void changeEnemyHP(int amountToChange) {
        this.healthPoints += amountToChange;
    }

    public int getEnemyHP() {
        return this.healthPoints;
    }
}
