package main.java.jsonast;

import main.java.JSONVisitor;

public class JSONArray implements JSONElement {

    private JSONElement items[];
    
    public JSONArray(JSONElement[] items) {
        this.items = items;
    }

    public void accept(JSONVisitor visitor) {
        visitor.visit(this);
    }

    public JSONElement[] getItems() {
        return items;
    }
}