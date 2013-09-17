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
}