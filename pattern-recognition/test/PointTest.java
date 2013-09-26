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

    @Test
    public void slopeForHorizontalLineIsZero() {
        Point point = new Point(1, 1);
        Point point2 = new Point(5, 1);
        assertEquals(0, point.slopeTo(point2), 0.001);
    }

    @Test
    public void slopeForDegeneratedLineIsNegativeInfinity() {
        Point point = new Point(1, 1);
        assertEquals(Double.NEGATIVE_INFINITY, point.slopeTo(point), 0.001);
    }

    @Test
    public void slopeForVerticalLineIsPositiveInfinity() {
        Point point = new Point(1, 1);
        Point point2 = new Point(1, 5);
        assertEquals(Double.POSITIVE_INFINITY, point.slopeTo(point2), 0.001);
    }

    @Test
    public void slopeForNormalPositiveCaseIsCalculatedProperly() {
        Point point = new Point(0, 0);
        Point point2 = new Point(1, 1);
        assertEquals(1, point.slopeTo(point2), 0.001);
    }

    @Test
    public void slopeForNormalNegativeCaseIsCalculatedProperly() {
        Point point = new Point(0, 1);
        Point point2 = new Point(1, 0);
        assertEquals(-1, point.slopeTo(point2), 0.001);
    }
}
