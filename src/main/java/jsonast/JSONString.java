package main.java.jsonast;

import main.java.JSONElementVisitor;

public class JSONString implements JSONElement {

    String value;

    public String getValue() {
        return value;
    }

    public JSONString(String value) {
        this.value = value;
    }

    public void accept(JSONElementVisitor visitor) {
        visitor.visit(this);
    }
}