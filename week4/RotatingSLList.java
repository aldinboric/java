package week4;

import week2.SLList;

public class RotatingSLList extends SLList {
    public RotatingSLList(int... args) {
        super(args);
    }

    public void rotateRight() {
        addFirst(deleteLast());
    }

    public static void main(String[] args) {
        RotatingSLList SL = new RotatingSLList(1, 2, 3, 4, 5);
        SL.print();
        SL.rotateRight();
        SL.print();
    }
}
