package main.java.jsonast;
import main.java.JSONVisitor;

public interface JSONElement {
    public void accept(JSONVisitor visitor);
}