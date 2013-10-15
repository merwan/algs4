public class Board {
    private int N;
    private int[][] tiles;

    public Board(int[][] blocks) {
        // construct a board from an N-by-N array of blocks
        // (where blocks[i][j] = block in row i, column j)
        N = blocks.length;
        tiles = blocks;
    }

    public int dimension() {
        // board dimension N
        return N;
    }

    public int hamming() {
        // number of blocks out of place
    }

    public int manhattan() {
        // sum of Manhattan distances between blocks and goal
    }

    public boolean isGoal() {
        // is this board the goal board?
    }

    public Board twin() {
        // a board obtained by exchanging two adjacent blocks in the same row
    }

    public boolean equals(Object y) {
        // does this board equal y?
    }

    public Iterable<Board> neighbors() {
        // all neighboring boards
    }

    /*
     * string representation of the board (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(N + "\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s.append(String.format("%2d ", tiles[i][j]));
            }
            s.append("\n");
        }
        return s.toString();
    }
}