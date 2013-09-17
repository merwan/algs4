import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private class RandomizedQueueIterator implements Iterator<Item> {

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public Item next() {
            throw new java.util.NoSuchElementException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    private int N;

    /*
     * construct an empty randomized queue
     */
    public RandomizedQueue() {
        N = 0;
    }

    /*
     * is the queue empty?
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /*
     * return the number of items on the queue
     */
    public int size() {
        return N;
    }

    /*
     * add the item
     */
    public void enqueue(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }

        N++;
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

    /*
     * return an independent iterator over items in random order
     * 
     * @see java.lang.Iterable#iterator()
     */
    public java.util.Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }
}