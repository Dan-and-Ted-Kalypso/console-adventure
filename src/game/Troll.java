package game;

import java.util.Random;

public class Troll {

    private int healthPoints;

    public Troll() {
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
