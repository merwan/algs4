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
        Point[] lines = new Point[points.length];
        lines[0] = p;
        double previousSlope = p.slopeTo(points[1]);
        int alignedPoints = 0;
        for (int i = 1; i < points.length; i++) {
            Point point = points[i];
            double slope = p.slopeTo(point);
            if (slope == previousSlope) {
                lines[++alignedPoints] = point;
                if (alignedPoints >= 3) {
                    showLine(lines, alignedPoints + 1);
                }
            } else {
                alignedPoints = 1;
                lines[1] = point;
            }
            previousSlope = slope;
        }
    }

    private static void showLine(Point[] lines, int size) {
        Arrays.sort(lines, 1, size);
        if (lines[0].compareTo(lines[1]) < 0) {
            StdOut.printf("%s", lines[0]);
            for (int k = 1; k < size; k++) {
                Point point = lines[k];
                StdOut.printf(" -> %s", point);
            }
            StdOut.println();
            lines[0].drawTo(lines[size - 1]);
        }
    }
}