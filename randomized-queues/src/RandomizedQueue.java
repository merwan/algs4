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

    /*
     * return an independent iterator over items in random order
     * 
     * @see java.lang.Iterable#iterator()
     */
    public java.util.Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }
}