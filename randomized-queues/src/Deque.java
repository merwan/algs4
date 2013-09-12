public class Deque<Item> implements Iterable<Item> {
    private Node first = null;

    private class Node {
        Item item;
        Node next;
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
        return first == null;
    }

    /*
     * return the number of items on the deque
     */
    public int size() {
        return first != null ? 1 : 0;
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
        first = new Node();
        first.item = item;
    }

    /*
     * insert the item at the end
     */
    public void addLast(Item item) {
        checkAdd(item);
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
        return null;
    }

    /*
     * delete and return the item at the end
     */
    public Item removeLast() {
        checkRemove();
        return null;
    }

    /*
     * return an iterator over items in order from front to end
     * 
     * @see java.lang.Iterable#iterator()
     */
    public java.util.Iterator<Item> iterator() {
        return null;
    }
}