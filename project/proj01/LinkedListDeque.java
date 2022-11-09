package project.proj01;

import static java.lang.System.out;

/** Uvezana generična lista sa oba kraja. */
public class LinkedListDeque<T> {
    /** Podklasa koja predstavlja čvorove liste. */
    private class LLDNode {
        String desc;
        T item;
        LLDNode prev;
        LLDNode next;

        /** Konstruktor koji pravi sentinel (prvi) čvor. */
        LLDNode() {
            desc = "<sentinel node>";
            prev = this;
            next = this;
        }

        /** Konstruktor koji pravi običan čvor. */
        LLDNode(LLDNode p, T i, LLDNode n) {
            desc = "<node>";
            item = i;
            prev = p;
            next = n;
        }
    }

    private LLDNode sentinel;
    private int size;

    /** Konstruktor koji pravi novu praznu listu. */
    public LinkedListDeque() {
        sentinel = new LLDNode();
    }

    /** Provjerava da li je lista prazna. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Vraća trenutnu veličinu liste. */
    public int size() {
        return size;
    }

    /** Dodaje novi čvor na početak liste. */
    public void addFirst(T item) {
        size += 1;
    }

    /** Dodaje novi čvor na kraj liste. */
    public void addLast(T item) {
        size += 1;
    }

    /** Briše prvi čvor liste i vraća njegov item. */
    public T removeFirst() {
        LLDNode tmp = sentinel.next;
        sentinel.next = tmp.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        tmp.prev = tmp.next = null;
        return tmp.item;
    }

    /** Briše zadnji čvor liste i vraća njegov item. */
    public T removeLast() {
        LLDNode tmp = sentinel.prev;
        sentinel.prev = tmp.prev;
        sentinel.prev.next = sentinel;
        size -= 1;
        tmp.prev = tmp.next = null;
        return tmp.item;
    }

    /** Vraća i-ti item liste iterativno. */
    public T get(int index) {
        if (index >= size || index < 0)
            return null;
        else if (index == size - 1)
            return sentinel.prev.item;
        LLDNode ptr = sentinel.next;
        for(; index != 0; index -= 1, ptr = ptr.next);
        return ptr.item;
    }

    /** Vraća i-ti item liste rekurzivno. */
    public T getRecursive(int index) {
        if (index >= size || index < 0)
            return null;
        else if (index == size - 1)
            return sentinel.prev.item;
        class helperCl {
            T helperFn(LLDNode ptr, int index) {
                if (index == 0)
                    return ptr.item;
                return helperFn(ptr.next, index - 1);
            }
        }
        return new helperCl().helperFn(sentinel.next, index);
    }

    /** Vraća listu u obliku stringa. */
    @Override
    public String toString() {
        String result = "< ";
        for(LLDNode ptr = sentinel.next; ptr != null; result += ptr.item + " ", ptr = ptr.next);
        return result + ">";
    }

    /** Printa listu. */
    public void printDeque() {
        out.println(this.toString());
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> NL = new LinkedListDeque<>();
        out.println(NL.isEmpty());
    }
}