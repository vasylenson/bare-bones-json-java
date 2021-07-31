package main.java.jsonast;

import main.java.JSONVisitor;

public class JSONString implements JSONElement {
    
    String value;

    public String getValue() {
        return value;
    }

    public JSONString(String value) {
        this.value = value;
    }

    public void accept(JSONVisitor visitor) {
        visitor.visit(this);
    }
}