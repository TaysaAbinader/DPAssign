package org.example.design_patterns.Iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class FibonacciIterator implements Iterator<Integer>{
    private int count = 0;       // How many numbers we've returned
    private final int limit;     // How many numbers to return in total

    // State of the sequence calculation
    private int current = 1;
    private int previous = 0;

    public FibonacciIterator(int limit) {
        this.limit = limit;
    }

    @Override
    public boolean hasNext() {
        return count < limit;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        // Fibonacci Logic: 1, 1, 2, 3, 5, 8...
        int result = current;
        int nextValue = current + previous;
        previous = current;
        current = nextValue;

        count++;
        return result;
    }
}
