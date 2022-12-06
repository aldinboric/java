package week6;

public class DisjointSet implements DisjoinSets {
    private final int[] id;

    public DisjointSet(int size) {
        id = new int[size];
        for (int i = 0; i < size; i += 1)
            id[i] = -1;
    }

    @Override
    public boolean isConnected(int x, int y) {
        return root(x) == root(y);
    }

    @Override
    public void connect(int x, int y) {
        id[root(y)] = root(x);
    }

    public int root(int n) {
        while (id[n] != -1)
            n = id[n];
        return n;
    }
}
