package main.java.Printer;

import java.util.List;

import main.java.Token;

public class TokenInterpreter {
    private final List<Token> tokens;
    private JSONBuilder out = null;

    public List<Token> getTokens() {
        return tokens;
    }

    public TokenInterpreter(List<Token> tokens) {
        this.tokens = tokens;
    }

    public void writeTo(JSONBuilder writer) {
        // TODO: implement token interpretation (with look-ahead tokens)
        out = writer;

        for (Token token : tokens) {
            handle(token);
        }
    }

    private void handle(Token token) {
    }
}