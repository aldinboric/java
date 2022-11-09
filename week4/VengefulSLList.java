package week4;

import week2.SLList;

public class VengefulSLList extends SLList {
    SLList deletedItems = new SLList();

    public VengefulSLList(int... args) {
        super(args);
    }

    @Override
    public int deleteLast() {
        int x = super.deleteLast();
        deletedItems.addLast(x);
        return x;
    }

    public void printDeleted() {
        deletedItems.print();
    }

    public static void main(String[] args) {
        VengefulSLList L = new VengefulSLList(1, 2, 3, 4, 5);

        L.print();

        for (int i = 0; i < 3; i += 1)
            L.deleteLast();

        L.print();
        L.printDeleted();
    }
}