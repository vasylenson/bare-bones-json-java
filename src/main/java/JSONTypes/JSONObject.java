package main.java.JSONTypes;

import main.java.JSONElementVisitor;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class JSONObject implements JSONElement, Iterable<Entry<String, JSONElement>>, Map<String, JSONElement> {

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

    @Override
    public Iterator<Entry<String, JSONElement>> iterator() {
        return items.entrySet().iterator();
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return items.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return items.containsValue(value);
    }

    @Override
    public JSONElement get(Object key) {
        return items.get(key);
    }

    @Override
    public JSONElement put(String key, JSONElement value) {
        return items.put(key, value);
    }

    @Override
    public JSONElement remove(Object key) {
        return items.remove(key);
    }

    @Override
    public void putAll(Map<? extends String, ? extends JSONElement> m) {
        // TODO Auto-generated method stub

    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub

    }

    @Override
    public Set<String> keySet() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Collection<JSONElement> values() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<Entry<String, JSONElement>> entrySet() {
        // TODO Auto-generated method stub
        return null;
    }
}