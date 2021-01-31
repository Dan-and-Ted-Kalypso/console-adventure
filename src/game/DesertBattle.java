package game;

public class DesertBattle {

    private int[] heroArray;
    private int desertWins;

    public DesertBattle(int[] heroArray) {
        this.heroArray = heroArray;
        this.desertWins = heroArray[3];
    }

    public void battle() {
        if (desertWins == 3) {
            fightSnake();
        } else if (desertWins == 1) {
            fightScorpion();
        } else if (desertWins == 2) {
            //mummyBattle
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



}
