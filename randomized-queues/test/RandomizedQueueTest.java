import static org.junit.Assert.*;
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
}
