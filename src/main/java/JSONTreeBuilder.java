package main.java;

import java.util.Stack;

import main.java.JSONTypes.JSONArray;
import main.java.JSONTypes.JSONBool;
import main.java.JSONTypes.JSONElement;
import main.java.JSONTypes.JSONNull;
import main.java.JSONTypes.JSONNumber;
import main.java.JSONTypes.JSONObject;
import main.java.JSONTypes.JSONString;
import main.java.Printer.JSONBuilder;

public class JSONTreeBuilder implements JSONBuilder {

    private Stack<Object> stack = new Stack<Object>();
    private JSONElement out;

    public JSONElement getTree() {
        if (out == null)
            throw new IllegalStateException("JSON Tree ain't ready. Finish the build calls first");

        return out;
    }

    @Override
    public void putNull() {
        insertItem(new JSONNull());
    }

    @Override
    public void putTrue() {
        insertItem(new JSONBool(true));
    }

    @Override
    public void putFalse() {
        insertItem(new JSONBool(false));
    }

    @Override
    public void putNumber(String representation) {
        Number value = parseNumber(representation);
        insertItem(new JSONNumber(value));
    }

    @Override
    public void putString(String representation) {
        String content = parseString(representation);
        insertItem(new JSONString(content));
    }

    @Override
    public void putKey(String representation) {
        Object currentOpen = stack.peek();
        if (!(currentOpen instanceof JSONObject))
            throw new IllegalStateException("Can't put key: the innermost open item is not an object");

        String key = parseString(representation);
        stack.push(key);
    }

    @Override
    public void startArray() {
        stack.push(new JSONArray());
    }

    @Override
    public void endArray() {
        if (!(stack.peek() instanceof JSONArray))
            throw new IllegalStateException("Illegal close operation: tried to close an array, but no array found");

        JSONArray closedArray = (JSONArray) stack.pop();
        insertItem(closedArray);
    }

    @Override
    public void startObject() {
        stack.push(new JSONObject());
    }

    @Override
    public void endObject() {
        if (!(stack.peek() instanceof JSONObject))
            throw new IllegalStateException("Illegal close operation: tried to close an object, but no object found");

        JSONObject closedObject = (JSONObject) stack.pop();
        insertItem(closedObject);
    }

    private Number parseNumber(String representation) {
        if (representation.matches("^[\\+, -]?\\d+$"))
            return Integer.parseInt(representation);
        else if (representation.matches("^[\\+, -]?\\d+[e, E][\\+, -]?\\d+$"))
            return (int) Float.parseFloat(representation);
        else if (representation.matches("^[\\+, -]?\\d+\\.\\d+([e, E][\\+, -]?\\d+)?$"))
            return Float.parseFloat(representation);
        throw new NumberFormatException("Malformed number literal");
    }

    private String parseString(String representation) {
        return representation.substring(1, representation.length() - 1);
    }

    private void insertItem(JSONElement item) {
        checkIfDone();

        if (stack.isEmpty()) {
            out = item;
            return;
        }

        Object openElement = stack.peek();

        if (openElement instanceof JSONArray) {
            ((JSONArray) openElement).add(item);
            return;
        }

        if (openElement instanceof String) {
            String key = (String) stack.pop();
            JSONObject currentObject = (JSONObject) stack.peek();
            currentObject.put(key, item);
            return;
        }

        throw new IllegalStateException("Internal builder error: illegal object on the stack");
    }

    private void checkIfDone() {
        if (out != null)
            throw new IllegalStateException("This builder is done. getTree() or reset() before further build calls");
    }
}
