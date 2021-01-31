package game;

import java.util.Random;

public class Troll {

    private int healthPoints;

    public Troll() {
        this.healthPoints = 40;
    }

    public int generateAttackValue() {
        Random random = new Random();
        return random.nextInt(26);
    }

    public void changeEnemyHP(int amountToChange) {
        this.healthPoints += amountToChange;
    }

    public int getEnemyHP() {
        return this.healthPoints;
    }
}
