package main.java.jsonast;

import main.java.JSONElementVisitor;

public interface JSONElement {
    public void accept(JSONElementVisitor visitor);
}