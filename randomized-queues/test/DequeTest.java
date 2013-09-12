import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DequeTest {

    private Deque<Integer> deque;
    
    @Before
    public void setUp() {
        this.deque = new Deque<Integer>();
    }

    @Test
    public void newDequeIsEmpty() {
        assertTrue(this.deque.isEmpty());
    }

    @Test
    public void newDequeSizeIs0() {
        assertEquals(0, this.deque.size());
    }
    
    @Test
    public void addFirstAddsToDeque() {
        this.deque.addFirst(1);
        assertEquals(1, this.deque.size());
        assertFalse(this.deque.isEmpty());
    }
}
