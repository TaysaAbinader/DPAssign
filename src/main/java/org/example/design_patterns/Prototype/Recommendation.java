package org.example.design_patterns.Prototype;

import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Cloneable {
    private String targetAudience;
    private List<Book> books;

    public Recommendation(String targetAudience) {
        this.targetAudience = targetAudience;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(int index) {
        if (index >= 0 && index < books.size()){
            books.remove(index);
        }
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    @Override
    public Recommendation clone() {
        try {
            // 1. Perform a shallow clone of the Recommendation object itself
            Recommendation cloned = (Recommendation) super.clone();

            // 2. DEEP COPY: Create a new list and clone every book into it
            cloned.books = new ArrayList<>();
            for (Book b : this.books) {
                cloned.addBook(b.clone());
            }
            return cloned;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public void display() {
        System.out.println("\n--- Recommendation List for: " + targetAudience + " ---");
        for (int i = 0; i < books.size(); i++) {
            System.out.println(i + ". " + books.get(i));
        }
    }
}
