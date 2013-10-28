public class PointSET {
    private final SET<Point2D> set = new SET<Point2D>();

    /*
     * construct an empty set of points
     */
    public PointSET() {
    }

    /*
     * is the set empty?
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /*
     * number of points in the set
     */
    public int size() {
        return set.size();
    }

    /*
     * add the point p to the set (if it is not already in the set)
     */
    public void insert(Point2D p) {
        set.add(p);
    }

    /*
     * does the set contain the point p?
     */
    public boolean contains(Point2D p) {
        return set.contains(p);
    }

    /*
     * draw all of the points to standard draw
     */
    public void draw() {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(.01);
        for (Point2D p : set) {
            p.draw();
        }
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
        double distance = Double.MAX_VALUE;
        Point2D nearest = null;
        for (Point2D other : set) {
            if (other.equals(p)) {
                continue;
            }

            if (p.distanceSquaredTo(other) < distance) {
                distance = p.distanceSquaredTo(other);
                nearest = other;
            }

        }
        return nearest;
    }
}