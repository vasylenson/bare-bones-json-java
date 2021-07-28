package main.java.jsonast;

import main.java.JSONVisitor;

public class JSONString implements JSONElement {
    
    String value;

    public void accept(JSONVisitor visitor) {
        visitor.visit(this);
    }
}