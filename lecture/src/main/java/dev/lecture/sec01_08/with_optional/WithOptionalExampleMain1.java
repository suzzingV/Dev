package dev.lecture.sec01_08.with_optional;

import java.util.Optional;

public class WithOptionalExampleMain1 {
    public static void main(String[] args) {
        MapRepository mapRepository = new MapRepository();
        Optional<String> string = mapRepository.getOptionalValue("NOT_EXIST_KEY");

        string.ifPresentOrElse(
                str -> System.out.println(str.toUpperCase()),
                () -> {
                    throw new RuntimeException("키가 존재하지 않습니다.");
                }
        );
    }
}
