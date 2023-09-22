package dev.lecture.sec01_06.unchecked_exception;

public class Client {
    public void throwUnheckedExceptionMethod() throws UncheckedException {
        throw new UncheckedException();
    }

    public void tryCatchUnheckedExceptionMethod() {
        try {
            throw new UncheckedException();
        } catch (UncheckedException e) {
            e.printStackTrace();
        }
    }
}