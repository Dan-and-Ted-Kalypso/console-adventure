package game;

import java.util.Random;

public class Spider {

    private int healthPoints;

    public Spider() {
        this.healthPoints = 5;
    }

    public int generateAttackValue() {
        Random random = new Random();
        return random.nextInt(4);
    }

    public void changeEnemyHP(int amountToChange) {
        this.healthPoints += amountToChange;
    }

    public int getEnemyHP() {
        return this.healthPoints;
    }
}
