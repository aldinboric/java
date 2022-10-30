package week2;

import static java.lang.System.out;

public class IntList {
    private int item;
    private IntList next;

    public IntList(int i, IntList n) {
        item = i;
        next = n;
    }

    /** Kreira listu od argumenata args */
    public static IntList of(int... args) {
        IntList first, curr;
        first = curr = new IntList(args[0], null);
        for (int i = 1; i < args.length; i += 1) {
            curr.next = new IntList(args[i], null);
            curr = curr.next;
        }
        return first;
    }

    /** Rekurzivno vraća veličinu liste. */
    public int size() {
        if (next == null)
            return 1;
        return 1 + next.size();
    }

    /** Iterativno vraća veličinu liste. */
    public int sizeIter() {
        IntList ptr = this;
        int size = 0;
        while (ptr != null) {
            size += 1;
            ptr = ptr.next;
        }
        return size;
    }

    /** Rekurzivno vraća i-ti broj liste */
    public int get(int index) {
        if (index > size() || index < 0)
            return 0;
        else if (index == 0)
            return item;
        return next.get(index - 1);
    }

    /** Iterativno vraća i-ti broj liste */
    public int getIter(int index) {
        if (index > size() || index < 0)
            return 0;
        IntList ptr = this;
        while (index != 0) {
            ptr = ptr.next;
        }
        return ptr.item;
    }

    /** Pomoću stare liste pravi novu i inkrementira njene brojeve. */
    public static IntList incrList(IntList L) {
        if (L == null)
            return null;
        return new IntList(L.item * 2, incrList(L.next));
    }

    /** Iterativno */
    public static IntList incrListIter(IntList L) {
        IntList newIntList, currentPtr;
        newIntList = currentPtr = new IntList(L.item * 2, null);
        L = L.next;
        while (L != null) {
            currentPtr.next = new IntList(L.item * 2, null);
            currentPtr = currentPtr.next;
            L = L.next;
        }
        return newIntList;
    }

    /** Inkrementira brojeve trenutne liste. (Destruktivno) */
    public static IntList dincrList(IntList L) {
        if (L == null)
            return null;
        L.item *= 2;
        dincrList(L.next);
        return L;
    }

    /** Iterativno */
    public static IntList dincrListIter(IntList L) {
        IntList first = L;
        while (L != null) {
            L.item *= 2;
            L = L.next;
        }
        return L;
    }

    /** Uklanja sve N brojeve iz liste. */
    public static IntList removeAll(IntList L, int n) {
        if (L == null)
            return null;
        else if (L.item == n)
            return removeAll(L.next, n);
        return new IntList(L.item, removeAll(L.next, n));
    }

    /** Iterativno */
    public static IntList removeAllIter(IntList L, int n) {
        IntList result, curr;
        result = curr = null;
        while (L != null) {
            if (L.item != n) {
                if (result == null)
                    result = curr = new IntList(L.item, null);
                else {
                    curr.next = new IntList(L.item, null);
                    curr = curr.next;
                }
            }
            L = L.next;
        }
        return result;
    }

    /** Destruktivno rekurzivno. */
    public static IntList dremoveAll(IntList L, int n) {
        if (L == null)
            return null;
        else if (L.item == n)
            return dremoveAll(L.next, n);
        else
            L.next = dremoveAll(L.next, n);
        return L;
    }

    /** Iterativno */
    public static IntList dremoveAllIter(IntList L, int n) {
        IntList result, curr;
        result = curr = null;
        while (L != null) {
            if (L.item != n) {
                if (result == null)
                    result = curr = L;
                else {
                    curr.next = L;
                    curr = curr.next;
                }
            }
            L = L.next;
        }
        curr.next = L;
        return result;
    }

    /** Printa listu. */
    public String print() {
        String result = "";
        IntList ptr = this;
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
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);

        / Size metoda. /
        out.println(L.size());
        out.println(L.sizeIter());

        / Get metoda. /
        out.println(L.get(0));
        out.println(L.get(1));

        / incr i dincr /
        IntList L1 = incrList(L);
        L1.print();
        dincrList(L);
        L.print();
        IntList L2 = incrList(L);
        L2.print();

        / of /
        IntList L3 = of(1, 2, 3);
        L3.print();
        dincrListIter(L3);
        L3.print();
        */

        /* removeAll */
        // IntList L4 = of(2, 1, 2, 9, 2);
        // IntList L5 = removeAllIter(L4, 2);
        // L5.print();
        IntList L6 = of(1, 2, 3, 1, 1, 0, 1);
        L6 = dremoveAllIter(L6, 1);
        L6.print();
    }
}
