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

    /** @source <a href="https://www.kartikkapur.com/documents/mt1.pdf#page=7">Zadatak</a> */
    public void addAdjacent() {
        if (next == null)
            return;
        else if (item == next.item) {
            item *= 2;
            next = next.next;
            addAdjacent();
        } else
            next.addAdjacent();
    }

    /** Reverse (N) */
    public static IntList reverseNonDestructive(IntList L) {
        class helperCl {
            IntList helperFn(IntList L, IntList sofar) {
                if (L == null)
                    return sofar;
                return helperFn(L.next, new IntList(L.item, sofar));
            }
        }
        return new helperCl().helperFn(L, null);
    }

    public static IntList reverseNonDestructiveIter(IntList L) {
        if (L == null)
            return null;
        IntList result = null;
        while (L != null) {
            result = new IntList(L.item, result);
            L = L.next;
        }
        return result;
    }

    /** Reverse (D) */
    public static IntList reverseDestructive(IntList L) {
        class helperCl {
            IntList helperFn(IntList L, IntList prev) {
                if (L == null)
                    return prev;
                IntList tmp = L.next;
                L.next = prev;
                return helperFn(tmp, L);
            }
        }
        return new helperCl().helperFn(L, null);
    }

    public static IntList reverseDestructiveIter(IntList L) {
        IntList prev = null;
        while (L != null) {
            IntList tmp = L.next;
            L.next = prev;
            prev = L;
            L = tmp;
        }
        return prev;
    }

    /** Ubacivanje broja u listu na željenu poziciju. */
    public static IntList insertRecursive(IntList L, int item, int position) {
        if (L == null || position < 0);
        else if (position != 0 && L.next != null)
            insertRecursive(L.next, item, position - 1);
        else if (position > 0)
            L.next = new IntList(item, null);
        else {
            int tmp = L.item;
            L.item = item;
            L.next = new IntList(tmp, L.next);
        }
        return L;
    }

    public static IntList insertRecursiveIter(IntList L, int item, int position) {
        if (L == null || position < 0)
            return L;
        IntList first = L;
        while (position != 0 && L.next != null) {
            position -= 1;
            L = L.next;
        }
        if (position > 0)
            L.next = new IntList(item, null);
        else {
            int tmp = L.item;
            L.item = item;
            L.next = new IntList(tmp, L.next);
        }
        return first;
    }

    /** Pomakni listu za jedan u lijevo. */

    public static IntList shiftListDestructive(IntList L) {
        class helperCl {
            IntList helperFn(IntList L, IntList first) {
                if (L.next == null) {
                    IntList tmp = first.next;
                    L.next = first;
                    first.next = null;
                    return tmp;
                }
                return helperFn(L.next, first);
            }
        }
        return new helperCl().helperFn(L, L);
    }

    public static IntList shiftListDestructiveIter(IntList L) {
        if (L == null)
            return null;
        int tmp = L.item;
        IntList first = L.next;
        while (L.next != null)
            L = L.next;
        L.next = new IntList(tmp, null);
        return first;
    }

    /** Pronađi index prvog broja koji je jednak x-u i vrati ga.
      * Ukoliko taj broj ne postoji vrati -1. */
    public static int findFirst(IntList L, int x) {
        class helperCl {
            int helperFn(IntList L, int x, int index) {
                if (L == null)
                    return -1;
                else if (L.item == x)
                    return index;
                return helperFn(L.next, x, index + 1);
            }
        }
        return new helperCl().helperFn(L, x, 0);
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

        / removeAll /
        // IntList L4 = of(2, 1, 2, 9, 2);
        // IntList L5 = removeAllIter(L4, 2);
        // L5.print();
        IntList L6 = of(1, 2, 3, 1, 1, 0, 1);
        L6 = dremoveAllIter(L6, 1);
        L6.print();

        / addAdjacent /
        IntList L7 = of(0, 1, 1, 2, 4, 8, 12, 12, 24, 30, 32);
        L7.addAdjacent();
        L7.print();

        IntList L8 = of (1, 1, 2, 3);
        L8.addAdjacent();
        L8.print();

        / Reverse (N) i (D) /
        IntList L9 = of(1, 2, 3, 4, 5);
        IntList L9R = reverseNonDestructive(L9);
        // L9R.print();
        IntList L9RI = reverseNonDestructiveIter(L9);
        // L9RI.print();

        L9.print();
        IntList L10 = reverseDestructive(L9);
        L9.print();
        L10.print();

        IntList L11 = of(1, 2, 3, 4);

        L11.print();
        IntList L12 = reverseDestructive(L11);
        L11.print();
        L12.print();

        IntList L13 = of(1, 2, 3);
        IntList L14 = insertRecursive(L13, 0, 0);
        L14 = insertRecursive(L13, 5, 5);
        L13 = insertRecursive(L13, 4, 4);
        L13.print();
        L14.print();
        */

        /* shiftList */
        IntList L15 = of(5, 4, 9, 1, 2, 3);
        L15.print();
        L15 = shiftListDestructive(L15);
        L15.print();

        out.println(findFirst(L15, 6));
    }
}
