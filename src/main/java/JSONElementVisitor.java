package main.java;

import main.java.JSONTypes.*;

public interface JSONElementVisitor {
    public void visit(JSONNull element);

    public void visit(JSONBool element);

    public void visit(JSONNumber element);

    public void visit(JSONString element);

    public void visit(JSONArray element);

    public void visit(JSONObject element);
}