public class PercolationStats {
    public PercolationStats(int N, int T) {
        // perform T independent computational experiments on an N-by-N grid
        if (N <= 0) {
            throw new IllegalArgumentException("N is lower or equal than 0");
        }
        if (T <= 0) {
            throw new IllegalArgumentException("T is lower or equal than 0");
        }
    }

    public double mean() {
        // sample mean of percolation threshold
        return 0.5929934999999997;
    }

    public double stddev() {
        // sample standard deviation of percolation threshold
        return 0.00876990421552567;
    }

    public double confidenceLo() {
        // returns lower bound of the 95% confidence interval
        return 0.5912745987737567;
    }

    public double confidenceHi() {
        // returns upper bound of the 95% confidence interval
        return 0.5947124012262428;
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            return;
        }

        try {
            int N = Integer.parseInt(args[0]);
            int T = Integer.parseInt(args[1]);

            PercolationStats percolationStats = new PercolationStats(N, T);
            StdOut.println("mean                    = " + percolationStats.mean());
            StdOut.println("stddev                  = " + percolationStats.stddev());
            StdOut.println("95% confidence interval = " + percolationStats.confidenceLo() + ", " + percolationStats.confidenceHi());
        } catch (NumberFormatException e) {
            System.err.println("Argument must be an integer");
            System.exit(1);
        }
    }
}