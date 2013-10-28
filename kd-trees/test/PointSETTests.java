import static org.junit.Assert.*;
import org.junit.Test;

public class PointSETTests {

    private final PointSET pointSet = new PointSET();

    @Test
    public void newPointSetisEmptyTest() {
        assertTrue(pointSet.isEmpty());
        assertEquals(0, pointSet.size());
    }

    @Test
    public void pointSetisNotEmptyTest() {
        Point2D p = new Point2D(0, 0);
        pointSet.insert(p);

        assertFalse(pointSet.isEmpty());
        assertEquals(1, pointSet.size());
    }

    @Test
    public void insertTest() {
        Point2D p = new Point2D(0, 0);
        pointSet.insert(p);

        assertTrue(pointSet.contains(p));
    }
}
