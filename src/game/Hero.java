package game;

import java.util.*;


public class Hero {

    private int potionCount;
    private int healthPoints;
    private int forestWins;
    private int desertWins;
    private int mountainWins;
    private int dagger;
    private int scimitar;
    private int battleAxe;
    private int excalibur;
    private int gold;
    private int level;
    private int maxHP;
    private final Scanner scanner;
    private final String name;


    public Hero(String name) {

        this.potionCount = 1;
        this.healthPoints = 10;
        this.forestWins = 0;
        this.desertWins = 0;
        this.mountainWins = 0;
        this.dagger = 0;
        this.scimitar = 0;
        this.battleAxe = 0;
        this.excalibur = 0;
        this.gold = 5;
        this.level = 1;
        this.maxHP = 10;
        this.scanner = new Scanner(System.in);
        this.name = name;
    }

    public Hero(int[] array, String name) {
        this.potionCount = array[0];
        this.healthPoints = array[1];
        this.forestWins = array[2];
        this.desertWins = array[3];
        this.mountainWins = array[4];
        this.dagger = array[5];
        this.scimitar = array[6];
        this.battleAxe = array[7];
        this.excalibur = array[8];
        this.gold = array[9];
        this.level = array[10];
        this.maxHP = array[11];
        this.scanner = new Scanner(System.in);
        this.name = name;
    }

    public int[] getHero() {
        int[] array = new int[13];
        array[0] = this.potionCount;
        array[1] = this.healthPoints;
        array[2] = this.forestWins;
        array[3] = this.desertWins;
        array[4] = this.mountainWins;
        array[5] = this.dagger;
        array[6] = this.scimitar;
        array[7] = this.battleAxe;
        array[8] = this.excalibur;
        array[9] = this.gold;
        array[10] = this.level;
        array[11] = this.maxHP;
        return array;
    }


    //POTIONS
    public int getPotionCount() {
        return this.potionCount;
    }

    public void changePotionCount(int amountToChange) {
        this.potionCount += amountToChange;
    }

    public void usePotion() {
        if (getPotionCount() == 0) {
            System.out.println("You don't have any potions!");
            System.out.println("Press enter to continue.");
            scanner.nextLine();
        } else if (getMaxHP() == getHealthPoints()) {
            System.out.println("You are already at full health!");
            System.out.println("Press enter to continue.");
            scanner.nextLine();
        } else {
            if (getLevel() == 4) {
                if (getMaxHP() - getHealthPoints() <= 20) {
                    setHPtoMax();
                    changePotionCount(-1);
                    System.out.printf("You drink the potion. You now have full HP of %d points.%n", getHealthPoints());
                    System.out.println("Press enter to continue.");
                    scanner.nextLine();
                } else {
                    changeHealthPoints(20);
                    changePotionCount(-1);
                    System.out.printf("You drink the potion. You now have %d health points.%n", getHealthPoints());
                    System.out.println("Press enter to continue.");
                    scanner.nextLine();
                }
                System.out.printf("Potions remaining: %d.%n", getPotionCount());
            } else if (getLevel() == 3) {
                if (getMaxHP() - getHealthPoints() <= 15) {
                    setHPtoMax();
                    changePotionCount(-1);
                    System.out.printf("You drink the potion. You now have full HP of %d points.%n", getHealthPoints());
                    System.out.println("Press enter to continue.");
                    scanner.nextLine();
                } else {
                    changeHealthPoints(15);
                    changePotionCount(-1);
                    System.out.printf("You drink the potion. You now have %d health points.%n", getHealthPoints());
                    System.out.println("Press enter to continue.");
                    scanner.nextLine();
                }
                System.out.printf("Potions remaining: %d.%n", getPotionCount());
            } else if (getLevel() == 2) {
                if (getMaxHP() - getHealthPoints() <= 10) {
                    setHPtoMax();
                    changePotionCount(-1);
                    System.out.printf("You drink the potion. You now have full HP of %d points.%n", getHealthPoints());
                    System.out.println("Press enter to continue.");
                    scanner.nextLine();
                } else {
                    changeHealthPoints(10);
                    changePotionCount(-1);
                    System.out.printf("You drink the potion. You now have %d health points.%n", getHealthPoints());
                    System.out.println("Press enter to continue.");
                    scanner.nextLine();
                }
                System.out.printf("Potions remaining: %d.%n", getPotionCount());
                System.out.println("Press enter to continue.");
                scanner.nextLine();
            } else {
                if (getMaxHP() - getHealthPoints() <= 5) {
                    setHPtoMax();
                    changePotionCount(-1);
                    System.out.printf("You drink the potion. You now have full HP of %d points.%n", getHealthPoints());
                    System.out.println("Press enter to continue.");
                    scanner.nextLine();
                } else {
                    changeHealthPoints(5);
                    changePotionCount(-1);
                    System.out.printf("You drink the potion. You now have %d health points.%n", getHealthPoints());
                    System.out.println("Press enter to continue.");
                    scanner.nextLine();
                }
                System.out.printf("Potions remaining: %d.%n", getPotionCount());
                System.out.println("Press enter to continue.");
                scanner.nextLine();
            }


        }
    }


    //HEALTH POINTS
    public int getHealthPoints() {
        return this.healthPoints;
    }

    public void changeHealthPoints(int amountToChange) {
        //pass in positive value to add HP, negative to lower it
        this.healthPoints += amountToChange;
    }

