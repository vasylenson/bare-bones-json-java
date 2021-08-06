package main.java.JSONTypes;

import main.java.JSONElementVisitor;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class JSONObject implements JSONElement {

    public Map<String, JSONElement> items;

    public JSONObject(Map<String, JSONElement> items) {
        this.items = items;
    }

    public JSONObject() {
        this.items = new Hashtable<String, JSONElement>();
    }

    @Override
    public boolean equals(JSONElement other) {
        return (other instanceof JSONObject) && ((JSONObject) other).items.equals(items);
    }

    @Override
    public void accept(JSONElementVisitor visitor) {
        visitor.visit(this);
    }

    public Iterator<Entry<String, JSONElement>> iterator() {
        return items.entrySet().iterator();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public JSONElement put(String key, JSONElement value) {
        return items.put(key, value);
    }

    public JSONElement remove(Object key) {
        return items.remove(key);
    }
}