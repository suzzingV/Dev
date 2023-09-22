package dev.lecture.sec01_02.message_sender_without_interface;

public class Client {
    public void someMethod() {
        RealMessageSender messageSender = new RealMessageSender();
        messageSender.send();
    }
}
