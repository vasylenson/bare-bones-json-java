package main.java;

import main.java.JSONTypes.JSONElement;
import main.java.Printer.DefaultWriter;
import main.java.Printer.TokenInterpreter;

public class BBJSON {

    public JSONElement fromString(String json) throws Exception {
        JSONTreeBuilder builder = new JSONTreeBuilder();
        TokenInterpreter tokens = new TokenInterpreter(Lexer.lex(json));
        tokens.writeTo(builder);
        return builder.getTree();
    }

    public String print(JSONElement json) {
        DefaultWriter writer = new DefaultWriter("  ");
        TokenInterpreter tokens = new TokenInterpreter(new TreeTokenizer().tokenize(json));
        tokens.writeTo(writer);
        return writer.getOutpuString();
    }
}