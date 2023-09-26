package domain;

import service.Mode;

import java.io.IOException;
import java.util.function.BiFunction;

public enum ModeType {
    NORMAL((Runnable)() -> {
        System.out.println("[System] 일반 모드로 애플리케이션을 실행합니다.");

    }),
    TEST((Runnable)() -> {
        System.out.println("[System] 테스트 모드로 애플리케이션을 실행합니다.");
        return new Mode("test");
    });

    ModeType(Mode expression) {
        this.expression = expression;
    }

    private Mode expression;
}
