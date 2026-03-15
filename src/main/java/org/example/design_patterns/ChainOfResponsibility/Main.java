package org.example.design_patterns.ChainOfResponsibility;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Initialize the concrete handlers
        Handler compensation = new CompensationHandler();
        Handler contact = new ContactHandler();
        Handler suggestion = new SuggestionHandler();
        Handler general = new GeneralHandler();

        // 2. Build the chain: Compensation -> Contact -> Suggestion -> General
        compensation.setNext(contact)
                    .setNext(suggestion)
                    .setNext(general);

        // 3. Generate sample feedback
        List<Message> feedbacks = new ArrayList<>();
        feedbacks.add(new Message(MessageType.COMPENSATION, "Package arrived empty", "bob@mail.com"));
        feedbacks.add(new Message(MessageType.SUGGESTION, "Add biometrics login", "tech@dev.com"));
        feedbacks.add(new Message(MessageType.CONTACT_REQUEST, "Call me regarding my order", "alice@web.com"));
        feedbacks.add(new Message(MessageType.GENERAL, "Great service!", "fan@app.com"));

        // 4. Process each message through the start of the chain
        System.out.println("--- Customer Feedback Processing ---");
        for (Message m : feedbacks) {
            String result = compensation.handle(m);
            System.out.println("Type: " + m.getType() + " | Result: " + result);
        }
    }
}
