package game;

import java.util.Scanner;

public class Game {

    protected Hero hero;
    protected Scanner scanner;

    public void beginGame() {
        this.scanner = new Scanner(System.in);
        System.out.println("Welcome to your adventure! What is your name?");
        Scanner nameScanner = new Scanner(System.in);
        String name = nameScanner.nextLine();
        if (name.isEmpty()) {
            System.out.println("Don't want to tell me your name? Ok then. I shall call you Bartholomew!");
            System.out.println("Hello, Bartholomew! You are about to embark on a wild journey of heroism and chivalry! Let's begin!");
        } else {
            System.out.printf("Hello, %s! You are about to embark on a wild journey of heroism and chivalry! Let's begin!%n", name);
        }

        goToCrossroads();

    }


    public void goToCrossroads() {
        Crossroads crossroads = new Crossroads();
        crossroads.choosePath();
    }



    //every time you go back to main, choosePath gets run
    //then,
/*
    public void confirmPath(String path) {
        label:
        while (true) {
            String confirm = scanner.nextLine();
            switch (path) {
                case "4":
                    System.out.println("Are you sure you wish to go to The Great Volcano? The evil boss lives there and you may be squashed like a tiny ant if you are not fully ready to face him. Type continue to go forward anyway or back to choose a different path.");
                    if (confirm.equalsIgnoreCase("confirm")) {
                        //method to go to Volcano
                    } else if (confirm.equalsIgnoreCase("back")) {
                        choosePath();
                        break label;
                    } else {
                        System.out.println("That is not a valid choice. Please enter \"continue\" or \"back\". Let's try this again, shall we?");
                        confirmPath("4");
                    }
                    break;
                case "3":
                    System.out.println("Are you sure you wish to travel to the mountains? The enemies there are very challenging. Type continue to go forward anyway or back to choose a different path.");
                    if (confirm.equalsIgnoreCase("confirm")) {
                        goToMountain();
                        break label;
                    } else if (confirm.equalsIgnoreCase("back")) {
                        choosePath();
                        break label;
                    } else {
                        System.out.println("That is not a valid choice. Please enter \"continue\" or \"back\". Let's try this again, shall we?");
                        confirmPath("3");
                    }
                    break;
                case "2":
                    System.out.println("Are you sure you wish to travel to the desert? The enemies there are somewhat challenging. Type continue to go forward anyway or back to choose a different path.");
                    if (confirm.equalsIgnoreCase("confirm")) {
                        //method to go to desert
                    } else if (confirm.equalsIgnoreCase("back")) {
                        choosePath();
                        break label;
                    } else {
                        System.out.println("That is not a valid choice. Please enter \"continue\" or \"back\". Let's try this again, shall we?");
                        confirmPath("2");
                    }
                    break;
                case "1":
                    System.out.println("Are you sure you wish to travel to the forest? The enemies there are fairly easy and a good way for a novice adventurer to gain experience. Type continue to go forward anyway or back to choose a different path.");
                    if (confirm.equalsIgnoreCase("confirm")) {
                        //method to go to forest
                    } else if (confirm.equalsIgnoreCase("back")) {
                        choosePath();
                        break label;
                    } else {
                        System.out.println("That is not a valid choice. Please enter \"continue\" or \"back\". Let's try this again, shall we?");
                        confirmPath("1");
                    }
                    break;
                default:
                    System.out.println("Are you sure you wish to travel to The Inn? Here you can rest up and recharge your health points.");
                    if (confirm.equalsIgnoreCase("confirm")) {
                        //method to go to forest
                    } else if (confirm.equalsIgnoreCase("back")) {
                        choosePath();
                        break label;
                    } else {
                        System.out.println("That is not a valid choice. Please enter \"continue\" or \"back\". Let's try this again, shall we?");
                        confirmPath("0");
                    }
                    break;
            }
        }

    }



    public void playGame() {
        choosePath();

    }

 */
    /*
    Choose a path:

    Desert
    Woods
    Mountains

    Desert:
    Scorpion
    Mummy
    Snake

    Woods:
    Rodent of Unusual Size (ROUS)
    Spider
    Direwolf



    Mountains:
    Orc
    Troll
    Uruk-Hai




     */

