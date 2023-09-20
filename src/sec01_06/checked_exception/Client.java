package sec01_06.checked_exception;

public class Client {
    public void throwCheckedExceptionMethod() throws CheckedException {
        throw new CheckedException();
    }

    public void tryCatchCheckedExceptionMethod() {
        try {
            throw new CheckedException();
        } catch (CheckedException e) {
            e.printStackTrace();
        }
    }
}