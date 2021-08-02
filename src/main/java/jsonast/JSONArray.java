package main.java.jsonast;

import main.java.JSONElementVisitor;

public class JSONArray implements JSONElement {

    private JSONElement items[];

    public JSONArray(JSONElement[] items) {
        this.items = items;
    }

    public void accept(JSONElementVisitor visitor) {
        visitor.visit(this);
    }

    public JSONElement[] getItems() {
        return items;
    }
}