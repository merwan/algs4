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

    @Test
    public void testInsertNotContains() {
        KdTree tree = new KdTree();
        Point2D p = new Point2D(1, 5);
        tree.insert(p);

        Point2D q = new Point2D(2, 5);
        assertFalse(tree.contains(q));
    }

    @Test
    public void testMultipleInsertContains() {
        KdTree tree = new KdTree();
        Point2D p = new Point2D(1, 5);
        Point2D q = new Point2D(2, 5);
        Point2D r = new Point2D(1, 3);
        Point2D s = new Point2D(7, 9);
        tree.insert(p);
        tree.insert(q);
        tree.insert(r);
        tree.insert(s);

        assertTrue(tree.contains(p));
        assertTrue(tree.contains(q));
        assertTrue(tree.contains(r));
        assertTrue(tree.contains(s));
    }
}
