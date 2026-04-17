package org.example.design_patterns.Mediator;

import java.util.HashMap;
import java.util.Map;

public class ChatRoom implements ChatMediator {
    private Map<String, ChatClient> users = new HashMap<>();

    @Override
    public void addUser(ChatClient client) {
        this.users.put(client.getUsername(), client);
    }

    @Override
    public void sendMessage(String msg, String recipient, String sender) {
        ChatClient receiver = users.get(recipient);

        if (receiver != null) {
            receiver.receive(msg, sender);
        } else {
            // Handle user not found logic (e.g., send a system message back)
            users.get(sender).receive("User '" + recipient + "' not found.", "System");
        }
    }
}
