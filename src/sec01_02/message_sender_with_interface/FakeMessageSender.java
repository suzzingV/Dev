package sec01_02.message_sender_with_interface;

public class FakeMessageSender implements MessageSender{
    public void send() {
        System.out.println("FakeMassageSender, 실제로 메시지 전송되지 않음");
    }
}
