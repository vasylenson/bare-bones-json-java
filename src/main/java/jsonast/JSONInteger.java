package main.java.jsonast;

import main.java.JSONElementVisitor;

public class JSONInteger implements JSONElement {

    private int value;

    public int getValue() {
        return value;
    }

    public JSONInteger(int value) {
        this.value = value;
    }

    public void accept(JSONElementVisitor visitor) {
        visitor.visit(this);
    }

}
