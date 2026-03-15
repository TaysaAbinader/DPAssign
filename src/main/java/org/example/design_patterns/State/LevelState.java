package org.example.design_patterns.State;

public interface LevelState {
    void train(GameCharacter character);
    void meditate(GameCharacter character);
    void fight(GameCharacter character);
    String getLevelName();
}
