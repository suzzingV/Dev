package dev.lecture.sec04_04;

public class LspExampleMain {
    public static void main(String[] args) {
        Client client = new Client();

        Parent parent = new Parent();
        Child child = new Child();

        client.someClientMethod(child);
    }
}
