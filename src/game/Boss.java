package game;

public class Boss {

    private int healthPoints;

    public Boss() {
        this.healthPoints = 50;
    }

    public int generateAttackValue() {
        return (int) ((Math.random() * (10 - 5)) + 5);
    }

    public int getBossHP() {
        return this.healthPoints;
    }

    public void changeBossHP(int amountToChange) {
        this.healthPoints += amountToChange;
    }
}
