package main.java.jsonast;

import main.java.JSONVisitor;

public class JSONInteger implements JSONElement {

    private int value;

    public void accept(JSONVisitor visitor) {
        visitor.visit(this);
    }
    
}
