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


        this.hero = new Hero();
        while (!this.hero.isCoward() && !this.hero.isDefeatedBoss()) {
            battle();
        }

    }

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
                    System.out.println("You are a coward and unworthy of the title of hero. Game over!");
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
        Enemy enemy = new Enemy();
        while (true) {
            if (this.hero.getHealthPoints() <= 0) {
                System.out.println("You have died. Alas.");
                break;
            }

            while (true) {
                System.out.println("What would you like to do?");
                System.out.println("a) Use my normal attack.");
                System.out.println("b) Attack recklessly! (more damage but leave yourself vulnerable)");
                System.out.println("c) Attack carefully. (do less damage but prevent the enemy from damaging you as much)");
                System.out.println("d) Use a potion (heals for 10 points of health)");

                String action = scanner.nextLine();
                if (action.equalsIgnoreCase("attack") | action.equalsIgnoreCase("a")) {
                    int attackValue = this.hero.generateAttackValue();
                    if (attackValue == 0) {
                        System.out.println("Your attack misses!");
                    } else {
                        System.out.printf("You attack the enemy, scoring a hit of %d points!%n", attackValue);
                        enemy.changeEnemyHP(attackValue * -1);
                        if (enemy.getEnemyHP() <= 0) {
                            System.out.println("The enemy has been defeated!");
                            break;
                        } else {
                            System.out.printf("The enemy has %dHP remaining!%n", enemy.getEnemyHP());
                        }
                    }

                } else if (action.equalsIgnoreCase("b") | action.equalsIgnoreCase("attack recklessly") | action.equalsIgnoreCase("recklessly")) {
                    int attackValue = this.hero.generateRecklessAttack();
                    if (attackValue == 0) {
                        System.out.println("Your lunge towards the enemy wildly, but your attack misses!");
                    } else {
                        System.out.printf("You lunge towards the enemy, scoring a hit of %d points!%n", attackValue);
                        enemy.changeEnemyHP(attackValue * -1);
                        if (enemy.getEnemyHP() <= 0) {
                            System.out.println("The enemy has been defeated!");
                            break;
                        } else {
                            System.out.printf("The enemy has %dHP remaining!%n", enemy.getEnemyHP());
                            if (this.hero.isOffBalance()) {
                                System.out.println("Oh no! You were so focused on trying to hit your opponent you've thrown yourself off balance!");

                            }
                        }
                    }
                } else if (action.equalsIgnoreCase("c") | action.equalsIgnoreCase("careful") | action.equalsIgnoreCase("careful attack")) {
                    int attackValue = this.hero.generateCarefulAttack();
                    if (attackValue == 0) {
                        System.out.println("You approach the enemy carefully, but your attack misses!");
                    } else {
                        System.out.printf("You approach the enemy carefully, and, striking cautiously, score a hit of %d points!%n", attackValue);
                        enemy.changeEnemyHP(attackValue * -1);
                        if (enemy.getEnemyHP() <= 0) {
                            System.out.println("The enemy has been defeated!");
                            break;
                        } else {
                            System.out.printf("The enemy has %dHP remaining!%n", enemy.getEnemyHP());
                            if (this.hero.isPrepared()) {
                                System.out.println("Fortunately your careful approach has left you in an excellent position to defend yourself!");
                            }
                        }
                    }
                } else if (action.equalsIgnoreCase("drink potion") | action.equalsIgnoreCase("d")) {
                    this.hero.usePotion();
                    break;
                } else {
                    System.out.println("That is not a valid action.");
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
                int enemyAttackValue = (int) Math.round(enemy.generateAttackValue() * this.hero.damageModifier());
                if (enemyAttackValue == 0) {
                    System.out.println("The enemy's attack misses!");

                } else {
                    if (this.hero.damageModifier() > 1) {
                        System.out.printf("The enemy senses your vulnerability and drives home his attack, scoring a hit of %d points of damage!%n", enemyAttackValue);
                        this.hero.changeHealthPoints(enemyAttackValue * -1);
                    } else if (this.hero.damageModifier() < 1) {
                        System.out.printf("The enemy strikes at you, but you're prepared for their attack, and they do only %d points of damage!%n", enemyAttackValue);
                        this.hero.changeHealthPoints(enemyAttackValue * -1);
                    } else {
                        System.out.printf("The enemy attacks you, scoring a hit of %d points!%n", enemyAttackValue);
                        this.hero.changeHealthPoints(enemyAttackValue * -1);
                    }
                    if (hero.getHealthPoints() <= 0) {
                        System.out.println("You have no health points remaining! Oh no!");
                    } else {
                        System.out.printf("You have %dHP remaining!%n", this.hero.getHealthPoints());
                        this.hero.setPrepared(false);
                        this.hero.setOffBalance(false);
                    }
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
                System.out.println("You are a coward and unworthy of the title of hero. Game over!");
                break;
            } else {
                System.out.println("That is not a valid action. Fight or run?");
            }
        }
    }

    public void bossBattle() {
        Boss boss = new Boss();
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
                        boss.changeBossHP(attackValue * -1);
                        if (boss.getBossHP() <= 0) {
                            System.out.println("The enemy has been defeated!");
                        } else {
                            System.out.printf("The enemy has %dHP remaining!%n", boss.getBossHP());
                        }
                    }
                } else if (action.equalsIgnoreCase("drink potion")) {
                    this.hero.usePotion();
                    break;
                } else {
                    System.out.println("That is not a valid action.");
                }

                if (boss.getBossHP() <= 0) {
                    System.out.println("Congratulations! You have defeated the evil boss and restored peace to the lands. Your name will go down in the annals of history!");
                    this.hero.defeatBoss();
                    break;
                }
                int bossAttackCounter = boss.getBossAttackCounter();
                if (bossAttackCounter >= 5) {
                    int bossSpecialValue = boss.specialAttackValue();
                    System.out.printf("The enemy unleashes his special attack! Oh no, it hit for %d points!%n", bossSpecialValue);
                    System.out.println("The big bad looks drained! Now would be a great time to hit him extra hard!%n");
                    this.hero.changeHealthPoints(bossSpecialValue * -1);
                    boss.changeAttackCounter(-5);
                    System.out.printf("You have %dHP remaining!%n", this.hero.getHealthPoints());


                } else if (boss.getBossHP() < 20 && bossAttackCounter >= 3) {
                    int bossHealValue = boss.bossHeal();
                    System.out.printf("The enemy uses his power to heal himself! Oh wow, he healed %d points!%n", bossHealValue);
                    System.out.println("The big bad looks drained! Now would be a great time to hit him extra hard!%n");
                    boss.changeBossHP(bossHealValue);
                    boss.changeAttackCounter(-3);
                    System.out.printf("You have %dHP remaining!%n", this.hero.getHealthPoints());
                    System.out.printf("The enemy has %dHP remaining!%n", boss.getBossHP());
                } else {
                    int bossAttackValue = boss.generateAttackValue();
                    if (bossAttackValue == 0) {
                        System.out.println("The enemy's attack misses!");
                    } else {
                        System.out.printf("The enemy attacks you, scoring a hit of %d points!%n", bossAttackValue);
                        System.out.println("It looks like he's building his power - watch out for his special attack!");
                        this.hero.changeHealthPoints(bossAttackValue * -1);
                        boss.changeAttackCounter(1);
                        System.out.printf("You have %dHP remaining!%n", this.hero.getHealthPoints());
                    }
                }
            }
        }

    }
}