package State;

public class IntermediateState implements LevelState {

    public void train(GameCharacter character) {
        character.addExperience(25);
        System.out.println("Advanced training! XP gained.");
        checkLevelUp(character);
    }

    public void meditate(GameCharacter character) {
        character.setHealth(character.getHealth() + 15);
        System.out.println("Meditating... HP restored.");
    }

    public void fight(GameCharacter character) {
        System.out.println("You haven't mastered combat yet.");
    }

    private void checkLevelUp(GameCharacter character) {
        if (character.getExperience() >= 150) character.setState(new ExpertState());
    }

    public String getLevelName() {
        return "Intermediate";
    }
}
