package main.java.JSONTypes;

import java.util.ArrayList;
import java.util.List;

import main.java.JSONElementVisitor;

public class JSONArray implements JSONElement {

    private List<JSONElement> items;

    public JSONArray() {
        this.items = new ArrayList<JSONElement>();
    }

    public JSONArray(List<JSONElement> items) {
        this.items = items;
    }

    public void accept(JSONElementVisitor visitor) {
        visitor.visit(this);
    }

    public List<JSONElement> getItems() {
        return items;
    }

    @Override
    public boolean equals(JSONElement other) {
        return (other instanceof JSONArray) && ((JSONArray) other).items.equals(items);
    }

    public void add(JSONElement element) {
        items.add(element);
    }
}