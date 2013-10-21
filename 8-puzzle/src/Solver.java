public class Solver {
    private final MinPQ<SearchNode> minPQ;
    private final Stack<Board> boards;
    private int moves;
    private boolean isSolvable;

    private class SearchNode implements Comparable<SearchNode> {
        private Board board;
        private int moves;
        private SearchNode previous;

        SearchNode(Board board, int moves, SearchNode previous) {
            this.board = board;
            this.moves = moves;
            this.previous = previous;
        }

        private int priority() {
            return moves + board.manhattan();
        }

        @Override
        public int compareTo(SearchNode that) {
            if (this.priority() < that.priority()) {
                return -1;
            }
            if (this.priority() > that.priority()) {
                return +1;
            }
            return 0;
        }
    }

    /*
     * find a solution to the initial board (using the A* algorithm)
     */
    public Solver(Board initial) {
        boards = new Stack<Board>();
        minPQ = new MinPQ<SearchNode>();
        moves = 0;
        SearchNode previous = null;
        Board board = initial;
        SearchNode node = new SearchNode(initial, moves, previous);
        minPQ.insert(node);
        while (moves < 35) {
            previous = minPQ.delMin();
            board = previous.board;
            if (board.isGoal()) {
                isSolvable = true;
                this.boards.push(board);
                while (previous.previous != null) {
                    previous = previous.previous;
                    this.boards.push(previous.board);
                }
                return;
            }
            Iterable<Board> neighbors = board.neighbors();
            moves++;
            for (Board neighbor : neighbors) {
                if (neighbor.equals(previous.board)) {
                    continue;
                }
                SearchNode newNode = new SearchNode(neighbor, moves, previous);
                minPQ.insert(newNode);
            }
        }
    }

    /*
     * is the initial board solvable?
     */
    public boolean isSolvable() {
        return isSolvable;
    }

    /*
     * min number of moves to solve initial board; -1 if no solution
     */
    public int moves() {
        if (isSolvable) {
            return moves;
        } else {
            return -1;
        }
    }

    /*
     * sequence of boards in a shortest solution; null if no solution
     */
    public Iterable<Board> solution() {
        if (isSolvable) {
            return boards;
        } else {
            return null;
        }
    }

    /*
     * solve a slider puzzle (given below)
     */
    public static void main(String[] args) {
        // create initial board from file
        In in = new In(args[0]);
        int N = in.readInt();
        int[][] blocks = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }
}