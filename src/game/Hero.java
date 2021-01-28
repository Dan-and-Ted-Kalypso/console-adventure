package game;

public class Hero {

    public int potionCount;
    public int healthPoints;
    public String heroName;
    public int winCounter;
    public boolean isCoward;
    public boolean hasSword;
    public boolean defeatedBoss;

    public Hero(String name) {

        this.healthPoints = 50;
        this.heroName = name;
        this.potionCount = 2;
        this.winCounter = 0;
        this.isCoward = false;
        this.hasSword = false;
        this.defeatedBoss = false;
    }

    public int attack(boolean sword) {
        hasSword = sword;
        if (hasSword) {
            return (int) ((Math.random() * (50 - 5)) + 5);
        }
        return (int) ((Math.random() * (100 - 50)) + 50);
    }

    public void usePotion() {
        if (potionCount > 0) {
            healthPoints += 10;
            potionCount -= 1;
            System.out.printf("You now have %d HP remaining. Potions remaining: %d%n", healthPoints, potionCount);
        } else {
            System.out.println("You don't have any potions left!");
        }
    }

}