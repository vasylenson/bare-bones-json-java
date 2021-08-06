package main.java.JSONTypes;

import main.java.JSONElementVisitor;

public class JSONNull implements JSONElement {

    @Override
    public void accept(JSONElementVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean equals(JSONElement other) {
        return (other instanceof JSONNull);
    }

}