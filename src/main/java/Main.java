package main.java;

import java.util.List;

import main.java.Printer.PrettyPrinter;
import main.java.Printer.TokenPrinter;
import main.java.jsonast.*;

public class Main {
    public static void main(String[] args) {
        JSONElement[] sub = { new JSONNull(), new JSONBool(true), new JSONInteger(123), new JSONString("hello") };
        JSONArray myArr = new JSONArray(sub);
        JSONElement[] items = { new JSONNull(), new JSONBool(true), myArr, new JSONInteger(123),
                new JSONString("hello") };
        myArr = new JSONArray(items);

        Renderer renderer = new Renderer();
        String jsonText = renderer.render(myArr);

        System.out.println("Old renderer test" + jsonText + "\n");

        List<Token> tokens;

        try {
            tokens = Lexer.lex(jsonText);
        } catch (Exception e) {
            e.printStackTrace();
            tokens = null;
        }

        System.out.println(tokens);

        System.out.println("Tokenizer test:");

        TreeTokenizer toki = new TreeTokenizer();
        TokenPrinter printi = new PrettyPrinter();

        tokens = toki.tokenize(myArr);
        System.out.println(tokens);
        System.out.println();
        System.out.println(printi.print(tokens));
    }
}
