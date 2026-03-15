package org.example.design_patterns.State;

public class GameCharacter {
    private String name;
    private int experience = 0;
    private int health = 100;
    private LevelState currentState;

    public GameCharacter(String name) {
        this.name = name;
        this.currentState = new NoviceState();
    }

    public void setState(LevelState state) {
        this.currentState = state;
    }

    public int getExperience() {
        return experience;
    }

    public void addExperience(int xp) {
        this.experience += xp;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = Math.min(health, 100);
    }

    public String getLevelName() {
        return currentState.getLevelName();
    }

    public void train() {
        currentState.train(this);
    }

    public void meditate() {
        currentState.meditate(this);
    }

    public void fight() {
        currentState.fight(this);
    }

    public void displayStatus() {
        System.out.println("\n>>> " + name + "'s Status <<<");
        System.out.println("Level: " + currentState.getLevelName());
        System.out.println("XP: " + experience + " | HP: " + health);
        System.out.println("-------------------------");
    }
}
