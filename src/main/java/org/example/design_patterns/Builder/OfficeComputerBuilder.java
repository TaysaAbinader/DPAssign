package org.example.design_patterns.Builder;

public class OfficeComputerBuilder implements ComputerBuilder{
    private Computer computer = new Computer();

    public void buildProcessor() { computer.setProcessor("Intel i5-12400"); }
    public void buildRAM() { computer.setRamGB(16); }
    public void buildHardDrive() { computer.setHardDrive("512GB SSD"); }
    public void buildGraphicsCard() { computer.setGraphicsCard("Integrated Graphics"); }
    public void buildOperatingSystem() { computer.setOperatingSystem("Windows 11 Home"); }
    public Computer getResult() { return computer; }
}
