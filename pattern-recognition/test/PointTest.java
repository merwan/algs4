import static org.junit.Assert.*;

import org.junit.Test;

public class PointTest {

    @Test
    public void compareDifferentY() {
        Point point = new Point(1, 5);
        Point point2 = new Point(1, 10);
        assertTrue(point.compareTo(point2) < 0);
        assertTrue(point2.compareTo(point) > 0);
    }

    @Test
    public void compareEqualY() {
        Point point = new Point(1, 10);
        Point point2 = new Point(5, 10);
        assertTrue(point.compareTo(point2) < 0);
        assertTrue(point2.compareTo(point) > 0);
    }

    @Test
    public void compareEqualXandY() {
        Point point = new Point(5, 10);
        Point point2 = new Point(5, 10);
        assertTrue(point.compareTo(point2) == 0);
        assertTrue(point2.compareTo(point) == 0);
    }

    @Test(expected = NullPointerException.class)
    public void compareWithNullThrowsNullPointerException() {
        Point point = new Point(5, 10);
        point.compareTo(null);
    }
}