    /*
    public void battle() {
        if (this.hero.getWinCounter() < 3) {
            System.out.println("A challenger approaches! fight/run?");
            while (true) {
                String fightRun = scanner.nextLine();
                if (fightRun.equalsIgnoreCase("fight")) {
                    System.out.println("Let the battle begin!");
                    battleLoop();
                    break;
                } else if (fightRun.equalsIgnoreCase("run")) {
                    this.hero.runAway();
                    System.out.println("You are a coward and unworthy of the title of hero. game.Game over!");
                    break;
                } else {
                    System.out.println("That is not a valid action. Fight or run?");
                }
            }
        } else {
            bossApproaches();
        }

    }

    public void battleLoop() {
        game.Enemy enemy = new game.Enemy();
        while (true) {
            if (this.hero.getHealthPoints() <= 0) {
                System.out.println("You have died. Alas.");
                break;
            }

            while (true) {
                System.out.println("Do you wish to attack or drink potion?");
                String action = scanner.nextLine();
                if (action.equalsIgnoreCase("attack")) {
                    int attackValue = this.hero.generateAttackValue();
                    if (attackValue == 0) {
                        System.out.println("Your attack misses!");
                    } else {
                        System.out.printf("You attack the enemy, scoring a hit of %d points!%n", attackValue);
                        enemy.changeEnemyHP(attackValue * -1);
                        if (enemy.getEnemyHP() <= 0) {
                            System.out.println("The enemy has been defeated!");
                        } else {
                            System.out.printf("The enemy has %dHP remaining!%n", enemy.getEnemyHP());
                        }
                        break;
                    }

                } else if (action.equalsIgnoreCase("drink potion")) {
                    this.hero.usePotion();
                    break;
                } else {
                    System.out.println("That is not a valid action.");
                }
            }

            if (enemy.getEnemyHP() <= 0) {
                System.out.println("Victory!");
                this.hero.addWin();
                if (this.hero.getWinCounter() == 3) {
                    System.out.println("You have found a sword! This will make your attacks a lot stronger!\n");
                    this.hero.giveSword();
                } else {
                    this.hero.changePotionCount(1);
                    System.out.printf("You have found a potion! Number of potions: %d%n", this.hero.getPotionCount());
                }
                break;
            }
            int enemyAttackValue = enemy.generateAttackValue();
            if (enemyAttackValue == 0) {
                System.out.println("The enemy's attack misses!");
            } else {
                System.out.printf("The enemy attacks you, scoring a hit of %d points!%n", enemyAttackValue);
                this.hero.changeHealthPoints(enemyAttackValue * -1);
                if (hero.getHealthPoints() <= 0) {
                    System.out.println("You have no health points remaining! Oh no!");
                } else {
                    System.out.printf("You have %dHP remaining!%n", this.hero.getHealthPoints());
                }
            }

        }
    }

    public void bossApproaches() {
        System.out.println("Uh oh! Here comes the big boss! And he looks angry! Fight or run?");

        while (true) {
            String action = scanner.nextLine();
            if (action.equalsIgnoreCase("fight")) {
                bossBattle();
                break;
            } else if (action.equalsIgnoreCase("run")) {
                hero.runAway();
                System.out.println("You are a coward and unworthy of the title of hero. game.Game over!");
                break;
            } else {
                System.out.println("That is not a valid action. Fight or run?");
            }
        }
    }

    public void bossBattle() {
        game.Boss boss = new game.Boss();
        while (true) {

            if (this.hero.getHealthPoints() <= 0) {
                System.out.println("You have died. Alas.");
                break;
            }
            while (true) {
                System.out.println("Do you wish to attack or drink potion?");
                String action = scanner.nextLine();
                if (action.equalsIgnoreCase("attack")) {
                    int attackValue = this.hero.generateAttackValue();
                    System.out.printf("You attack the enemy, scoring a hit of %d points!%n", attackValue);
                    boss.changeBossHP(attackValue * -1);
                    System.out.printf("The enemy has %dHP remaining!%n", boss.getBossHP());
                    break;
                } else if (action.equalsIgnoreCase("drink potion")) {
                    this.hero.usePotion();
                    break;
                } else {
                    System.out.println("That is not a valid action.");
                }
            }
            if (boss.getBossHP() <= 0) {
                System.out.println("Congratulations! You have defeated the evil boss and restored peace to the lands. Your name will go down in the annals of history!");
                this.hero.defeatBoss();
                break;
            }
            int bossAttackValue = boss.generateAttackValue();
            System.out.printf("The enemy attacks you, scoring a hit of %d points!%n", bossAttackValue);
            this.hero.changeHealthPoints(bossAttackValue * -1);
            System.out.printf("You have %dHP remaining!%n", this.hero.getHealthPoints());
        }
    }

     */

}