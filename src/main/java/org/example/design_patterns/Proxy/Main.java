package org.example.design_patterns.Proxy;


public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        AccessControlService service = AccessControlService.getInstance();


        library.addDocument("Public01", "Everyone can see this.");
        library.addProtectedDocument("Secret01", "Top secret data.");

        service.grantAccess("Secret01", "Alice");

        User alice = new User("Alice");
        User bob = new User("Bob");


        try {

            System.out.println("Public Doc: " + library.getDocument("Public01").getContent(bob));

            System.out.println("Alice Accessing Secret: " + library.getDocument("Secret01").getContent(alice));

            System.out.println("Bob Accessing Secret: " + library.getDocument("Secret01").getContent(bob));

        } catch (AccessDeniedException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Secret Doc Date: " + library.getDocument("Secret01").getCreationDate());
    }
}
