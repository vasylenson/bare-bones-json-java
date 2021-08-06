package main.java.JSONTypes;

import main.java.JSONElementVisitor;

public class JSONNumber implements JSONElement {

    public int value;

    public int getValue() {
        return value;
    }

    public JSONNumber(int value) {
        this.value = value;
    }

    public void accept(JSONElementVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean equals(JSONElement other) {
        return (other instanceof JSONNumber) && ((JSONNumber) other).value == value;
    }

}
