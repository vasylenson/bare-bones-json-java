package main.java.jsontypes;

public class JSONNull implements JSONElement {

    public void accept(JSONVisitor visitor) {
        visitor.visit(this);
    }

}