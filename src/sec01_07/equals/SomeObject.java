package sec01_07.equals;

import java.util.Objects;

public class SomeObject {

    private int intfield;
    private String stringField;

    public SomeObject(int intfield, String stringField) {
        this.intfield = intfield;
        this.stringField = stringField;
    }

    public int getIntfield() {
        return intfield;
    }

    public String getStringField() {
        return stringField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SomeObject that = (SomeObject) o;
        return intfield == that.intfield && Objects.equals(stringField, that.stringField);
    }
}
