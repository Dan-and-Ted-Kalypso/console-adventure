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

    public void stayOrGo(int[] heroArray, String name) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("");
        System.out.println(ConsoleColors.RED + "               (   (( . : (    .)   ) :  )");
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
        System.out.println("/    ^^^ ___&&& X & &&       ^ ___ %____&& . ^^^^^   `~." + ConsoleColors.RESET);

        System.out.println(ConsoleColors.RED + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);

        System.out.println(ConsoleColors.RED + "Welcome to the Great Volcano! It smells like sulfur." + ConsoleColors.RESET);

        while (true) {

            if (heroArray[1] > (heroArray[11] / 3) + (heroArray[11] / 3)) {
                System.out.printf(ConsoleColors.GREEN + "Your health points: %d.%n" + ConsoleColors.RESET, heroArray[1]);
            } else if (heroArray[1] < (heroArray[11] / 3) + 1) {
                System.out.printf(ConsoleColors.RED + "Your health points: %d.%n" + ConsoleColors.RESET, heroArray[1]);
            } else {
                System.out.printf(ConsoleColors.YELLOW + "Your health points: %d.%n" + ConsoleColors.RESET, heroArray[1]);
            }

            if (heroArray[0] == 0) {
                System.out.printf(ConsoleColors.RED + "Your potion count: %d.%n" + ConsoleColors.RESET, heroArray[0]);
            } else if (heroArray[0] < 3) {
                System.out.printf(ConsoleColors.YELLOW + "Your potion count: %d.%n" + ConsoleColors.RESET, heroArray[0]);
            } else {
                System.out.printf(ConsoleColors.GREEN + "Your potion count: %d.%n" + ConsoleColors.RESET, heroArray[0]);
            }

            System.out.println("Press enter to continue.");

            System.out.println(ConsoleColors.RED + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
            scanner.nextLine();
            System.out.println(ConsoleColors.YELLOW + "What do you want to do?" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED + "1: Challenge the Boss." + ConsoleColors.RESET);
            System.out.println(ConsoleColors.GREEN + "2: Leave." + ConsoleColors.RESET);

            String action = scanner.nextLine();

            if (action.equals("1")) {
                System.out.println(ConsoleColors.YELLOW + "Are you absolutely sure you wish to challenge the evil and mighty Boss?" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.RED + "1: Yes, I am sure! I am a great and mighty hero!" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.GREEN + "2: Err... On second thought, maybe I'll just come back another time..." + ConsoleColors.RESET);
                String confirm = scanner.nextLine();
                if (confirm.equals("1")) {
                    System.out.println(ConsoleColors.RED + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                    System.out.println(ConsoleColors.RED + "Prepare for battle!" + ConsoleColors.RESET);
                    System.out.println("Press enter to continue.");
                    System.out.println(ConsoleColors.RED + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                    scanner.nextLine();
                    BossBattle bossBattle = new BossBattle(heroArray, name);
                    bossBattle.battle();
                    break;
                } else if (confirm.equals("2")) {
                    System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                    Crossroads crossroads = new Crossroads(heroArray, name);
                    crossroads.choosePath();
                    break;
                } else {
                    System.out.println(ConsoleColors.RED + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                    System.out.println("That is not a valid action. Let's try this again.");
                    System.out.println(ConsoleColors.RED + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                }
            } else if (action.equals("2")) {
                System.out.println(ConsoleColors.PURPLE + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                Crossroads crossroads = new Crossroads(heroArray, name);
                crossroads.choosePath();
                break;
            } else {
                System.out.println(ConsoleColors.RED + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
                System.out.println("That is not a valid action. Let's try this again.");
                System.out.println(ConsoleColors.RED + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);
            }
        }
    }
}
