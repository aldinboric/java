package exam.prep04;

import static java.lang.System.out;

public class DMSList {
    private IntNode sentinel;

    public DMSList() {
        sentinel = new IntNode(-1000, null);
    }

    public class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode h) {
            item = i;
            next = h;
        }

        public int max() {
            return Math.max(item, next.max());
        }
    }

    public int maxNumberInList() {
        int maxNumber = 0;
        for (IntNode ptr = sentinel.next; ptr != null; maxNumber = Math.max(maxNumber, ptr.item), ptr = ptr.next);
        return maxNumber;
    }

    public int max() {
        return sentinel.next.max();
    }

    public void insertFront(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
    }

    public static void main(String[] args) {
        DMSList D = new DMSList();
        D.insertFront(7);
        D.insertFront(6);
        D.insertFront(5);
        out.println(D.maxNumberInList());
    }
}
