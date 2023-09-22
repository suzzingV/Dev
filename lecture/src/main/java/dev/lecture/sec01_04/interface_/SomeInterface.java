package dev.lecture.sec01_04.interface_;

public interface SomeInterface {
    void someMethod();

    default void defaultMethod() {
        this.someMethod();
    }
}
