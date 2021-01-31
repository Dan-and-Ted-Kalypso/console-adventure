package game;

import java.util.Random;

public class Snake {

    private int healthPoints;

    public Snake() {
        this.healthPoints = 20;
    }

    public int generateAttackValue() {
        Random random = new Random();
        return random.nextInt(11);
    }

    public void changeEnemyHP(int amountToChange) {
        this.healthPoints += amountToChange;
    }

    public int getEnemyHP() {
        return this.healthPoints;
    }
}
