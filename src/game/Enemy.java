package game;

public class Enemy {

    public int healthPoints;

    public Enemy() {
        this.healthPoints = 20;
    }

    public int attack() {
        return (int) ((Math.random() * (5 - 1)) + 1);
    }
}

