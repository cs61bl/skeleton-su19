import java.util.Iterator;
/**
 * An SLList is a list of integers, which encapsulates the
 * naked linked list structure.
 */
public class SLList<Item> implements Iterable<Item> {
    private static class ListNode<Item> {
        public Item item;
        public ListNode<Item> next;

        public ListNode(Item i, ListNode<Item> n) {
            item = i;
            next = n;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListNode<Item> that = (ListNode<Item>) o;
            return item == that.item;
        }

        @Override
        public String toString() {
            return item + "";
        }

    }

    /* The first item (if it exists) is at sentinel.next. */
    private ListNode<Item> sentinel;
    private int size;

    public Iterator<Item> iterator() {
        return new SLListIterator();
    }

    private class SLListIterator implements Iterator<Item> {

        private ListNode<Item> bookmark = sentinel.next;

        public Item next() {
            Item toReturn = bookmark.item;
            bookmark = bookmark.next;
            return toReturn;
        }

        public boolean hasNext() {
            return bookmark != sentinel;
        }
    }

//    private class SLListIterator implements Iterator<Item> {
//
//        private ListNode<Item> bookmark = sentinel;
//
//        public Item next() {
//            bookmark = bookmark.next;
//            return bookmark.item;
//        }
//
//        public boolean hasNext() {
//            return bookmark.next != sentinel;
//        }
//    }

    /** Creates an empty SLList. */
    public SLList() {
        sentinel = new ListNode<>(null, null);
        sentinel.next = sentinel;
        size = 0;
    }

    public SLList(Item x) {
        sentinel = new ListNode<>(null, null);
        sentinel.next = new ListNode<>(x, null);
        sentinel.next.next = sentinel;
        size = 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SLList<Item> slList = (SLList<Item>) o;
        if (size != slList.size) return false;

        ListNode<Item> l1 = sentinel.next;
        ListNode<Item> l2 = slList.sentinel.next;

        while (l1 != sentinel && l2 != sentinel) {
            if (!l1.equals(l2)) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }

    @Override
    public String toString() {
        ListNode<Item> l = sentinel.next;
        String result = "";

        while (l != sentinel) {
            result += l + " ";
            l = l.next;
        }

        return result.trim();
    }

    /** Returns an SLList consisting of the given values. */
    public static SLList<Integer> of(int... values) {
        SLList<Integer> list = new SLList<>();
        for (int i = values.length - 1; i >= 0; i -= 1) {
            list.addFirst(values[i]);
        }
        return list;
    }

    /** Returns the size of the list. */
    public int size() {
        return size;
    }

    /** Adds x to the front of the list. */
    public void addFirst(Item x) {
        sentinel.next = new ListNode<>(x, sentinel.next);
        size += 1;
    }

    /** Return the value at the given index. */
    public Item get(int index) {
        ListNode<Item> p = sentinel.next;
        while (index > 0) {
            p = p.next;
            index -= 1;
        }
        return p.item;
    }

    /** Adds x to the list at the specified index. */
    public void add(int index, Item x) {
        size += 1;
        ListNode<Item> p = sentinel;
        while (p.next != sentinel && index > 0) {
            p = p.next;
            index -= 1;
        }
        p.next = new ListNode<>(x, p.next);
    }

    /** Returns the reverse of this list. This method is destructive. */
    public void reverse() {
        sentinel.next = reverse(sentinel.next);
    }

    private ListNode<Item> reverse(ListNode<Item> L) {
        if (L == sentinel || L.next == sentinel) {
            return L;
        } else {
            ListNode<Item> reversed = reverse(L.next);
            L.next.next = L;
            L.next = sentinel;
            return reversed;
        }
    }

    public static void main(String[] args) {
        SLList<Integer> friends = new SLList<>();
        friends.addFirst(5);
        friends.addFirst(23);
        friends.addFirst(42);

        Iterator<Integer> seer = friends.iterator();
        while (seer.hasNext()) {
            int x = seer.next();
            System.out.println(x);
        }

        SLList<Integer> moreFriends = new SLList<>();
        moreFriends.addFirst(5);
        moreFriends.addFirst(23);
        moreFriends.addFirst(42);
        for (int x : moreFriends) {
            System.out.println(x);
        }
    }
}

