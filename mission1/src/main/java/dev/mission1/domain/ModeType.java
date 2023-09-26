package dev.mission1.domain;

public enum ModeType {
    NORMAL("일반 모드"),
    TEST("테스트 모드");

    public String mode;

    ModeType(String num) {
        this.mode = num;
    }

    public void performFunction() {

    }
}
