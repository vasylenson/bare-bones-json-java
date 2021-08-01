package main.java.jsonast;

import main.java.Visitor;

public class JSONInteger implements JSONElement {

    private int value;

    public int getValue() {
        return value;
    }

    public JSONInteger(int value) {
        this.value = value;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    
}
