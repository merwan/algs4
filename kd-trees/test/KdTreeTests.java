import static org.junit.Assert.*;

import org.junit.Test;

public class KdTreeTests {
    private final KdTree tree = new KdTree();

    private Point2D insertPoint(double x, double y) {
        Point2D p = new Point2D(x, y);
        tree.insert(p);
        return p;
    }

    @Test
    public void testIsEmpty() {
        assertTrue(tree.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals(0, tree.size());
    }

    @Test
    public void testInsertContains() {
        Point2D p = insertPoint(0.1, 0.5);

        assertTrue(tree.contains(p));
    }

    @Test
    public void testInsertSize() {
        insertPoint(0.1, 0.5);

        assertEquals(1, tree.size());
    }

    @Test
    public void testInsertNotContains() {
        insertPoint(0.1, 0.5);

        Point2D q = new Point2D(0.2, 0.5);
        assertFalse(tree.contains(q));
    }

    @Test
    public void testTwoInsertContains() {
        Point2D p = insertPoint(0.1, 0.5);
        Point2D q = insertPoint(0.2, 0.8);

        assertTrue(tree.contains(p));
        assertTrue(tree.contains(q));
    }

    @Test
    public void testTwoInsertSize() {
        insertPoint(0.1, 0.5);
        insertPoint(0.2, 0.8);

        assertEquals(2, tree.size());
    }

    @Test
    public void testMultipleInsertContains() {
        Point2D p = insertPoint(0.1, 0.5);
        Point2D q = insertPoint(0.2, 0.5);
        Point2D r = insertPoint(0.1, 0.3);
        Point2D s = insertPoint(0.7, 0.9);

        assertTrue(tree.contains(p));
        assertTrue(tree.contains(q));
        assertTrue(tree.contains(r));
        assertTrue(tree.contains(s));
    }

    @Test
    public void testMultipleInsertSize() {
        insertPoint(0.1, 0.5);
        insertPoint(0.2, 0.5);
        insertPoint(0.1, 0.3);
        insertPoint(0.7, 0.9);

        assertEquals(4, tree.size());
    }

    @Test
    public void testRange() {
        Point2D p = insertPoint(0.1, 0.5);

        Iterable<Point2D> points = tree.range(new RectHV(0, 0, 1, 1));
        for (Point2D point2d : points) {
            assertEquals(p, point2d);
        }
    }

    @Test
    public void testNearest() {
        Point2D p = insertPoint(0.1, 0.5);

        Point2D nearest = tree.nearest(new Point2D(0.3, 0.5));

        assertEquals(p, nearest);
    }

    @Test
    public void testNearestSamePoint() {
        insertPoint(0.1, 0.1);
        Point2D q = insertPoint(0.3, 0.7);

        Point2D nearest = tree.nearest(new Point2D(0.3, 0.7));

        assertEquals(q, nearest);
    }

    @Test
    public void testNearestExample() {
        Point2D p = insertPoint(0.7, 0.2);
        Point2D q = insertPoint(0.5, 0.4);
        Point2D r = insertPoint(0.2, 0.3);
        Point2D s = insertPoint(0.4, 0.7);
        Point2D t = insertPoint(0.9, 0.6);

        Point2D nearest = tree.nearest(new Point2D(0.7, 0.2));
        assertEquals(p, nearest);
        nearest = tree.nearest(new Point2D(0.5, 0.4));
        assertEquals(q, nearest);
    }
}
