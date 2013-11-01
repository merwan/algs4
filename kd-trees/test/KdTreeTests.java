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
    public void testInsertContains() {
        KdTree tree = new KdTree();
        Point2D p = new Point2D(1, 5);
        tree.insert(p);

        assertTrue(tree.contains(p));
    }
}
