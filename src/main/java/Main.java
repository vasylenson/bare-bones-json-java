package main.java;

import main.java.jsonast.*;
import main.java.JSONRenderer;

public class Main {
    public static void main(String[] args) {
        JSONElement[] items = {new JSONNull(), new JSONBool(true), new JSONInteger(123), new JSONString("hello")};
        JSONArray myArr = new JSONArray(items);

        JSONRenderer renderer = new JSONRenderer();
        String jsonText = renderer.render(myArr);

        System.out.println(jsonText);
    }
}
