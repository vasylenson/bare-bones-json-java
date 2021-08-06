package main.java;

import main.java.JSONTypes.JSONElement;

public class Main {
    public static void main(String[] args) {
        tryTreeBuilder();
    }

    private static JSONElement tryTreeBuilder() {
        JSONTreeBuilder buildy = new JSONTreeBuilder();

        buildy.startObject();
        buildy.putKey("\"array\"");

        buildy.startArray();
        buildy.putNull();
        buildy.putString("\"hello\"");

        buildy.startArray();
        buildy.putFalse();
        buildy.putTrue();
        buildy.putNumber("123");
        buildy.endArray();

        buildy.startObject();
        buildy.putKey("\"x\"");
        buildy.putNumber("123");
        buildy.putKey("\"y\"");
        buildy.putNumber("123");
        buildy.endObject();

        buildy.endArray();

        buildy.putKey("\"type\"");
        buildy.putString("\"kurwa\"");

        buildy.endObject();

        JSONElement tree = buildy.getTree();
        return tree;
    }
}
