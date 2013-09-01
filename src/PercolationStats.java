public class PercolationStats {
	private double[] tries;
	private int T;

	/***
	 * perform T independent computational experiments on an N-by-N grid
	 * 
	 * @param N
	 *            N x N grid
	 * @param T
	 *            number of independent computational experiments
	 */
	public PercolationStats(int N, int T) {
		if (N <= 0) {
			throw new IllegalArgumentException("N is lower or equal than 0");
		}
		if (T <= 0) {
			throw new IllegalArgumentException("T is lower or equal than 0");
		}
		this.T = T;

		tries = new double[T];
		for (int i = 0; i < T; i++) {
			Percolation percolation = new Percolation(N);
			double threshold = 0;
			while (!percolation.percolates()) {
				int row = StdRandom.uniform(N) + 1;
				int column = StdRandom.uniform(N) + 1;
				if (percolation.isFull(row, column)) {
					threshold++;
					percolation.open(row, column);
				}
			}
			tries[i] = threshold / (N * N);
		}
	}

	/***
	 * 
	 * @return sample mean of percolation threshold
	 */
	public double mean() {
		double sum = 0;
		for (int i = 0; i < T; i++) {
			sum += tries[i];
		}
		return sum / T;
	}

	/***
	 * 
	 * @return sample standard deviation of percolation threshold
	 */
	public double stddev() {
		double mean = mean();
		double sum = 0;
		for (int i = 0; i < T; i++) {
			sum += Math.pow(tries[i] - mean, 2);
		}
		return sum / (T - 1);
	}

	/***
	 * 
	 * @return returns lower bound of the 95% confidence interval
	 */
	public double confidenceLo() {
		return mean() - 1.96 * stddev() / Math.sqrt(T);
	}

	/***
	 * 
	 * @return upper bound of the 95% confidence interval
	 */
	public double confidenceHi() {
		return mean() + 1.96 * stddev() / Math.sqrt(T);
	}

	public static void main(String[] args) {
		if (args.length != 2) {
			return;
		}

		try {
			int N = Integer.parseInt(args[0]);
			int T = Integer.parseInt(args[1]);

			PercolationStats percolationStats = new PercolationStats(N, T);
			StdOut.println("mean                    = "
					+ percolationStats.mean());
			StdOut.println("stddev                  = "
					+ percolationStats.stddev());
			StdOut.println("95% confidence interval = "
					+ percolationStats.confidenceLo() + ", "
					+ percolationStats.confidenceHi());
		} catch (NumberFormatException e) {
			System.err.println("Argument must be an integer");
			System.exit(1);
		}
	}
}