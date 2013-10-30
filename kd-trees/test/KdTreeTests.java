import static org.junit.Assert.*;

import org.junit.Test;

public class KdTreeTests {
    @Test
    public void testIsEmpty() {
        KdTree tree = new KdTree();

        assertTrue(tree.isEmpty());
    }

    @Test
    public void testSize() {
        KdTree tree = new KdTree();

        assertEquals(0, tree.size());
    }

    @Test
    public void testInsert() {
        KdTree tree = new KdTree();
        tree.insert(new Point2D(1, 5));

        assertFalse(tree.isEmpty());
        assertEquals(1, tree.size());
    }
}
