package main.java.jsonast;

import main.java.JSONElementVisitor;

public class JSONBool implements JSONElement {

    private boolean value;

    public boolean getValue() {
        return value;
    }

    public JSONBool(boolean value) {
        this.value = value;
    }

    public void accept(JSONElementVisitor visitor) {
        visitor.visit(this);
    }

}
