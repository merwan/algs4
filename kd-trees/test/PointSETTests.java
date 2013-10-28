import static org.junit.Assert.*;
import org.junit.Test;

public class PointSETTests {

    @Test
    public void newPointSetisEmptyTest() {
        PointSET pointSet = new PointSET();

        assertTrue(pointSet.isEmpty());
        assertEquals(0, pointSet.size());
    }

    @Test
    public void pointSetisNotEmptyTest() {
        PointSET pointSet = new PointSET();
        Point2D p = new Point2D(0, 0);
        pointSet.insert(p);

        assertFalse(pointSet.isEmpty());
        assertEquals(1, pointSet.size());
    }

}
