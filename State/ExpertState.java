package State;

public class ExpertState implements LevelState {

    public void train(GameCharacter character) {
        character.addExperience(30);
        checkLevelUp(character);
    }

    public void meditate(GameCharacter character) {
        character.setHealth(character.getHealth() + 10);
    }

    public void fight(GameCharacter character) {
        if (character.getHealth() <= 10) {
            System.out.println("Too injured to fight! Meditate first.");
            return;
        }
        character.addExperience(50);
        character.setHealth(character.getHealth() - 20);
        System.out.println("Battle won! Gained XP but lost HP.");
        checkLevelUp(character);
    }

    private void checkLevelUp(GameCharacter character) {
        if (character.getExperience() >= 300) character.setState(new MasterState());
    }

    public String getLevelName() {
        return "Expert";
    }
}
