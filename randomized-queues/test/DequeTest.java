import static org.junit.Assert.*;

import org.junit.Test;

public class DequeTest {

    @Test
    public void createDeque() {
        Deque<Object> d = new Deque<Object>();

        assertNotNull(d);
    }

}
