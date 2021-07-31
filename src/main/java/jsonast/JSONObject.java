package main.java.jsonast;

import main.java.JSONVisitor;
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

    // public String render(int indentLevel) {
    //     Vector<String> itemTexts = new Vector<String>(countItems());
    //     String indent = "\t".repeat(indentLevel);
    //     String text = "{\n";

    //     for (var entry : items.entrySet()) {
    //         String itemText = (indent + entry.getKey() + ": " + entry.getValue().render(indentLevel + 1)
    //                 + ",\n");
    //         itemTexts.add(itemText);
    //     }

    //     text += String.join(",\n", itemTexts);
    //     text += "\n}";
    //     return text;
    // }

    public void accept(JSONVisitor visitor) {
        visitor.visit(this);
    }
}