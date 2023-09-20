package sec01_02.message_sender_with_interface;

public class Client {
    private MessageSender messageSender;

    Client(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void someMethod() {
        messageSender.send();
    }
}
