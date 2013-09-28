import java.util.Arrays;

public class Brute {
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

        Arrays.sort(points);

        for (int i = 0; i < N; i += 1) {
            Point p = points[i];
            for (int j = i + 1; j < N; j += 1) {
                Point q = points[j];
                for (int k = j + 1; k < N; k += 1) {
                    Point r = points[k];
                    for (int l = k + 1; l < N; l += 1) {
                        Point s = points[l];
                        double slopePQ = p.slopeTo(q);
                        double slopePR = p.slopeTo(r);
                        double slopePS = p.slopeTo(s);
                        if (slopePQ == slopePR && slopePQ == slopePS
                                && slopePR == slopePS) {
                            // points are aligned
                            StdOut.printf("%s -> %s -> %s -> %s\n", p, q, r, s);
                            p.drawTo(s);
                        }
                    }
                }
            }
        }
    }
}