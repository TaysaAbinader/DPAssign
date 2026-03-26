package org.example.design_patterns.Builder;

public class GamingComputerBuilder implements ComputerBuilder{
    private Computer computer = new Computer();

    public void buildProcessor() { computer.setProcessor("Intel i9-13900K"); }
    public void buildRAM() { computer.setRamGB(32); }
    public void buildHardDrive() { computer.setHardDrive("2TB NVMe SSD"); }
    public void buildGraphicsCard() { computer.setGraphicsCard("NVIDIA RTX 4090"); }
    public void buildOperatingSystem() { computer.setOperatingSystem("Windows 11 Pro"); }
    public Computer getResult() { return computer; }
}
