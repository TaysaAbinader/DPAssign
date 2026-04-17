package org.example.design_patterns.Prototype;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RecommendationUI {
    // Registry to store our recommendation lists
    private static Map<String, Recommendation> registry = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. View All Lists");
            System.out.println("2. Create New List");
            System.out.println("3. Clone & Modify Existing List");
            System.out.println("4. Exit");
            System.out.print("> ");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                if (registry.isEmpty()) System.out.println("No lists found!");
                registry.forEach((id, rec) -> {
                    System.out.println("\nID: [" + id + "]");
                    rec.display();
                });
            }
            else if (choice.equals("2")) {
                System.out.print("Enter unique ID for this list: ");
                String id = scanner.nextLine();
                System.out.print("Enter Target Audience: ");
                String audience = scanner.nextLine();

                Recommendation newList = new Recommendation(audience);
                addBooksToList(newList);

                registry.put(id, newList); // SAVING TO REGISTRY
                System.out.println("List saved!");
            }
            else if (choice.equals("3")) {
                System.out.print("Enter ID of list to clone: ");
                String sourceId = scanner.nextLine();

                if (registry.containsKey(sourceId)) {
                    Recommendation cloned = registry.get(sourceId).clone();

                    System.out.print("Enter new unique ID for this clone: ");
                    String newId = scanner.nextLine();
                    System.out.print("Enter new Audience (leave blank to keep): ");
                    String newAudience = scanner.nextLine();
                    if (!newAudience.isEmpty()) cloned.setTargetAudience(newAudience);

                    addBooksToList(cloned);

                    registry.put(newId, cloned); // SAVING CLONE TO REGISTRY
                    System.out.println("Clone saved!");
                } else {
                    System.out.println("Source ID not found.");
                }
            }
            else if (choice.equals("4")) break;
        }
    }

    // Helper method to keep code clean
    private static void addBooksToList(Recommendation list) {
        while (true) {
            System.out.print("Add a book? (y/n): ");
            if (scanner.nextLine().equalsIgnoreCase("n")) break;
            System.out.print("Title: ");
            String title = scanner.nextLine();
            System.out.print("Author: ");
            String author = scanner.nextLine();
            System.out.print("Genre: ");
            String genre = scanner.nextLine();
            System.out.print("Publication Year: ");
            String publication = scanner.nextLine();
            int year = Integer.parseInt(publication);
            list.addBook(new Book(title, author, genre, year));
        }
    }
}
