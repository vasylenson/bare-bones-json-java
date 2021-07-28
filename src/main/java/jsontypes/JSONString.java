package main.java.jsontypes;

public class JSONString implements JSONElement {
    
    String value;

    public void accept(JSONVisitor visitor) {
        visitor.visit(this);
    }
}