package Template;

public class PlayGame {
    public static void main(String[] args) {
        Game myGame = new DiceGame();
        myGame.play(2);
    }
}
