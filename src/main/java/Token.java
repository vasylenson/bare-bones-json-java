package main.java;

import java.util.EnumSet;

public class Token {
    public enum Type {
        LSQUARE("["), RSQUARE("]"),

        LCURLY("{"), RCURLY("}"),

        COMMA(","), COLON(":"),
        // QUOTE ("\""), //probably should be a part of STRING

        NULL("null"), TRUE("true"), FALSE("false"),

        STRING(null), INTEGER(null);

        private final String text;

        private Type(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }

        public char getChar() {
            return text.charAt(0);
        }

        public boolean isLiteral() {
            return this == STRING || this == INTEGER || this == NULL || this == TRUE || this == FALSE;
        }

        public boolean isDelimiter() {
            return !this.isLiteral();
        }

        public static EnumSet<Type> getDelimiters() {
            EnumSet<Type> literals = EnumSet.of(STRING, INTEGER);
            return EnumSet.complementOf(literals);
        }
    }

    private final Type type;
    private final String text;

    public Token(Type type) throws Exception {
        this.type = type;

        if (type.getText() == null) {
            throw new Exception("Literal Token content missing. Use the constructor with content String");
        } else {
            this.text = type.getText();
        }
    }

    public Token(Type type, String text) {
        this.type = type;
        this.text = text;
    }

    public Type getType() {
        return type;
    }

    public String getText() {
        return text;
    }

    public String toString() {
        String string = "<token " + type.toString();
        if (type.isLiteral()) {
            string += " \"" + getText() + "\"";
        }
        string += ">";
        return string;
    }

}