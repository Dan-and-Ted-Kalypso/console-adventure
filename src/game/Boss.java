package game;

public class Boss {

    private int healthPoints;

    private int attackCounter;

    public Boss() {
        this.healthPoints = 150;
        this.attackCounter = 0;
    }

    public int generateAttackValue() {
        return (int) ((Math.random() * (10 - 5)) + 5);
    }

    public int specialAttackValue() {return (int) ((Math.random() * (20 - 10)) + 10);}

    public int bossHeal() {return (int) ((Math.random() * (20 - 10)) + 10);}

    public int getBossHP() {
        return this.healthPoints;
    }

    public void changeBossHP(int amountToChange) {
        this.healthPoints += amountToChange;
    }

    public int getBossAttackCounter() {return this.attackCounter;}

    public void changeAttackCounter(int amountToChange) {this.attackCounter += amountToChange;}
}
