package org.example.design_patterns.Builder;

public class Main {
    public static void main(String[] args) {
        ComputerDirector director = new ComputerDirector();

        // Build a Gaming PC
        ComputerBuilder gamingBuilder = new GamingComputerBuilder();
        director.constructComputer(gamingBuilder);
        Computer gamingPC = gamingBuilder.getResult();

        // Build an Office PC
        ComputerBuilder officeBuilder = new OfficeComputerBuilder();
        director.constructComputer(officeBuilder);
        Computer officePC = officeBuilder.getResult();

        // Display results
        System.out.println("--- Computer Type ---");
        System.out.println("Gaming: " + gamingPC);
        System.out.println("Office: " + officePC);
    }
}
