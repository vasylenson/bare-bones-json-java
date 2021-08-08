package main.java;

import java.util.ArrayList;
import java.util.EnumSet;
import java.lang.Character;

import main.java.Token.Type;

public class Lexer {

    private static EnumSet<Type> delimiters = Token.Type.getDelimiters();
    private static EnumSet<Type> wordLiterals = EnumSet.of(Type.NULL, Type.TRUE, Type.FALSE);

    public static ArrayList<Token> lex(String json) throws Exception {
        ArrayList<Token> tokens = new ArrayList<Token>();

        for (int currentPos = 0; currentPos < json.length(); currentPos++) {
            char currentChar = json.charAt(currentPos);

            // skip whitespace
            if (Character.isWhitespace(currentChar)) {
                continue;
            }

            Token token;

            // match against delimiters
            token = matchDelimiter(currentChar);
            if (token != null) {
                tokens.add(token);
                continue;
            }

            // match word literals (null, bool, false)
            token = matchWordLiteral(json, currentPos);
            if (token != null) {
                tokens.add(token);
                currentPos += token.getText().length() - 1;
                continue;
            }

            // match string literal
            if (currentChar == '\"') {
                token = matchStringLiteral(json, currentPos + 1);
                tokens.add(token);
                currentPos += token.getText().length() - 1;
                continue;
            }

            // match integer literal
            token = matchIntegerLiteral(json, currentPos);
            if (token != null) {
                tokens.add(token);
                currentPos += token.getText().length() - 1;
                continue;
            }

            throw new Exception("Lexing error, token not matched");
        }

        return tokens;
    }

    public static Token matchDelimiter(char c) {

        for (var delimiter : delimiters)
            if (c == delimiter.getChar())
                return new Token(delimiter, delimiter.getText());

        return null;
    }

    private static Token matchWordLiteral(String json, int currentPos) {
        for (Token.Type word : wordLiterals) {
            if (json.startsWith(word.getText(), currentPos))
                return new Token(word, word.getText());
        }
        return null;
    }

    private static Token matchStringLiteral(String json, int offset) throws Exception {
        String content = "\"";

        for (int currentPos = offset; currentPos < json.length(); currentPos++) {
            char currentChar = json.charAt(currentPos);
            content += currentChar;

            if (currentChar == '\"')
                return new Token(Type.STRING, content);
        }

        throw new Exception("Malformed string literal: no closing quote.");
    }

    private static Token matchIntegerLiteral(String json, int offset) throws Exception {
        String content = "";

        char currentChar = json.charAt(offset);
        if (currentChar == '+' || currentChar == '-') {
            content += currentChar;
            offset++;
        }

        for (int currentPos = offset; currentPos < json.length(); currentPos++) {
            currentChar = json.charAt(currentPos);

            boolean isDigit = Character.isDigit(currentChar);
            boolean isE = currentChar == 'e' || currentChar == 'E';
            boolean isDotOrSign = currentChar == '.' || currentChar == '+' || currentChar == '-';
            if (!(isDigit || isE || isDotOrSign))
                break;

            content += currentChar;
        }

        if (content.length() == 0)
            return null;

        if (!content.matches("^[\\+, -]?\\d+(\\.\\d+)?([e, E]([\\+, -])?\\d+)?$"))
            throw new Exception("Malformed number literal: " + content);

        return new Token(Type.NUMBER, content);
    }
}