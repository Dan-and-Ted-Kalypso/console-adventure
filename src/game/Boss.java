package game;

import java.util.Random;

public class Boss {

    private int healthPoints;

    public Boss() {
        this.healthPoints = 50;
    }

    public int generateAttackValue() {
        Random random = new Random();
        return random.nextInt(11);
    }

    public int getBossHP() {
        return this.healthPoints;
    }

    public void changeBossHP(int amountToChange) {
        this.healthPoints += amountToChange;
    }
}
