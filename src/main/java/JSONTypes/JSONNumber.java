package main.java.JSONTypes;

import main.java.JSONElementVisitor;

public class JSONNumber implements JSONElement {

    public Number value;

    public Number getValue() {
        return value;
    }

    public JSONNumber(Number value) {
        this.value = value;
    }

    public boolean isInt() {
        return value instanceof Integer;
    }

    public boolean isFloat() {
        return value instanceof Float;
    }

    public void accept(JSONElementVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean equals(JSONElement other) {
        return (other instanceof JSONNumber) && ((JSONNumber) other).value == value;
    }

}
