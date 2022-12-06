package week6;

public class MainSet {
    public static void main(String[] args) {
        DisjointSet DS = new DisjointSet(7);
        DS.connect(0, 1);
        DS.connect(0, 2);
        DS.connect(3, 4);
        DS.connect(1, 4);
        DS.connect(5, 6);
        DS.connect(4, 6);

    }
}