    public void setHPtoMax() {
        this.healthPoints = this.maxHP;
    }

    //FOREST WINS
    public int getForestWins() {
        return this.forestWins;
    }

    public void changeForestWins() {
        this.forestWins++;
    }

    //DESERT WINS
    public int getDesertWins() {
        return this.desertWins;
    }

    public void changeDesertWins() {
        this.desertWins++;
    }

    //MOUNTAIN WINS
    public int getMountainWins() {
        return this.mountainWins;
    }

    public void changeMountainWins() {
        this.mountainWins++;
    }

    //DAGGER
    public int getDagger() {
        return this.dagger;
    }

    public void addDagger() {
        this.dagger = 1;
    }

    //SCIMITAR
    public int getScimitar() {
        return this.scimitar;
    }

    public void addScimitar() {
        this.scimitar = 1;
    }

    //BATTLEAXE
    public int getBattleAxe() {
        return this.battleAxe;
    }

    public void addBattleAxe() {
        this.battleAxe = 1;
    }

    //EXCALIBUR
    public int getExcalibur() {
        return this.excalibur;
    }

    public void addExcalibur() {
        this.excalibur = 1;
    }

    //GOLD
    public int getGold() {
        return this.gold;
    }

    public void changeGold(int amountToChange) {
        this.gold += amountToChange;
    }

    //LEVEL
    public int getLevel() {
        return this.level;
    }

    public void levelUp() {
        this.level++;
        changeMaxHP(level);
    }

    //MAXHP
    public int getMaxHP() {
        return this.maxHP;
    }

    public void changeMaxHP(int level) {
        if (level == 2) {
            this.maxHP = 25;
        } else if (level == 3) {
            this.maxHP = 40;
        } else {
            this.maxHP = 50;
        }
    }


    public int generateAttackValue() {
        Random random = new Random();
        int[] heroArray = getHero();
        if(heroArray[8] == 1) {
            int value = random.nextInt(41);
            if (value > 0) {
                value += 5;
                return value;
            } else {
                return 0;
            }
        } else if (heroArray[7] == 1) {
            int value = random.nextInt(31);
            if (value > 0) {
                value += 4;
                return value;
            } else {
                return 0;
            }
        } else if (heroArray[6] == 1) {
            int value = random.nextInt(16);
            if (value > 0) {
                value += 4;
                return value;
            } else {
                return 0;
            }
        } else if (heroArray[5] == 1) {
            int value = random.nextInt(8);
            if (value > 0) {
                value += 3;
                return value;
            } else {
                return 0;
            }
        }
        int value = random.nextInt(6);
        if (value > 0) {
            value += 2;
            return value;
        }
        return 0;
    }


    public int attemptRun() {
        Random random = new Random();
        return random.nextInt(2);
    }


    public void die() {

        System.out.println("");

        System.out.println(ConsoleColors.RED + "                                                               _");
        System.out.println("                                                              _( (~\\");
        System.out.println("       _ _                        /                          ( \\> > \\");
        System.out.println("   -/~/ / ~\\                     :;                \\       _  > /(~\\/");
        System.out.println("  || | | /\\ ;\\                   |l      _____     |;     ( \\/    > >");
        System.out.println("  _\\\\)\\)\\)/ ;;;                  `8o __-~     ~\\   d|      \\      //");
        System.out.println(" ///(())(__/~;;\\                  \"88p;.  -. _\\_;.oP        (_._/ /");
        System.out.println("(((__   __ \\\\   \\                  `>,% (\\  (\\./)8\"         ;:'  i");
        System.out.println(")))--`.'-- (( ;,8 \\               ,;%%%:  ./V^^^V'          ;.   ;.");
        System.out.println("((\\   |   /)) .,88  `: ..,,;;;;,-::::::'_::\\   ||\\         ;[8:   ;");
        System.out.println(" )|  ~-~  |(|(888; ..``'::::8888oooooo.  :\\`^^^/,,~--._    |88::  |");
        System.out.println(" |\\ -===- /|  \\8;; ``:.      oo.8888888888:`((( o.ooo8888Oo;:;:'  |");
        System.out.println(" |_~-___-~_|   `-\\.   `        `o`88888888b` )) 888b88888P\"\"'     ;");
        System.out.println(" ; ~~~~;~~         \"`--_`.       b`888888888;(.,\"888b888\"  ..::;-'");
        System.out.println("   ;      ;              ~\"-....  b`8888888:::::.`8888. .:;;;''");
        System.out.println("      ;    ;                 `:::. `:::OOO:::::::.`OO' ;;;''");
        System.out.println(" :       ;                     `.      \"``::::::''    .'");
        System.out.println("    ;                           `.   \\_              /");
        System.out.println("  ;       ;                       +:   ~~--  `:'  -';");
        System.out.println("                                   `:         : .::/");
        System.out.println("      ;                            ;;+_  :::. :..;;;");
        System.out.println("                                   ;;;;;;,;;;;;;;;,;" + ConsoleColors.RESET);

        System.out.println(ConsoleColors.RED + "____________________________________________________________________________________________________________" + ConsoleColors.RESET);

        System.out.println(ConsoleColors.YELLOW + "You're dead!" + ConsoleColors.RESET);
        System.out.printf(ConsoleColors.RED + "Game Over %s!%n" + ConsoleColors.RESET, name);
    }
}
