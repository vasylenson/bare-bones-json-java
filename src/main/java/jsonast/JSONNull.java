package main.java.jsonast;

import main.java.JSONVisitor;

public class JSONNull implements JSONElement {

    public void accept(JSONVisitor visitor) {
        visitor.visit(this);
    }

}