public class Deque<Item> implements Iterable<Item> {
    private Node first = null;
    private int size = 0;

    private class Node {
        private Item item;
        private Node next;
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
        first = new Node();
        first.item = item;
        size++;
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
        size--;
        return first.item;
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