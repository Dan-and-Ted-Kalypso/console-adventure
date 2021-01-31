package game;

public class DesertBattle {

    private final int[] heroArray;
    private final int desertWins;

    public DesertBattle(int[] heroArray) {
        this.heroArray = heroArray;
        this.desertWins = heroArray[3];
    }

    public void battle() {
        if (desertWins == 0) {
            fightSnake();
        } else if (desertWins == 1) {
            fightScorpion();
        } else if (desertWins == 2) {
            fightMummy();
        } else {
            System.out.println("Dude. You've already killed everything in the desert. Go somewhere else.");
            Crossroads crossroads = new Crossroads(heroArray);
            crossroads.choosePath();
        }
    }

    public void fightSnake() {
        SnakeBattle snakeBattle = new SnakeBattle(heroArray);
        snakeBattle.battle();
    }

    public void fightScorpion() {
        ScorpionBattle scorpionBattle = new ScorpionBattle(heroArray);
        scorpionBattle.battle();
    }

    public void fightMummy() {
        MummyBattle mummyBattle = new MummyBattle(heroArray);
        mummyBattle.battle();
    }

}
