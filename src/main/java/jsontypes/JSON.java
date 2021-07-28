package main.java.jsontypes;

interface JSONElement {
    public void accept(JSONVisitor visitor);
}

interface JSONVisitor {
    public void visit(JSONNull element);
    public void visit(JSONBool element);
    public void visit(JSONInteger element);
    public void visit(JSONString element);
    public void visit(JSONArray element);
    public void visit(JSONObject element);
}