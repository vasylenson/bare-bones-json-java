package main.java.jsonast;

import main.java.Visitor;

public class JSONArray implements JSONElement {

    private JSONElement items[];
    
    public JSONArray(JSONElement[] items) {
        this.items = items;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public JSONElement[] getItems() {
        return items;
    }
}