package org.example.design_patterns.Mediator;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application{
    @Override
    public void start(Stage primaryStage) {
        ChatMediator mediator = new ChatRoom();

        // Create 3 clients
        ChatClient alice = new ChatClient(mediator, "Alice");
        ChatClient bob = new ChatClient(mediator, "Bob");
        ChatClient charlie = new ChatClient(mediator, "Charlie");

        // Register them so the mediator knows they exist
        mediator.addUser(alice);
        mediator.addUser(bob);
        mediator.addUser(charlie);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
