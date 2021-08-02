package main.java.jsonast;

import main.java.JSONElementVisitor;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class JSONObject implements JSONElement {

    private Map<String, JSONElement> items = new Hashtable<String, JSONElement>();

    public JSONObject(Map<String, JSONElement> items) {
        this.items = items;
    }

    public Set<Entry<String, JSONElement>> getItems() {
        return items.entrySet();
    }

    private int countItems() {
        return items.size();
    }

    public void accept(JSONElementVisitor visitor) {
        visitor.visit(this);
    }
}