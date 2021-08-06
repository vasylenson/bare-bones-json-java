package main.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import main.java.JSONTypes.*;
import main.java.Token.Type;

public class TreeTokenizer implements JSONElementVisitor {

    private ArrayList<Token> tokens;

    // TODO: make the whole thing
    public ArrayList<Token> tokenize(JSONElement element) {
        tokens = new ArrayList<Token>();
        element.accept(this);
        return tokens;
    }

    @Override
    public void visit(JSONNull element) {
        safeAddStaticToken(Type.NULL);
    }

    @Override
    public void visit(JSONBool element) {
        Type type = element.getValue() ? Type.TRUE : Type.FALSE;
        safeAddStaticToken(type);
    }

    @Override
    public void visit(JSONNumber element) {
        String content = String.valueOf(element.getValue());
        addToken(Type.NUMBER, content);
    }

    @Override
    public void visit(JSONString element) {
        String content = element.getValue();
        addToken(Type.STRING, content);
    }

    @Override
    public void visit(JSONArray element) {
        safeAddStaticToken(Type.LSQUARE);

        // TODO get rid of bloody arrays
        JSONElement[] arrayItems = (JSONElement[]) element.getItems().toArray();
        arrayItems[0].accept(this);
        for (int i = 1; i < arrayItems.length; i++) {
            safeAddStaticToken(Type.COMMA);

            JSONElement item = arrayItems[i];
            item.accept(this);
        }

        safeAddStaticToken(Type.RSQUARE);
    }

    @Override
    public void visit(JSONObject element) {
        safeAddStaticToken(Type.LCURLY);

        // TODO: figure out iteration protocols and write a sane join
        Iterator<Entry<String, JSONElement>> items = element.items.entrySet().iterator();
        while (items.hasNext()) {
            Entry<String, JSONElement> entry = items.next();
            renderObjectEntry(entry);

            if (items.hasNext())
                safeAddStaticToken(Type.COMMA);
        }

        safeAddStaticToken(Type.RCURLY);
    }

    private void renderObjectEntry(Entry<String, JSONElement> entry) {
        addToken(Type.STRING, entry.getKey());
        safeAddStaticToken(Type.COLON);
        entry.getValue().accept(this);
    }

    private void addToken(Type type, String content) {
        tokens.add(new Token(type, content));
    }

    private void safeAddStaticToken(Type type) {
        tokens.add(new Token(type, type.getText()));
    }
}
