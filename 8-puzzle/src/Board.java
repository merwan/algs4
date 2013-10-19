public class Board {
    private final int N;
    private final int[][] tiles;
    private final int[][] goalTiles;

    /*
     * construct a board from an N-by-N array of blocks (where blocks[i][j] =
     * block in row i, column j)
     */
    public Board(int[][] blocks) {
        N = blocks.length;
        tiles = blocks;
        goalTiles = createGoalBoard();
    }

    private int[][] createGoalBoard() {
        int[][] array = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                array[i][j] = 1 + i * N + j;
            }
        }
        array[N - 1][N - 1] = 0;

        return array;
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
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tiles[i][j] != goalTiles[i][j] && !isEnd(i, j)) {
                    sum++;
                }
            }
        }
        return sum;
    }

    private boolean isEnd(int i, int j) {
        return i == N - 1 && j == N - 1;
    }

    /*
     * sum of Manhattan distances between blocks and goal
     */
    public int manhattan() {
        return -1;
    }

    /*
     * is this board the goal board?
     */
    public boolean isGoal() {
        return tilesEquals(this.tiles, goalTiles);
    }

    private boolean tilesEquals(int[][] first, int[][] second) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (first[i][j] != second[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    /*
     * a board obtained by exchanging two adjacent blocks in the same row
     */
    public Board twin() {
        return null;
    }

    /*
     * does this board equal x? (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object x) {
        if (x == this)
            return true;
        if (x == null)
            return false;
        if (x.getClass() != this.getClass())
            return false;

        Board that = (Board) x;
        return tilesEquals(this.tiles, that.tiles);
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