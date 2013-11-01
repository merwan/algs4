public class KdTree {
    private enum Orientation {
        LeftRight, AboveBelow;

        public Orientation next() {
            if (this.equals(Orientation.AboveBelow))
                return Orientation.LeftRight;

            return Orientation.AboveBelow;
        }
    }

    private static class Node {
        /*
         * the point
         */
        private Point2D p;
        /*
         * the axis-aligned rectangle corresponding to this/ node
         */
        private RectHV rect;
        /*
         * the left/bottom subtree
         */
        private Node lb;
        /*
         * the right/top subtree
         */
        private Node rt;

        public Node(Point2D p) {
            this.p = p;
        }
    }

    private Node root;

    /*
     * construct an empty set of points
     */
    public KdTree() {
    }

    /*
     * is the set empty?
     */
    public boolean isEmpty() {
        return root == null;
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
        root = put(root, p, Orientation.LeftRight);
    }

    private Node put(Node x, Point2D p, Orientation orientation) {
        if (x == null)
            return new Node(p);
        double cmp;
        if (orientation == Orientation.LeftRight) {
            cmp = p.x() - x.p.x();
        } else {
            cmp = p.y() - x.p.y();
        }
        orientation = orientation.next();
        if (cmp < 0)
            x.lb = put(x.lb, x.p, orientation);
        else if (cmp > 0)
            x.rt = put(x.rt, x.p, orientation);
        else
            x.p = p;
        return x;
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