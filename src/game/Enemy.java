package game;

public class Enemy {

    private int healthPoints;

    public Enemy() {
        this.healthPoints = 20;
    }

    public int generateAttackValue() {
        return (int) ((Math.random() * (5 - 1)) + 1);
    }

    public void changeEnemyHP(int amountToChange) {
        this.healthPoints += amountToChange;
    }

    public int getEnemyHP() {
        return this.healthPoints;
    }
}

