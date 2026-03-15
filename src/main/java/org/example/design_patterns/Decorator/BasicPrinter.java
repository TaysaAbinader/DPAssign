package org.example.design_patterns.Decorator;

public class BasicPrinter implements Printer {
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
