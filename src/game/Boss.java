package game;

import java.util.Random;
import java.util.Scanner;

public class Boss {

    private int healthPoints;

    public Boss() {
        this.healthPoints = 50;
    }

    public int generateAttackValue() {
        Random random = new Random();
        return random.nextInt(11);
    }

    public int getBossHP() {
        return this.healthPoints;
    }

    public void changeBossHP(int amountToChange) {
        this.healthPoints += amountToChange;
    }

    public void stayOrGo(int[] heroArray) {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Welcome to the Great Volcano! It smells like sulfur.");
            System.out.println("What do you want to do?");
            System.out.println("1: Challenge the Boss.");
            System.out.println("2: Leave.");

            String action = scanner.nextLine();

            if (action.equals("1")) {
                BossBattle bossBattle = new BossBattle(heroArray);
                bossBattle.battle();
                break;
            } else if (action.equals("2")) {
                Crossroads crossroads = new Crossroads(heroArray);
                crossroads.choosePath();
                break;
            } else {
                System.out.println("That is not a valid action. Let's try this again.");
            }
        }

    }
}
