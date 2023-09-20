package sec01_04.abstract_class;

import javax.swing.*;

public class AbstractClassExampleMain {
    public static void main(String[] args) {
        AbstractClass abstractClass = new AbstractClass() {
            @Override
            public void abstractMethod() {
                System.out.println("AbstractClass abstractMethod");
            }
        };

        abstractClass.implementedMethod();
        abstractClass.abstractMethod();

        AbstractClass extendedClass = new ExtendedClass();
        extendedClass.implementedMethod();
        extendedClass.abstractMethod();
    }
}
