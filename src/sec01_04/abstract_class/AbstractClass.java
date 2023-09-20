package sec01_04.abstract_class;

import java.sql.SQLOutput;

public abstract class AbstractClass {
    public void implementedMethod() {
        System.out.println("AbstractClass implementedMethod");
        this.abstractMethod();
    }

    abstract public void abstractMethod();
}
