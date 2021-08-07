package main.java.Printer;

public class DefaultWriter implements JSONBuilder {

    private final String indent;
    private final String itemSeparator;

    private String out = "";
    private int indentLevel = 0;
    private boolean separate = false;
    private boolean nextItemNoIndent = false;

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
        putSeparatorIfNeeded();
        indent();
        out += key + ": ";
        nextItemNoIndent = true;
        separate = false;
    }

    @Override
    public void startArray() {
        putSeparatorIfNeeded();
        indent();
        out += "[";
        newline();
        indentLevel++;
        separate = false;
    }

    @Override
    public void endArray() {
        indentLevel--;
        newline();
        indent();
        out += "]";
    }

    @Override
    public void startObject() {
        putSeparatorIfNeeded();
        indent();
        out += "{";
        newline();
        indentLevel++;
        separate = false;
    }

    @Override
    public void endObject() {
        indentLevel--;
        newline();
        indent();
        out += "}";
    }

    private void formatPrimitive(String primitive) {
        putSeparatorIfNeeded();
        indent();
        out += primitive;
    }

    private void putSeparatorIfNeeded() {
        if (separate) {
            out += itemSeparator;
        } else {
            separate = true;
        }
    }

    private void newline() {
        out += "\n";
    }

    private void indent() {
        if (nextItemNoIndent) {
            nextItemNoIndent = false;
            return;
        }
        out += indent.repeat(indentLevel);
    }
}