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
            //snakeBattle
        } else if (desertWins == 1) {
            //scorpionBattle
        } else if (desertWins == 2) {
            //mummyBattle
        } else {
            System.out.println("Dude. You've already killed everything in the desert. Go somewhere else.");
            Crossroads crossroads = new Crossroads(heroArray);
            crossroads.choosePath();
        }
    }
}
