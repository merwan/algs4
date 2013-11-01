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
        Point2D p = new Point2D(0.1, 0.5);
        tree.insert(p);

        assertTrue(tree.contains(p));
    }

    @Test
    public void testInsertSize() {
        KdTree tree = new KdTree();
        Point2D p = new Point2D(0.1, 0.5);
        tree.insert(p);

        assertEquals(1, tree.size());
    }

    @Test
    public void testInsertNotContains() {
        KdTree tree = new KdTree();
        Point2D p = new Point2D(0.1, 0.5);
        tree.insert(p);

        Point2D q = new Point2D(0.2, 0.5);
        assertFalse(tree.contains(q));
    }

    @Test
    public void testTwoInsertContains() {
        KdTree tree = new KdTree();
        Point2D p = new Point2D(0.1, 0.5);
        Point2D q = new Point2D(0.2, 0.8);
        tree.insert(p);
        tree.insert(q);

        assertTrue(tree.contains(p));
        assertTrue(tree.contains(q));
    }

    @Test
    public void testTwoInsertSize() {
        KdTree tree = new KdTree();
        Point2D p = new Point2D(0.1, 0.5);
        Point2D q = new Point2D(0.2, 0.8);
        tree.insert(p);
        tree.insert(q);

        assertEquals(2, tree.size());
    }

    @Test
    public void testMultipleInsertContains() {
        KdTree tree = new KdTree();
        Point2D p = new Point2D(0.1, 0.5);
        Point2D q = new Point2D(0.2, 0.5);
        Point2D r = new Point2D(0.1, 0.3);
        Point2D s = new Point2D(0.7, 0.9);
        tree.insert(p);
        tree.insert(q);
        tree.insert(r);
        tree.insert(s);

        assertTrue(tree.contains(p));
        assertTrue(tree.contains(q));
        assertTrue(tree.contains(r));
        assertTrue(tree.contains(s));
    }

    @Test
    public void testMultipleInsertSize() {
        KdTree tree = new KdTree();
        Point2D p = new Point2D(0.1, 0.5);
        Point2D q = new Point2D(0.2, 0.5);
        Point2D r = new Point2D(0.1, 0.3);
        Point2D s = new Point2D(0.7, 0.9);
        tree.insert(p);
        tree.insert(q);
        tree.insert(r);
        tree.insert(s);

        assertEquals(4, tree.size());
    }

    @Test
    public void testRange() {
        KdTree tree = new KdTree();
        Point2D p = new Point2D(0.1, 0.5);
        tree.insert(p);

        Iterable<Point2D> points = tree.range(new RectHV(0, 0, 1, 1));
        for (Point2D point2d : points) {
            assertEquals(p, point2d);
        }
    }
}
