import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    private class DequeIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private Node first = null;
    private Node last = null;
    private int size = 0;

    private class Node {
        private Item item;
        private Node next;
        private Node previous;
    }

    /*
     * construct an empty deque
     */
    public Deque() {
    }

    /*
     * is the deque empty?
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /*
     * return the number of items on the deque
     */
    public int size() {
        return size;
    }

    private void checkAdd(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
    }

    /*
     * insert the item at the front
     */
    public void addFirst(Item item) {
        checkAdd(item);
        Node node = new Node();
        node.item = item;
        node.next = first;
        first = node;
        if (size == 0) {
            last = first;
        }
        size++;
    }

    /*
     * insert the item at the end
     */
    public void addLast(Item item) {
        checkAdd(item);
        Node node = new Node();
        node.item = item;
        node.previous = last;
        if (last != null) {
            last.next = node;
        }
        last = node;
        if (size == 0) {
            first = last;
        }
        size++;
    }

    private void checkRemove() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
    }

    /*
     * delete and return the item at the front
     */
    public Item removeFirst() {
        checkRemove();
        Item item = first.item;
        if (first.next == null) {
            first = null;
            last = null;
        } else {
            first = first.next;
            first.previous = null;
        }
        size--;
        return item;
    }

    /*
     * delete and return the item at the end
     */
    public Item removeLast() {
        checkRemove();
        Item item = last.item;
        last = last.previous;
        size--;
        return item;
    }

    /*
     * return an iterator over items in order from front to end
     * 
     * @see java.lang.Iterable#iterator()
     */
    public java.util.Iterator<Item> iterator() {
        return new DequeIterator();
    }
}