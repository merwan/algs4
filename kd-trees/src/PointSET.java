public class PointSET {
    private int size = 0;

    /*
     * construct an empty set of points
     */
    public PointSET() {
    }

    /*
     * is the set empty?
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /*
     * number of points in the set
     */
    public int size() {
        return size;
    }

    /*
     * add the point p to the set (if it is not already in the set)
     */
    public void insert(Point2D p) {
        size++;
    }

    /*
     * does the set contain the point p?
     */
    public boolean contains(Point2D p) {
        return false;
    }

    /*
     * draw all of the points to standard draw
     */
    public void draw() {
    }

    /*
     * all points in the set that are inside the rectangle
     */
    public Iterable<Point2D> range(RectHV rect) {
        return null;
    }

    /*
     * a nearest neighbor in the set to p; null if set is empty
     */
    public Point2D nearest(Point2D p) {
        return null;
    }
}