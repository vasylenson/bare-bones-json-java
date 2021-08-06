package main.java.JSONTypes;

import main.java.JSONElementVisitor;

public interface JSONElement {
    public void accept(JSONElementVisitor visitor);

    public boolean equals(JSONElement other);
}