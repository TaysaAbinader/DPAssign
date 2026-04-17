package org.example.design_patterns.Mediator;

public interface ChatMediator {
    void sendMessage(String msg, String recipient, String sender);
    void addUser(ChatClient client);
}
