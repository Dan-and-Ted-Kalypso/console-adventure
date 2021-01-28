package game;

public class Boss {

    public int healthPoints;

    public Boss() {
        this.healthPoints = 50;
    }

    public int attack() {
        return (int) ((Math.random() * (10 - 5)) + 5);
    }
}
