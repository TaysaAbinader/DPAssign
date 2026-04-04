package org.example.design_patterns.Bridge;

public class Square extends Shape {
    public Square(Color color) {
        super(color);
    }

    public String draw() {
        return "Square drawn with " + color.fill();
    }
}
