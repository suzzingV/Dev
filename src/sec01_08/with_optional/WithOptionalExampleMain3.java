package sec01_08.with_optional;

import java.util.Optional;

public class WithOptionalExampleMain3 {
    public static void main(String[] args) {
        MapRepository mapRepository = new MapRepository();
        String string = Optional.ofNullable(mapRepository.getValue("NOT_EXIST_KEY"))
                .orElseThrow(RuntimeException::new);

        System.out.println(string.toUpperCase());
    }
}
