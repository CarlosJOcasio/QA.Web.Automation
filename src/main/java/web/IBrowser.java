package web;

public interface IBrowser {
    void open(TestStep step);
    void close();
    String toString();
    void normal();
    void fastLoad();
}