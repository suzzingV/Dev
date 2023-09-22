package dev.lecture.sec01_08.without_optional;

public class WithoutOptionalExampleMain {
    public static void main(String[] args) {
        MapRepository mapRepository = new MapRepository();
        String string = mapRepository.getValue("NOT_EXIST_KEY");

        System.out.println("string=" + string);

        System.out.println(string.toUpperCase());

//        if(string != null) System.out.println(string.toUpperCase());
    }
}
