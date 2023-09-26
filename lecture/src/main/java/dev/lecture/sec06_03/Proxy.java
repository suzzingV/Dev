public class Proxy {
    private Service service;
    
    public Proxy(Service service) {
        this.service = service;
    }

    @Override
    public void someMethod() {
        System.out.println("someMethod 실행 전");

        service.someMethod();

        System.out.println("someMethod 실행 후");
    }
}