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
        this.deque.addFirst(2);
        this.deque.addFirst(3);
        assertEquals(3, this.deque.size());
        assertFalse(this.deque.isEmpty());
    }

    @Test
    public void removeFirstRemovesFromStartOfDeque() {
        this.deque.addLast(1);
        this.deque.addLast(2);
        this.deque.addLast(3);
        int i = this.deque.removeFirst();
        assertEquals(1, i);
        i = this.deque.removeFirst();
        assertEquals(2, i);
        i = this.deque.removeFirst();
        assertEquals(3, i);
        assertEquals(0, this.deque.size());
    }

    @Test
    public void addLastAddsToDeque() {
        this.deque.addLast(1);
        this.deque.addLast(2);
        this.deque.addLast(3);
        assertEquals(3, this.deque.size());
        assertFalse(this.deque.isEmpty());
    }

    @Test
    public void removeLastRemovesFromDeque() {
        this.deque.addLast(1);
        this.deque.addLast(2);
        this.deque.addLast(3);
        int i = this.deque.removeLast();
        assertEquals(3, i);
        i = this.deque.removeLast();
        assertEquals(2, i);
        i = this.deque.removeLast();
        assertEquals(1, i);
        assertEquals(0, this.deque.size());
    }
}
