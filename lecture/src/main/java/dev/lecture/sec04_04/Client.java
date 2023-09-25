package dev.lecture.sec04_04;

public class Client {
    public void someClientMethod(Parent parentOrChild) {
//        parentOrChild.someMethod(-1);

        if(parentOrChild instanceof Parent && false == parentOrChild instanceof Child)
            parentOrChild.someMethod(-1);
        else if(parentOrChild instanceof Child)
            parentOrChild.someMethod(Math.abs(-1));
    }
}
