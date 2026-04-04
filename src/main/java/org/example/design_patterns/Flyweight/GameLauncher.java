package org.example.design_patterns.Flyweight;

public class GameLauncher {
    public static void main(String[] args) {
        // This tricks the JVM into loading JavaFX from your Maven
        // classpath without requiring strict module rules!
        Game.main(args);
    }
}
