package dev.lecture.sec01_03.extend;

public class Child extends Parent {
    public void anotherMethod() {
        System.out.println("Child anotherMethod");

        this.parentProtectedInt = 0;
        this.parentPublicInt = 0;
//        this.parentPrivateInt = 0;
    }
}
