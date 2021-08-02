package main.java;

import java.util.Iterator;
import java.util.Map.Entry;

import main.java.jsonast.*;

public class Renderer implements JSONElementVisitor {

    private String text;

    public String render(JSONElement element) {
        text = "";
        element.accept(this);
        return text;
    }

    @Override
    public void visit(JSONNull element) {
        String rep = "null";
        text += rep;
    }

    @Override
    public void visit(JSONBool element) {
        String rep = element.getValue() ? "true" : "false";
        text += rep;
    }

    @Override
    public void visit(JSONInteger element) {
        String rep = String.valueOf(element.getValue());
        text += rep;
    }

    @Override
    public void visit(JSONString element) {
        String rep = element.getValue();
        text += "\"" + rep + "\"";
    }

    @Override
    public void visit(JSONArray element) {
        text += "[ ";

        // TODO: figure out the idiomatic way to join a complex collection like this
        // Basically, find how to do a list comprehension
        JSONElement[] arrayItems = element.getItems();
        arrayItems[0].accept(this);;
        for (int i = 1; i < arrayItems.length; i++) {
            text += ", ";

            JSONElement item = arrayItems[i];
            item.accept(this);;
        }

        text += " ]";
    }

    @Override
    public void visit(JSONObject element) {
        text += "{ ";

        Iterator<Entry<String, JSONElement>> items = element.getItems().iterator();
        while (items.hasNext()) {
            Entry<String, JSONElement> entry = items.next();
            renderObjectEntry(entry);

            if (items.hasNext())
                text += ", ";
        }

        text += " }";
    }

    private void renderObjectEntry(Entry<String, JSONElement> entry) {
        text += "\"" + entry.getKey() + " : ";
        entry.getValue().accept(this);;
    }

}
