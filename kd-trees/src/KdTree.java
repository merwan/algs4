public class KdTree {
    private int size = 0;

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
            this.rect = new RectHV(0, 0, 1, 1);
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
        return size;
    }

    /*
     * add the point p to the set (if it is not already in the set)
     */
    public void insert(Point2D p) {
        root = put(root, p, Orientation.LeftRight);
    }

    private Node put(Node x, Point2D p, Orientation orientation) {
        if (x == null) {
            size++;
            return new Node(p);
        }
        if (x.p.equals(p)) {
            return x;
        }
        int cmp = compare(p, x.p, orientation);
        Orientation nextOrientation = orientation.next();
        if (cmp < 0) {
            x.lb = put(x.lb, p, nextOrientation);
            if (orientation == Orientation.LeftRight) {
                x.lb.rect = new RectHV(x.rect.xmin(), x.rect.ymin(), x.p.x(),
                        x.rect.ymax());
            } else {
                x.lb.rect = new RectHV(x.rect.xmin(), x.rect.ymin(),
                        x.rect.xmax(), x.p.y());
            }
        } else {
            x.rt = put(x.rt, p, nextOrientation);
            if (orientation == Orientation.LeftRight) {
                x.rt.rect = new RectHV(x.p.x(), x.rect.ymin(), x.rect.xmax(),
                        x.rect.ymax());
            } else {
                x.rt.rect = new RectHV(x.rect.xmin(), x.p.y(), x.rect.xmax(),
                        x.rect.ymax());
            }
        }
        return x;
    }

    private int compare(Point2D p, Point2D q, Orientation orientation) {
        if (orientation == Orientation.LeftRight) {
            return Double.compare(p.x(), q.x());
        } else {
            return Double.compare(p.y(), q.y());
        }
    }

    /*
     * does the set contain the point p?
     */
    public boolean contains(Point2D p) {
        return contains(root, p, Orientation.LeftRight);
    }

    private boolean contains(Node x, Point2D p, Orientation orientation) {
        if (x == null) {
            return false;
        }
        if (x.p.equals(p)) {
            return true;
        }
        int cmp = compare(p, x.p, orientation);
        Orientation nextOrientation = orientation.next();
        if (cmp < 0) {
            return contains(x.lb, p, nextOrientation);
        } else {
            return contains(x.rt, p, nextOrientation);
        }
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