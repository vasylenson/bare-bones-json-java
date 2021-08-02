package main.java.jsonast;

import main.java.JSONElementVisitor;

public class JSONNull implements JSONElement {

    public void accept(JSONElementVisitor visitor) {
        visitor.visit(this);
    }

}