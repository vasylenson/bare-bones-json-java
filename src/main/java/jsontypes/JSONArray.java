package main.java.jsontypes;

public class JSONArray implements JSONElement {

    private JSONElement items[];
    
    public void accept(JSONVisitor visitor) {
        visitor.visit(this);
    }
}
