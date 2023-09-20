package sec01_06.unchecked_exception;

public class CheckedExceptionExample {
    public static void main(String[] args) {
        Client client = new Client();
        try {
            client.throwUnheckedExceptionMethod();
        } catch (UncheckedException e){
            //예외에 대한 적절한 처리
        }

        client.tryCatchUnheckedExceptionMethod();
    }
}
