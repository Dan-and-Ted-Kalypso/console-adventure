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
        int initial = random.nextInt(10);
        if (initial == 9) {
            return 32;
        } else if (initial > 3) {
            int secondary = random.nextInt(6);
            return (25 - secondary);
        }
        return random.nextInt(16);
    }

    public int getEnemyHP() {
        return this.healthPoints;
    }

    public void changeEnemyHP(int amountToChange) {
        this.healthPoints += amountToChange;
    }

    public void stayOrGo(int[] heroArray) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("");
        System.out.println("               (   (( . : (    .)   ) :  )");
        System.out.println("                (   ( :  .  :    :  )  ))");
        System.out.println("                 ( ( ( (  .  :  . . ) )");
        System.out.println("                  ( ( : :  :  )   )  )");
        System.out.println("                   ( :(   .   .  ) .'");
        System.out.println("                    '. :(   :    )");
        System.out.println("                      (   :  . )  )");
        System.out.println("                      ')   :   #@");
        System.out.println("                      #',### \" #@#@");
        System.out.println("                     #/ @'#~@#~/\\ @#");
        System.out.println("                   ##  @@# @##@  `..@,");
        System.out.println("                 @#/  #@#   _##     `\\");
        System.out.println("               @##;  `#~._.' ##@      \\_");
        System.out.println("             .-#/           @#@#@--,_,--\\");
        System.out.println("            / `@#@..,     .~###'         `~.");
        System.out.println("          _/         `-.-' #@####@          \\");
        System.out.println("       __/     &^^       ^#^##~##&&&   %     \\_");
        System.out.println("      /       && ^^      @#^##@#%%#@&&&&  ^    \\");
        System.out.println("    ~/         &&&    ^^^   ^^   &&&  %%% ^^^   `~._");
        System.out.println(" .-'   ^^    %%%. &&   ___^     &&   && &&   ^^     \\");
        System.out.println("/    ^^^ ___&&& X & &&       ^ ___ %____&& . ^^^^^   `~.");

        System.out.println("");

        System.out.println("Welcome to the Great Volcano! It smells like sulfur.");

        while (true) {


            System.out.printf("Your health points: %d.%n", heroArray[1]);
            System.out.printf("Your potion count: %d.%n", heroArray[0]);
            System.out.println("Press enter to continue.");
            scanner.nextLine();
            System.out.println("What do you want to do?");
            System.out.println("1: Challenge the Boss.");
            System.out.println("2: Leave.");

            String action = scanner.nextLine();

            if (action.equals("1")) {
                System.out.println("Are you absolutely sure you wish to challenge the evil and mighty Boss?");
                System.out.println("1: Yes, I am sure! I am a great and mighty hero!");
                System.out.println("2: Err... On second thought, maybe I'll just come back another time...");
                String confirm = scanner.nextLine();
                if (confirm.equals("1")) {
                    System.out.println("Prepare for battle!");
                    System.out.println("Press enter to continue.");
                    scanner.nextLine();
                    BossBattle bossBattle = new BossBattle(heroArray);
                    bossBattle.battle();
                    break;
                } else if (confirm.equals("2")) {
                    Crossroads crossroads = new Crossroads(heroArray);
                    crossroads.choosePath();
                    break;
                } else {
                    System.out.println("That is not a valid action. Let's try this again.");
                    System.out.println("");
                }
            } else if (action.equals("2")) {
                Crossroads crossroads = new Crossroads(heroArray);
                crossroads.choosePath();
                break;
            } else {
                System.out.println("That is not a valid action. Let's try this again.");
                System.out.println("");
            }
        }
    }
}
