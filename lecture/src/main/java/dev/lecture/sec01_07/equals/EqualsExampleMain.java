package dev.lecture.sec01_07.equals;

public class EqualsExampleMain {
    public static void main(String[] args) {
        SomeObject sameObject1 = new SomeObject(1, "programmers");
        SomeObject sameObject2 = new SomeObject(1, "programmers");

        SomeObject anotherObject = new SomeObject(100, "foo");

        System.out.println(sameObject1 == sameObject2);

        System.out.println(sameObject1.equals(sameObject2));

        System.out.println(anotherObject.equals(sameObject1));
    }
}
