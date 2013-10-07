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

        for (int i = 0; i < pointsKey.length; i++) {
            Point originPoint = pointsKey[i];
            pointsSlopes = Arrays.copyOf(pointsKey, pointsKey.length);
            Arrays.sort(pointsKey, originPoint.SLOPE_ORDER);
            int alignedPoints = 1;
            double previousSlope = Double.NaN;
            for (int j = 1; j < pointsKey.length; j++) {
                Point other = pointsSlopes[j];
                double slope = originPoint.slopeTo(other);

                if (slope == previousSlope) {
                    alignedPoints++;

                    if (j == pointsKey.length - 1 && alignedPoints >= 3) {
                        Point[] sortedPoints = new Point[alignedPoints + 1];
                        sortedPoints[0] = originPoint;
                        for (int k = 1; k <= alignedPoints; k++) {
                            Point point = pointsSlopes[j + 1 - k];
                            sortedPoints[k] = point;
                        }
                        Arrays.sort(sortedPoints);
                        StdOut.printf("%s", sortedPoints[0]);
                        for (int k = 1; k <= alignedPoints; k++) {
                            Point point = sortedPoints[k];
                            StdOut.printf(" -> %s", point);
                        }
                        StdOut.println();
                        sortedPoints[0].drawTo(sortedPoints[alignedPoints]);
                    }
                } else {
                    if (alignedPoints >= 3) {
                        Point[] sortedPoints = new Point[alignedPoints + 1];
                        sortedPoints[0] = originPoint;
                        for (int k = 1; k <= alignedPoints; k++) {
                            Point point = pointsSlopes[j - k];
                            sortedPoints[k] = point;
                        }
                        Arrays.sort(sortedPoints);
                        StdOut.printf("%s", sortedPoints[0]);
                        for (int k = 1; k <= alignedPoints; k++) {
                            Point point = sortedPoints[k];
                            StdOut.printf(" -> %s", point);
                        }
                        StdOut.println();
                        sortedPoints[0].drawTo(sortedPoints[alignedPoints]);
                    }
                    alignedPoints = 1;
                }

                previousSlope = slope;
            }
        }
    }

    private void output() {

    }
}