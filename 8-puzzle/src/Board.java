public class Board {
    private int N;
    private int[][] tiles;

    /*
     * construct a board from an N-by-N array of blocks (where blocks[i][j] =
     * block in row i, column j)
     */
    public Board(int[][] blocks) {
        N = blocks.length;
        tiles = blocks;
    }

    /*
     * board dimension N
     */
    public int dimension() {
        return N;
    }

    /*
     * number of blocks out of place
     */
    public int hamming() {
        return 0;
    }

    /*
     * sum of Manhattan distances between blocks and goal
     */
    public int manhattan() {
        return 0;
    }

    /*
     * is this board the goal board?
     */
    public boolean isGoal() {
        return true;
    }

    /*
     * a board obtained by exchanging two adjacent blocks in the same row
     */
    public Board twin() {
        return null;
    }

    /*
     * does this board equal y? (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object y) {
        return false;
    }

    /*
     * all neighboring boards
     */
    public Iterable<Board> neighbors() {
        return null;
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