package game;

import java.util.Random;

public class Scorpion {

    private int healthPoints;

    public Scorpion() {
        this.healthPoints = 25;
    }

    public int generateAttackValue() {
        Random random = new Random();
        return random.nextInt(16);
    }

    public void changeEnemyHP(int amountToChange) {
        this.healthPoints += amountToChange;
    }

    public int getEnemyHP() {
        return this.healthPoints;
    }
}
