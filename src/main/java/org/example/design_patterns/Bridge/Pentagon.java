package org.example.design_patterns.Bridge;

public class Pentagon extends Shape {
    public Pentagon(Color color) {
        super(color);
    }
    public String draw() {
        return "Pentagon drawn with " + color.fill();
    }
}
