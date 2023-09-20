package sec01_03.extend;

public class ExtendsExampleMain {
    public static void main(String[] args) {
        Parent parent = new Parent();
        Parent parentTypeChild = new Child();
        Child child = new Child();

        parent.someMethod();
//        parentTypeChild.anotherMethod();
        child.someMethod();
        child.anotherMethod();
    }
}
