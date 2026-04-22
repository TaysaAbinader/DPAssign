package org.example.design_patterns.Iterator;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        // Create a sequence that will provide 10 Fibonacci numbers
        FibonacciSequence fibSequence = new FibonacciSequence(10);

        // Obtain the iterator from the sequence
        Iterator<Integer> iterator = fibSequence.iterator();

        System.out.println("First 10 Fibonacci numbers:");

        // Standard Iterator pattern traversal
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
