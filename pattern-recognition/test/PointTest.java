import static org.junit.Assert.*;

import org.junit.Test;

public class PointTest {

    private final double precision = 0.001;

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
        assertEquals(0, point.slopeTo(point2), precision);
    }

    @Test
    public void slopeForDegeneratedLineIsNegativeInfinity() {
        Point point = new Point(1, 1);
        assertEquals(Double.NEGATIVE_INFINITY, point.slopeTo(point), precision);
    }

    @Test
    public void slopeForVerticalLineIsPositiveInfinity() {
        Point point = new Point(1, 1);
        Point point2 = new Point(1, 5);
        assertEquals(Double.POSITIVE_INFINITY, point.slopeTo(point2), precision);
    }

    @Test
    public void slopeForNormalPositiveCaseIsCalculatedProperly() {
        Point point = new Point(0, 0);
        Point point2 = new Point(1, 1);
        assertEquals(1, point.slopeTo(point2), precision);
    }

    @Test
    public void slopeForNormalNegativeCaseIsCalculatedProperly() {
        Point point = new Point(0, 1);
        Point point2 = new Point(1, 0);
        assertEquals(-1, point.slopeTo(point2), precision);
    }

    @Test
    public void slopeToFloatValue() {
        Point p = new Point(42, 324);
        Point q = new Point(253, 327);
        assertEquals(0.01421800, p.slopeTo(q), precision);
    }

    @Test
    public void comparatorTest() {
        Point p = new Point(5, 7);
        Point q = new Point(4, 8);
        Point r = new Point(8, 2);
        assertEquals(1, p.SLOPE_ORDER.compare(q, r));
        assertEquals(-1.0, p.slopeTo(q), precision);
        assertEquals(-1.66666, p.slopeTo(r), precision);
    }
}
