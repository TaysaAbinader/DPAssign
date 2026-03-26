package org.example.design_patterns.Builder;

public class ComputerDirector {
    public void constructComputer(ComputerBuilder builder) {
        builder.buildProcessor();
        builder.buildRAM();
        builder.buildHardDrive();
        builder.buildGraphicsCard();
        builder.buildOperatingSystem();
    }
}
