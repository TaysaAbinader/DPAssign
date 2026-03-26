package org.example.design_patterns.Builder;

public class Computer {
    private String processor;
    private int ramGB;
    private String hardDrive;
    private String graphicsCard;
    private String operatingSystem;

    // Setters
    public void setProcessor(String processor) { this.processor = processor; }
    public void setRamGB(int ramGB) { this.ramGB = ramGB; }
    public void setHardDrive(String hardDrive) { this.hardDrive = hardDrive; }
    public void setGraphicsCard(String graphicsCard) { this.graphicsCard = graphicsCard; }
    public void setOperatingSystem(String operatingSystem) { this.operatingSystem = operatingSystem; }

    @Override
    public String toString() {
        return String.format("Computer [CPU: %s, RAM: %dGB, HDD: %s, GPU: %s, OS: %s]",
                processor, ramGB, hardDrive, graphicsCard, operatingSystem);
    }
}
