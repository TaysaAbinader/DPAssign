package org.example.design_patterns.Mediator;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChatClient {
    private String username;
    private ChatMediator mediator;

    // UI Components
    private TextArea chatLog = new TextArea();
    private TextField messageInput = new TextField();
    private TextField recipientInput = new TextField();

    public ChatClient(ChatMediator mediator, String username) {
        this.mediator = mediator;
        this.username = username;
        setupUI();
    }

    private void setupUI() {
        Stage stage = new Stage();
        stage.setTitle("Chat: " + username);

        chatLog.setEditable(false);
        Button sendBtn = new Button("Send");

        // The core Mediator interaction
        sendBtn.setOnAction(e -> {
            String msg = messageInput.getText();
            String dest = recipientInput.getText();

            chatLog.appendText("To " + dest + ": " + msg + "\n");
            mediator.sendMessage(msg, dest, this.username);
            messageInput.clear();
        });

        VBox layout = new VBox(10, new Label("Recipient:"), recipientInput, chatLog, messageInput, sendBtn);
        stage.setScene(new Scene(layout, 300, 400));
        stage.show();
    }

    public void receive(String message, String sender) {
        chatLog.appendText(sender + ": " + message + "\n");
    }

    public String getUsername() {
        return username;
    }
}
