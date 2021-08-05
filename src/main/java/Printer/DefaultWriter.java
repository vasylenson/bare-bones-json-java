package main.java.Printer;

public class DefaultWriter implements JSONBuilder {

    private final String indent;

    private String out = "";
    private int indentLevel = 0;

    public DefaultWriter(String indent) {
        this.indent = indent;
    }

    public String getOutpuString() {
        return out;
    }

    @Override
    public void putNull() {
        formatPrimitive("null");
    }

    @Override
    public void putTrue() {
        formatPrimitive("true");
    }

    @Override
    public void putFalse() {
        formatPrimitive("false");
    }

    @Override
    public void putNumber(String representation) {
        formatPrimitive(representation);
    }

    @Override
    public void putString(String representation) {
        formatPrimitive(representation);
    }

    @Override
    public void putKey(String key) {
        out += key + ": ";
    }

    @Override
    public void startArray() {
        out += "[";
        newline();
        indentLevel++;
    }

    @Override
    public void endArray() {
        indentLevel--;
        out += "]";
        newline();
    }

    @Override
    public void startObject() {
        out += "{";
        newline();
        indentLevel++;
    }

    @Override
    public void endObject() {
        indentLevel--;
        out += "}";
        newline();
    }

    private void formatPrimitive(String primitive) {
        indent();
        out += primitive + ",";
        newline();
    }

    private void newline() {
        out += "\n";
    }

    private void indent() {
        out += indent.repeat(indentLevel);
    }
}