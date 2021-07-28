package main.java.jsonast;

import main.java.JSONVisitor;

public class JSONBool implements JSONElement {

    private boolean value;

    public void accept(JSONVisitor visitor) {
        visitor.visit(this);
    }
    
}
