public class Client {
    private final someInterface;

    public Client(SomeInterface someInterface) {
        this.someInterface = someInterface;
    }

    public void someClientMethod() {
        someInterface.someMethod();
    }
}