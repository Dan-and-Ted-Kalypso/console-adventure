package game;

public class BossBattle {

    private int[] heroArray;


    public BossBattle(int[] heroArray) {
        this.heroArray = heroArray;
    }

    public void battle() {
        System.out.println("Soon!");
        Crossroads crossroads = new Crossroads(heroArray);
        crossroads.choosePath();
    }
}
