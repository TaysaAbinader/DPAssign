package org.example.design_patterns.Bridge;

public abstract class Shape {
    protected Color color;

    protected Shape(Color color) {
        this.color = color;
    }

    public abstract String draw();
}
