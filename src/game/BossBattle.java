package game;

import java.util.Scanner;

public class BossBattle {

    private int[] heroArray;
    private Hero hero;
    private Boss boss;
    private Scanner scanner;


    public BossBattle(int[] heroArray) {
        this.heroArray = heroArray;
        this.hero = new Hero(heroArray);
        this.boss = new Boss();
        this.scanner = new Scanner(System.in);

    }

    public void battle() {

        System.out.println("                                                           /\\");
        System.out.println("                                                          //\\\\");
        System.out.println("                                                         <<()>>     A");
        System.out.println("                                                          |==|     /\\\\");
        System.out.println("                                                          |  |    /  \\\\");
        System.out.println("                                                          |  |   /    \\\\");
        System.out.println("                                                       A  |  |  /      \\\\");
        System.out.println("                                                      //\\_|  |_/        \\\\");
        System.out.println("                                                     //   |  |           \\\\");
        System.out.println("            _.'          .                          //    |  |    //\\\\    \\\\");
        System.out.println("           |P`            ?\\                       (( <0> |  |   <<()>>    ))");
        System.out.println("          .\"h              \"B                       \\\\    |  |    \\\\//    //");
        System.out.println("          ?\"\"\",          .\"\"P                        \\\\  _|  |_          //");
        System.out.println("          (\"\"h             \"P                         \\\\/ |  | \\        //");
        System.out.println("          {\"``\"\"oo____oo\"\"\"\"P                          V  |  |  \\      //");
        System.out.println("           '\"\"888888888888,;                              |  |   \\    //");
        System.out.println("            `?88P^\\,?88^\\,Y                               |  |    \\  //");
        System.out.println("              88?\\__d88\\_/'                               |  |     \\//");
        System.out.println("              `8o8888/\\88P                                |  |      V");
        System.out.println("               ,?oo88oo8P                                 |  |");
        System.out.println("     ___  __===~88~\\\\\\\\\\|~====__ __       ___             |  |");
        System.out.println(" .-==ooo~odoooob ?8/////'oooood88888ooo?P88888?ooo?888PooooOoooo;)");
        System.out.println("d,d8888obo8,oo8b,``~~~,o?8oo,8888**8P88?8`oo,o888?898o8P888P~8b8;)");
        System.out.println("8o88888oP?.,,ooood8b,.oo.,oo88?o8888P^^^?8888P^^^^==+=~~~?8bo?PP;)");
        System.out.println("?8.=~=.8do.,oo88888ooo,o,oo88888o,;                       |  |");
        System.out.println(".?*o88ob`8.,o88888888oo,o,o88888o,'                       |  |");
        System.out.println("|*o8888o`8,oo88888888oo,o,o?8888o'                        |  |");
        System.out.println("`?o8888P`88,,oo88888oo,,.,oo88oo;                         |  |");
        System.out.println(".8`o888'**888oo,,,,oood88oo,,d8'                          |  |");
        System.out.println("doo,,oP  ?888o,,o8o,o8o,,,o8oo'                           |  |");
        System.out.println("8od8bo'  `?88o,,o8o,o88o,.,o,o'                           |  |");
        System.out.println("8o888o    `88o,,o8o,o8o,.,o,o'                            |  |");
        System.out.println("?o888P     ===========<666>==                             |  |");
        System.out.println("`?88P     ********************                            |  |");
        System.out.println(" ?ooPb   ',odoo,************,b                            |  |");
        System.out.println("d{{{{b\\,(,oo88ooo,,********,oob                           |  |");
        System.out.println("OOOOO \\\\,oo8888ooo,,******,o888,                          |  |");
        System.out.println("(\\\\\\\\ ||,o8888888oo,,*****,o88o)                          |  |");
        System.out.println("  \\\\\\\\/`,o8888888oo',*****,888o|                          |  |");
        System.out.println("        `oo8888888o',*****,888o|                          |  |");
        System.out.println("        `,o888888oo,,*****,o8oo'                          |  |");
        System.out.println("        `,o88888oo,, *****,o8oP                           |  |");
        System.out.println("        `?,o888oP,,  *****,ooP                            |  |");
        System.out.println("         `8-==-P,    |****,,-='                           |  |");
        System.out.println("          ?o88oP     |*'d*,o88                            |  |");
        System.out.println("         .dboodb.     *;8*,o88                            |  |");
        System.out.println("         ,od88boo     *,o*,o88'                           |  |");
        System.out.println("         do8888ob     *`o*,o8P                            |  |");
        System.out.println("         ?o8888oP     |`,|,oo'                            |  |");
        System.out.println("         `o8888o'     `?o8oP                              |  |");
        System.out.println("          `o88o'      ,o88o'                              |  |");
        System.out.println("           ?ooP       `?88o'                              |  |");
        System.out.println("          dooo'b      'o88oo,.                            |  |");
        System.out.println("         '?o===o   ~-=8oo888888oo.__                      |  |");
        System.out.println("         8888888     `~~~' `==~~~=-,'                   _ |__| _");
        System.out.println("         ?8P?88P");
        System.out.println("          V''V'");

        System.out.println("");

        System.out.println("So it begins. The great battle of our time...");
        label:
        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("1: Attack.");
            System.out.println("2: Drink potion.");
            System.out.println("3: Run.");
            String action = scanner.nextLine();

            switch (action) {
                case "1":
                    int attackValue = hero.generateAttackValue();
                    if (attackValue == 0) {
                        System.out.println("Your attack missed!");
                    } else {
                        boss.changeEnemyHP(attackValue * -1);
                        System.out.printf("You hit the boss for %d points!%n", attackValue);
                    }
                    if (boss.getEnemyHP() <= 0) {
                        System.out.println("The boss has 0 health points remaining!");
                        winBossBattle();
                        break label;
                    } else {
                        System.out.printf("The boss has %d health points remaining.%n", boss.getEnemyHP());
                        int enemyAttackValue = boss.generateAttackValue();
                        if (enemyAttackValue == 0) {
                            System.out.println("The boss' attack missed! Whew!");
                        } else {
                            hero.changeHealthPoints(enemyAttackValue * -1);
                            System.out.printf("The boss hits you for %d points! Ouch!%n", enemyAttackValue);
                        }
                        if (hero.getHealthPoints() <= 0) {
                            System.out.println("You have no health points remaining! Oh no!");
                            hero.die();
                            break label;
                        } else {
                            System.out.printf("You have %d health points remaining.%n", hero.getHealthPoints());
                        }
                    }


                    break;
                case "2":

                    hero.usePotion();

                    break;
                case "3":
                    System.out.println("You can't run away! This is the BOSS BATTLE, ya dingus!");
                    break;
                default:
                    System.out.println("That is not a valid action. Let's try this again.");
                    break;
            }
        }
    }

    public void winBossBattle() {
        System.out.println("You have defeated the great and powerful boss and ended his reign of tyranny o'er this land!");
        System.out.println("Your name will surely go down in the annals of history!");
    }
}


/*





 */