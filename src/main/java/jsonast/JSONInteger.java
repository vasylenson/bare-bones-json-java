package main.java.jsonast;

import main.java.JSONVisitor;

public class JSONInteger implements JSONElement {

    private int value;

    public int getValue() {
        return value;
    }

    public JSONInteger(int value) {
        this.value = value;
    }

    public void accept(JSONVisitor visitor) {
        visitor.visit(this);
    }
    
}
