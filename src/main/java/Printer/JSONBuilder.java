package main.java.Printer;

public interface JSONBuilder {

    public void putNull();

    public void putTrue();

    public void putFalse();

    public void putNumber(String representation);

    public void putString(String representation);

    public void putKey(String representation);

    public void startArray();

    public void endArray();

    public void startObject();

    public void endObject();
}