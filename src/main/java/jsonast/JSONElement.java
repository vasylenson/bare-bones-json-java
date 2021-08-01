package main.java.jsonast;
import main.java.Visitor;

public interface JSONElement {
    public void accept(Visitor visitor);
}