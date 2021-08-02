package main.java.Printer;

import java.util.List;

import main.java.Token;

public interface Printer {
    public String print(List<Token> tokens);
}