package main.java.Printer;

public class DefaultWriter implements JSONBuilder {

    private final String indent;
    private final String itemSeparator;

    private String out = "";
    private int indentLevel = 0;
    private boolean separate = false;

    public DefaultWriter() {
        this.indent = "  ";
        this.itemSeparator = ",\n";
    }

    public DefaultWriter(String indent) {
        this.indent = indent;
        this.itemSeparator = ",\n";
    }

    public DefaultWriter(String indent, String itemSeparator) {
        this.indent = indent;
        this.itemSeparator = itemSeparator;
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
        separate = false;
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
        separate = false;
    }

    @Override
    public void endObject() {
        indentLevel--;
        out += "}";
        newline();
    }

    private void formatPrimitive(String primitive) {
        putSeparatorIfNeeded();
        indent();
        out += primitive + ",";
        newline();
    }

    private void putSeparatorIfNeeded() {
        if (separate) {
            out += itemSeparator;
        } else {
            separate = false;
        }
    }

    private void newline() {
        out += "\n";
    }

    private void indent() {
        out += indent.repeat(indentLevel);
    }
}