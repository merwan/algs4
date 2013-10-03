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
            int alignedPoints = 1;
            double previousSlope = Double.NaN;
            p = points[0];
            for (int j = 1; j < points.length; j++) {
                Point other = points[j];
                double slope = p.slopeTo(other);

                if (slope == previousSlope) {
                    alignedPoints++;
                } else {
                    if (alignedPoints >= 4) {
                        StdOut.printf("%s", p);
                        for (int k = 1; k <= alignedPoints; k++) {
                            Point point = points[j - k];
                            StdOut.printf(" -> %s", point);
                        }
                        StdOut.println();
                    }
                    alignedPoints = 1;
                }

                previousSlope = slope;
            }
        }
    }
}