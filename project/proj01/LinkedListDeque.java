package project.proj01;

import static java.lang.System.out;

/* SType => Static Type. */

/** Duplo uvezana generična lista. */
public class LinkedListDeque<SType> {
    /** Čvor duplo uvezane liste. */
    private class ListNode {
        String _desc;
        SType _item;
        ListNode _prev;
        ListNode _next;

        /** Konstruktor za _sentinel (prvi) čvor. */
        ListNode() {
            _desc = "<_sentinel node>";
            _item = null;
            _prev = _next = this;
        }

        /** Konstruktor za normalni čvor. */
        ListNode(SType item, ListNode prev, ListNode next) {
            _desc = "<node>";
            _item = item;
            _prev = prev;
            _next = next;
        }
    }

    private ListNode _sentinel;
    private int _size;

    /** Konstruktor za početnu praznu listu. */
    public LinkedListDeque() {
        _sentinel = new ListNode();
        _size = 0;
    }

    /** Provjerava da li je lista prazna. */
    public boolean isEmpty() {
        return _size == 0;
    }

    /** Vraća trenutnu veličinu liste. */
    public int size() {
        return _size;
    }

    /** Dodaje novi čvor na početak liste. */
    public void addFirst(SType item) {
        _sentinel._next = new ListNode(item, _sentinel, _sentinel._next);
        _sentinel._next._next._prev = _sentinel._next;
        _size += 1;
    }

    /** Dodaje novi čvor na kraj liste. */
    public void addLast(SType item) {
        _sentinel._prev = new ListNode(item, _sentinel._prev, _sentinel);
        _sentinel._prev._prev._next = _sentinel._prev;
        _size += 1;
    }

    /** Briše prvi čvor liste. */
    public SType removeFirst() {
        if (_size == 0)
            return null;
        ListNode tmp = _sentinel._next;
        _sentinel._next = tmp._next;
        _sentinel._next._prev = _sentinel;
        _size -= 1;
        tmp._prev = tmp._next = null;
        return tmp._item;
    }

    /** Briše zadnji čvor liste. */
    public SType removeLast() {
        if (_size == 0)
            return null;
        ListNode tmp = _sentinel._prev;
        tmp._prev._next = _sentinel;
        _sentinel._prev = tmp._prev;
        _size -= 1;
        tmp._prev = tmp._next = null;
        return tmp._item;
    }

    /** Vraća i-ti item liste. */
    public SType get(int index) {
        if (index >= _size || index < 0)
            return null;
        else if (index == _size - 1)
            return _sentinel._prev._item;
        ListNode ptr = _sentinel._next;
        for(; index != 0; ptr = ptr._next, index -= 1);
        return ptr._item;
    }

    /** Vraća i-ti item liste rekurzivno. */
    public SType getRecursive(int index) {
        if (index >= _size || index < 0)
            return null;
        else if (index == _size - 1)
            return _sentinel._prev._item;
        class HelperCl {
            SType helperFn(ListNode ptr, int index) {
                if (index == 0)
                    return ptr._item;
                return helperFn(ptr._next, index -= 1);
            }
        }
        return new HelperCl().helperFn(_sentinel._next, index);
    }

    /** Vraća listu u obliku stringa. */
    @Override
    public String toString() {
        String result = "< ";
        for (ListNode ptr = _sentinel._next; ptr != _sentinel; result += ptr._item + " ", ptr = ptr._next);
        return result + ">";
    }

    /** Printa listu. */
    public void printDeque() {
        out.println(this.toString());
    }

    /** Provjerava na jednakost klasa. */
    private boolean checkForClassEquality(Object o) {
        return this.get(0).getClass().toString().equals(((LinkedListDeque<?>) o).get(0).getClass().toString());
    }

    /** Uspoređuje listu na jednakost sa drugom listom. */
    public boolean equals(Object o) {
        if (!(o instanceof LinkedListDeque)
            || !(this.checkForClassEquality(o))
            || this.size() != ((LinkedListDeque<?>) o).size())
                return false;
        LinkedListDeque<SType> olist = (LinkedListDeque<SType>) o;
        ListNode ptr1 = _sentinel._next;
        ListNode ptr2 = olist._sentinel._next;
        for(; ptr1 != _sentinel; ptr1 = ptr1._next, ptr2 = ptr2._next)
            if (ptr1._item != ptr2._item)
                return false;
        return true;
    }

    /** Jednostavniji oblik. */
    public boolean simpleEquals(Object o) {
        if (!(o instanceof LinkedListDeque) || this.size() != ((LinkedListDeque<?>) o).size())
            return false;
        ListNode ptr1 = _sentinel._next;
        LinkedListDeque<?>.ListNode ptr2 = ((LinkedListDeque<?>) o)._sentinel._next;
        for(; ptr1 != _sentinel; ptr1 = ptr1._next, ptr2 = ptr2._next)
            if (!(ptr1._item.equals(ptr2._item)))
                return false;
        return true;
    }
}
