package main.java.jsontypes;

public class JSONBool implements JSONElement {

    private boolean value;

    public void accept(JSONVisitor visitor) {
        visitor.visit(this);
    }
    
}
