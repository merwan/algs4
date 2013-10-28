public class KdTree {
    /*
     * construct an empty set of points
     */
    public KdTree() {
    }

    /*
     * is the set empty?
     */
    public boolean isEmpty() {
        return true;
    }

    /*
     * number of points in the set
     */
    public int size() {
        return 0;
    }

    /*
     * add the point p to the set (if it is not already in the set)
     */
    public void insert(Point2D p) {
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
        Queue<Point2D> queue = new Queue<Point2D>();
        return queue;
    }

    /*
     * a nearest neighbor in the set to p; null if set is empty
     */
    public Point2D nearest(Point2D p) {
        return null;
    }
}