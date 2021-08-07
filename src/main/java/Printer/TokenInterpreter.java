package main.java.Printer;

import java.util.List;

import main.java.Token;

public class TokenInterpreter {
    private final List<Token> tokens;

    private JSONBuilder out = null;
    private String deferredString = null;

    public List<Token> getTokens() {
        return tokens;
    }

    public TokenInterpreter(List<Token> tokens) {
        this.tokens = tokens;
    }

    public void writeTo(JSONBuilder writer) {
        out = writer;

        for (Token token : tokens) {
            handle(token);
        }
    }

    private void handle(Token token) {
        switch (token.getType()) {
        case NULL:
            out.putNull();
            break;
        case FALSE:
            out.putFalse();
            break;
        case TRUE:
            out.putTrue();
            break;
        case STRING:
            if (deferredString != null)
                throw new IllegalStateException("Out of place string literal");
            deferredString = token.getText();
            break;
        case NUMBER:
            out.putNumber(token.getText());
            break;
        case LSQUARE:
            out.startArray();
            break;
        case RSQUARE:
            tryPutDeferredString();
            out.endArray();
            break;
        case LCURLY:
            out.startObject();
            break;
        case RCURLY:
            tryPutDeferredString();
            out.endObject();
            break;
        case COLON:
            out.putKey(deferredString);
            deferredString = null;
            break;
        case COMMA:
            tryPutDeferredString();
            break;
        default:
            break;
        }
    }

    private void tryPutDeferredString() {
        if (deferredString != null) {
            out.putString(deferredString);
            deferredString = null;
        }
    }
}