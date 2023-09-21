package sec01_08.without_optional;

public class SimpleNpeExampleMain {
    public static void main(String[] args) {

        String string = getNullString();

        System.out.println("string=" + string);

        System.out.println(string.toUpperCase());
    }

    public static String getNullString() {
        return null;
    }
}
