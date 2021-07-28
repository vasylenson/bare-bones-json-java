package main.java.jsonast;

import main.java.JSONVisitor;

public class JSONArray implements JSONElement {

    private JSONElement items[];
    
    public void accept(JSONVisitor visitor) {
        visitor.visit(this);
    }
}
