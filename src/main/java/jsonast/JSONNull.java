package main.java.jsonast;

import main.java.Visitor;

public class JSONNull implements JSONElement {

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}