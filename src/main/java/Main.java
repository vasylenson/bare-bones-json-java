package main.java;

import java.util.ArrayList;
import java.util.Collection;

import main.java.jsonast.*;

public class Main {
    public static void main(String[] args) {
        JSONElement[] items = { new JSONNull(), new JSONBool(true), new JSONInteger(123), new JSONString("hello") };
        JSONArray myArr = new JSONArray(items);

        Renderer renderer = new Renderer();
        String jsonText = renderer.render(myArr);

        System.out.println("Old renderer test" + jsonText + "\n");

        Collection<Token> tokens;

        try {
            tokens = Lexer.lex(jsonText);
        } catch (Exception e) {
            e.printStackTrace();
            tokens = null;
        }

        System.out.println(tokens);

        System.out.println("Tokenizer test:");

        TreeTokenizer toki = new TreeTokenizer();
        tokens = toki.tokenize(myArr);

        System.out.println(tokens);
    }
}
