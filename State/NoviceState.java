package State;

public class NoviceState implements LevelState{

    public void train(GameCharacter character) {
        character.addExperience(20);
        System.out.println("XP gained!");
        if (character.getExperience() >= 50) character.setState(new IntermediateState());
    }

    public void meditate(GameCharacter character) { System.out.println("Novices aren't focused enough to meditate.");
    }

    public void fight(GameCharacter character) { System.out.println("You are too weak to fight!");
    }

    public String getLevelName() {
        return "Novice";
    }
}
