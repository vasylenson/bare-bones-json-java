package main.java.jsontypes;

public class JSONInteger implements JSONElement {

    private int value;

    public void accept(JSONVisitor visitor) {
        visitor.visit(this);
    }
    
}
