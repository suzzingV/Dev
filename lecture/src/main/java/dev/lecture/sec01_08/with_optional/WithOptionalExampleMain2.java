package dev.lecture.sec01_08.with_optional;

import java.util.Optional;

public class WithOptionalExampleMain2 {
    public static void main(String[] args) {
        MapRepository mapRepository = new MapRepository();
        String string = mapRepository.getOptionalValue("NOT_EXIST_KEY").orElseThrow(
                () -> {throw new RuntimeException("키가 존재하지 않습니다.");}
        );

        System.out.println(string.toUpperCase());
    }
}
