package org.example.design_patterns.Bridge;

public class Main {
    public static void main(String[] args) {

        Shape redPentagon = new Pentagon(new Red());
        System.out.println(redPentagon.draw());

        Shape greenSquare = new Square(new Green());
        System.out.println(greenSquare.draw());

    }
}
