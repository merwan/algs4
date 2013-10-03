import java.util.Arrays;

public class Fast {
    public static void main(String[] args) {
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Point[] points = new Point[N];
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
            points[i].draw();
        }

        for (int i = 0; i < points.length; i++) {
            Point p = points[i];
            Arrays.sort(points, p.SLOPE_ORDER);
            int counter = 0;
            double previousSlope = Double.NaN;
            for (int j = 1; j < points.length; j++) {
                Point other = points[j];
                double slope = p.slopeTo(other);

                if (slope == previousSlope) {
                    counter++;
                } else {
                    if (counter >= 3) {
                        Point q = points[j - 4];
                        Point r = points[j - 3];
                        Point s = points[j - 2];
                        Point t = points[j - 1];
                        StdOut.printf("%s -> %s -> %s -> %s -> %s\n", p, q, r, s, t);
                    }
                    counter = 0;
                }

                previousSlope = slope;
            }
        }
    }
}