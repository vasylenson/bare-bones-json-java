package main.java;

import java.util.Collection;

import main.java.Token.Type;

public class Printer {
    public String print(Collection<Token> tokens) {
        String output = "";

        for (Token token : tokens) {
            if (token.getType().isDelimiter()) {
                output += printDelimiterWithWhitespace(token);
            } else if (token.getType() == Type.STRING) {
                // TODO: make string token get text consistent with the rest
                output += "\"" + token.getText() + "\"";
            } else {
                output += token.getText();
            }
        }
        return output;
    }

    private String printDelimiterWithWhitespace(Token token) {
        if (token.getType() == Type.RSQUARE || token.getType() == Type.RCURLY)
            return " " + token.getText();
        else
            return token.getText() + " ";
    }
}