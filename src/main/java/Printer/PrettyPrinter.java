package main.java.Printer;

import java.util.List;

import main.java.Token;
import main.java.Token.Type;

public class PrettyPrinter implements Printer {

    private final String INDENT;

    public PrettyPrinter() {
        INDENT = "  ";
    }

    public PrettyPrinter(String indent) {
        this.INDENT = indent;
    }

    @Override
    public String print(List<Token> tokens) {
        return print(tokens, 0);
    }

    public String print(List<Token> tokens, int indentLevel) {
        Type nextTokenType = tokens.get(0).getType();

        if (nextTokenType == Type.LCURLY || nextTokenType == Type.LSQUARE)
            return printArrayOrObject(tokens, indentLevel);

        String output = "";

        while (!tokens.isEmpty()) {
            nextTokenType = tokens.get(0).getType();
            if (nextTokenType == Type.COMMA || nextTokenType == Type.RSQUARE)
                break;
            else if (nextTokenType == Type.COLON) {
                output += getNextToken(tokens).getText() + " ";
            } else {
                output += getNextToken(tokens).getText();
            }
        }
        return output;
    }

    private String printArrayOrObject(List<Token> tokens, int indentLevel) {
        String output = "";

        Token currentToken = getNextToken(tokens);

        output += currentToken.getText() + '\n';

        while (!tokens.isEmpty()) {
            Type nextTokenType = tokens.get(0).getType();

            if (nextTokenType == Type.RSQUARE || nextTokenType == Type.RCURLY)
                break;
            else if (nextTokenType == Type.COMMA) {
                output += getNextToken(tokens).getText() + '\n';
            } else {
                output += indent(indentLevel + 1) + print(tokens, indentLevel + 1);
            }
        }

        currentToken = getNextToken(tokens);
        output += '\n' + indent(indentLevel) + currentToken.getText();

        return output;
    }

    private Token getNextToken(List<Token> tokens) {
        Token currentToken = tokens.get(0);
        tokens.remove(0);
        return currentToken;
    }

    private String indent(int level) {
        return INDENT.repeat(level);
    }
}
