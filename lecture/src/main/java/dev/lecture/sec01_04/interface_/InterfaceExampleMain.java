package dev.lecture.sec01_04.interface_;

public class InterfaceExampleMain {
    public static void main(String[] args) {
        SomeInterface someInterface = new ImplementsClass();
        AnotherInterface anotherInterface = new ImplementsClass();

        someInterface.someMethod();
        anotherInterface.anotherMethod();

        //실행 불가
//        someInterface.anotherMethod();
//        anotherInterface.someMethod();
    }
}
