/**
 * Array-based list which only uses even indices, since the other are
 * rather odd. Invariants:
 *
 *   addLast: The next item we want to add, will go into position size
 *   getLast: The item we want to return is in position size - 2
 *   size: The number of items in the list should be size/2.
 */
public class SpaceList<Item> {
    private Item[] items;
    private int size;

    /** Creates an empty list. */
    public SpaceList() {
        items = (Item[]) new Object[16];
        size = 0;
    }

    /** Resizes the underlying array to the target capacity. */
    private void resize(int capacity) {
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size / 2;
    }

    /** Returns if the collection contains k. */
    public boolean contains(Item x) {
        for (int i = 0; i < size; i += 2) {
            if (items[i].equals(x)) {
                return true;
            }
        }
        return false;
    }

    /** Adds x to the end of the list. */
    public void addLast(Item x) {
        if (size == items.length) {
            resize(size * 2);
        }

        items[size] = x;
        size += 2;
    }

    /** Adds x to the list at the specified index. */
    public void add(int index, Item x) {
        if (index < 0 || index * 2 > size) {
            return;
        } else if (size == items.length) {
            resize(size * 2);
        }

        for (int i = size; i > index * 2; i -= 2) {
            items[i] = items[i - 2];
        }
        items[index * 2] = x;
        size += 2;
    }

    /** Returns the last item in the list. */
    public Item getLast() {
        return items[size - 2];
    }

    /** Returns the i-th item in the list, where 0 is the first item. */
    public Item get(int i) {
        return items[i * 2];
    }

    /** Deletes item from back of the list and returns deleted item. */
    public Item removeLast() {
        Item x = getLast();
        items[size - 2] = null;
        size -= 2;
        return x;
    }

    /** Removes the first instance of the item from this list. */
    public void remove(Item x) {
        int i = 0;
        while (i < size) {
            if (items[i].equals(x)) {
                break;
            }
            i += 2;
        }
        while (i < size - 2) {
            items[i] = items[i + 2];
            i += 2;
        }
        items[size - 2] = null;
        size -= 2;
    }
}
