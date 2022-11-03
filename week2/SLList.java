package week2;

import static java.lang.System.out;

public class SLList {
    private static class IntNode {
        int item;
        IntNode next;

        IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode sentinel;
    private int size;

    public SLList() {
        sentinel = new IntNode(-56535, null);
        size = 0;
    }

    /** Konstruktor koji pravi listu od argumenata. */
    public SLList(int... args) {
        this();
        for (int i = 0; i < args.length; i += 1)
            addLast(args[i]);
    }

    /** Metoda koja pravi listu od elemenata. */
    public static SLList of(int... args) {
        SLList lst = new SLList();
        for (int i = 0; i < args.length; i += 1)
            lst.addLast(args[i]);
        return lst;
    }

    /** Metoda koja pravi listu od niza. */
    public static SLList list(int[] arr) {
        SLList lst = new SLList();
        for (int i = 0; i < arr.length; i += 1) {
            lst.addLast(arr[i]);
        }
        return lst;
    }

    /** Dodaje novi čvor na početak liste. */
    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    /** Vraća item prvog čvora. */
    public int getFirst() {
        if (sentinel.next == null)
            return 0;
        return sentinel.next.item;
    }

    /** Dodaje novi čvor na kraj liste. */
    public void addLast(int x) {
        IntNode ptr = sentinel;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = new IntNode(x, null);
        size += 1;
    }

    /** Vraća item zadnjeg čvora. */
    public int getLast() {
        if (sentinel.next == null)
            return 0;
        IntNode ptr = sentinel.next;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        return ptr.item;
    }

    /** Vraća veličinu liste. */
    public int size() {
        class HelperCl {
            int helperFn(IntNode n) {
                if (n == null)
                    return 0;
                return 1 + helperFn(n.next);
            }
        }
        return new HelperCl().helperFn(sentinel.next);
    }

    /** Dodaje novi čvor (broj) na kraj liste i kvadrira sve brojeve prije njega.
      * size() se mora pozvati samo jedanput! */
    public void squareAdd(int x) {
        if (sentinel.next == null) {
            addLast(x);
            return;
        }
        IntNode ptr = sentinel.next;
        while (ptr.next != null) {
            ptr.item *= 2;
            ptr = ptr.next;
        }
        ptr.item *= 2;
        ptr.next = new IntNode(x, null);
    }

    /** Briše prvi čvor liste. */
    public void deleteFirst() {
        if (sentinel.next == null)
            return;
        IntNode tmp = sentinel.next.next;
        sentinel.next = tmp;
    }

    /** Printa listu. */
    public String print() {
        if (sentinel.next == null)
            return "[]";
        String result = "";
        IntNode ptr = sentinel.next;
        while (ptr.next != null) {
            result += ptr.item + ", ";
            ptr = ptr.next;
        }
        result = "[" + result + ptr.item + "]";
        out.println(result);
        return result;
    }

    public static void main(String[] args) {
        /*
        SLList L = new SLList();
        L.addFirst(1);
        L.addFirst(2);
        L.addFirst(3);

        out.println(L.getFirst());
        out.println(L.size());
        L.addLast(0);
        out.println(L.getLast());
        L.print();
        */

        SLList L2 = new SLList(1, 2, 3, 4, 5);
        L2.print();

        SLList L3 = of(1, 2, 3, 4);
        L3.print();

        SLList L4 = list(new int[]{1, 2, 3});
        L4.print();
        L4.squareAdd(8);
        L4.print();
        for (int i = 0; i < 5; i += 1)
            L4.deleteFirst();
        out.println(L4.print());
    }
}
