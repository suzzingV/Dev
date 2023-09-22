package dev.lecture.sec01_07.to_string;

import java.util.Objects;

public class SomeObject {

    private int intfield;
    private String stringField;

    public SomeObject(int intfield, String stringField) {
        this.intfield = intfield;
        this.stringField = stringField;
    }

    @Override
    public String toString() {
        return "SomeObject{" +
                "intfield=" + intfield +
                ", stringField='" + stringField + '\'' +
                '}';
    }
}
