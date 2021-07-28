package main.java.jsonast;

import main.java.JSONVisitor;
import java.util.Hashtable;
import java.util.Map;

public class JSONObject implements JSONElement {
    private Map<String, JSONElement> items = new Hashtable<String, JSONElement>();

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