package ChainOfResponsibility;

public class SuggestionHandler extends Handler {
    @Override
    public String handle(Message message) {
        if (message.getType() == MessageType.SUGGESTION) {
            return "[Product] Logging suggestion: '" + message.getContent() + "' to the backlog.";
        }
        return passToNext(message);
    }
}
