package main.java.Printer;

public interface JSONWriter {

    public String getOutpuString();

    public void putPrimitive();

    public void putPrimitive(boolean bool);

    public void putPrimitive(Number number);

    public void putPrimitive(String string);

    public void putKey(String key);

    public void startArray();

    public void endArray();

    public void startObject();

    public void endObject();
}