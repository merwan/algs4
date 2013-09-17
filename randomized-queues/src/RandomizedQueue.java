import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private class RandomizedQueueIterator implements Iterator<Item> {
        private Item[] output;
        private int counter = 0;

        private RandomizedQueueIterator() {
            output = (Item[]) new Object[N];
            for (int i = 0; i < N; i++) {
                output[i] = elements[i];
            }
            StdRandom.shuffle(output);
        }

        @Override
        public boolean hasNext() {
            return counter < N;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            return output[counter++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    private int N;
    private Item[] elements;

    /*
     * construct an empty randomized queue
     */
    public RandomizedQueue() {
        N = 0;
        elements = (Item[]) new Object[1];
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

        elements[N++] = item;
        if (N == elements.length) {
            resize(2 * elements.length);
        }
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            copy[i] = elements[i];
        }
        elements = copy;
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
        int index = StdRandom.uniform(N);
        Item value = elements[index];

        N--;
        if (index < N) {
            elements[index] = elements[N];
            elements[N] = null;
        }

        if (N > 0 && N == elements.length / 4) {
            resize(elements.length / 2);
        }

        return value;
    }

    /*
     * return (but do not delete) a random item
     */
    public Item sample() {
        checkEmpty();
        int index = StdRandom.uniform(N);
        Item value = elements[index];
        return value;
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