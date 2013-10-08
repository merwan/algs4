import java.util.Arrays;

public class Fast {
    public static void main(String[] args) {
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Point[] pointsKey = new Point[N];
        Point[] pointsSlopes = new Point[N];
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            pointsKey[i] = new Point(x, y);
            pointsKey[i].draw();
        }

        pointsSlopes = Arrays.copyOf(pointsKey, pointsKey.length);
        for (Point originPoint : pointsKey) {
            Arrays.sort(pointsSlopes, originPoint.SLOPE_ORDER);
            findLines(pointsSlopes);
        }
    }

    private static void findLines(Point[] points) {
        Point p = points[0];
        Point[] lines = new Point[4];
        lines[0] = p;
        int index = 1;
        double previousSlope = p.slopeTo(points[1]);
        int alignedPoints = 1;
        for (int i = 1; i < points.length; i++) {
            Point point = points[i];
            double slope = p.slopeTo(point);
            if (slope == previousSlope) {
                lines[index++] = point;
                alignedPoints++;
                if (alignedPoints == 3) {
                    showLine(lines);
                }
            } else {
                alignedPoints = 1;
                index = 1;
            }
            previousSlope = slope;
        }
    }

    private static void showLine(Point[] lines) {
        Arrays.sort(lines);
        if (lines[0].compareTo(lines[1]) < 0) {
            StdOut.printf("%s", lines[0]);
            for (int k = 1; k < lines.length; k++) {
                Point point = lines[k];
                StdOut.printf(" -> %s", point);
            }
            StdOut.println();
            lines[0].drawTo(lines[lines.length - 1]);
        }
    }
}