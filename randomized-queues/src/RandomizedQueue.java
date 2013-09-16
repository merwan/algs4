public class RandomizedQueue<Item> implements Iterable<Item> {
    public RandomizedQueue() {
        // construct an empty randomized queue
    }

    public boolean isEmpty() {
        // is the queue empty?
        return true;
    }

    public int size() {
        // return the number of items on the queue
        return -1;
    }

    /*
     * add the item
     */
    public void enqueue(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
    }

    private void checkEmpty() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
    }

    /*
     * delete and return a random item
     */
    public Item dequeue() {
        checkEmpty();
        return null;
    }

    /*
     * return (but do not delete) a random item
     */
    public Item sample() {
        checkEmpty();
        return null;
    }

    public java.util.Iterator<Item> iterator() {
        // return an independent iterator over items in random order
        return null;
    }
}