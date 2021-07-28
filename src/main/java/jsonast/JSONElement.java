package main.java.jsonast;

import main.java.JSONVisitor;

interface JSONElement {
    public void accept(JSONVisitor visitor);
}