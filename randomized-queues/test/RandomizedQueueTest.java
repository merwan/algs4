import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class RandomizedQueueTest {
    private RandomizedQueue<Integer> queue;

    @Before
    public void setUp() {
        queue = new RandomizedQueue<Integer>();
    }

    @Test(expected = NullPointerException.class)
    public void throwsNullPointerExceptionWhenAddingNullItem() {
        queue.enqueue(null);
    }

    @Test(expected = java.util.NoSuchElementException.class)
    public void throwsNoSuchElementExceptionWhenDequeingFromEptyQueue() {
        queue.dequeue();
    }

    @Test(expected = java.util.NoSuchElementException.class)
    public void throwsNoSuchElementExceptionWhenSamplingFromEptyQueue() {
        queue.sample();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void throwsUnsupportedOperationExceptionWhenCallingRemoveFromIterator() {
        Iterator<Integer> iterator = queue.iterator();
        iterator.remove();
    }

    @Test(expected = java.util.NoSuchElementException.class)
    public void throwsNoSuchElementExceptionWhenCallingNextFromEmptyIterator() {
        Iterator<Integer> iterator = queue.iterator();
        iterator.next();
    }

    @Test
    public void newQueueIsEmpty() {
        assertTrue(queue.isEmpty());
    }

    @Test
    public void newQueueSizeIsZero() {
        assertEquals(0, queue.size());
    }

    @Test
    public void enqueueIncreaseSize() {
        queue.enqueue(1);
        assertEquals(1, queue.size());
    }

    @Test
    public void dequeueDecreaseSize() {
        queue.enqueue(1);
        queue.dequeue();
        assertEquals(0, queue.size());
    }

    @Test
    public void sampleKeepSize() {
        queue.enqueue(1);
        queue.sample();
        assertEquals(1, queue.size());
    }

    @Test
    public void enqueueDequeue() {
        queue.enqueue(1);
        int value = queue.dequeue();
        assertEquals(1, value);
    }

    @Test
    public void enqueueTwiceDequeue() {
        queue.enqueue(1);
        queue.enqueue(1);
        int value = queue.dequeue();
        assertEquals(1, value);
    }

    @Test
    public void iterate() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        for (int value : queue) {
            StdOut.println(value);
        }

    }
}