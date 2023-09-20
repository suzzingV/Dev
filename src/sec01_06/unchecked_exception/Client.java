package sec01_06.unchecked_exception;

import sec01_06.checked_exception.CheckedException;

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