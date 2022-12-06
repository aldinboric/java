package week6;

public interface DisjoinSets {
    boolean isConnected(int x, int y);
    void connect(int x, int y);
}
