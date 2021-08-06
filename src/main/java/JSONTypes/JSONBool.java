package main.java.JSONTypes;

import main.java.JSONElementVisitor;

public class JSONBool implements JSONElement {

    public boolean value;

    public boolean getValue() {
        return value;
    }

    public JSONBool(boolean value) {
        this.value = value;
    }

    public void accept(JSONElementVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean equals(JSONElement other) {
        return (other instanceof JSONBool) && ((JSONBool) other).value == value;
    }

}
