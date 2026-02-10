package State;

public class MasterState implements LevelState {
    public void train(GameCharacter character) {}

    public void meditate(GameCharacter character) {}

    public void fight(GameCharacter character) {}

    public String getLevelName() {
        return "Master (Game Completed!)";
    }
}
