package main.java.Printer;

public class DefaultWriter implements JSONWriter {

    private final String indent;

    private String out = "";
    private int indentLevel = 0;

    public DefaultWriter(String indent) {
        this.indent = indent;
    }

    @Override
    public String getOutpuString() {
        return out;
    }

    @Override
    public void putPrimitive() {
        formatPrimitive("null");
    }

    @Override
    public void putPrimitive(boolean bool) {
        formatPrimitive(String.valueOf(bool));
    }

    @Override
    public void putPrimitive(Number number) {
        formatPrimitive(String.valueOf(number));
    }

    @Override
    public void putPrimitive(String string) {
        formatPrimitive("\"" + string + "\"");
    }

    @Override
    public void putKey(String key) {
        out += "\"" + key + "\": ";
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