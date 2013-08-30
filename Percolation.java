public class Percolation {
    private boolean[] grid;
    private int size;
    
    public Percolation(int N) {
        size = N;
        grid = new boolean[N*N + 1];
        // create N-by-N grid, with all sites blocked
        for (int i = 0; i <= N*N + 1; i++) {
            grid[i] = true;
        }
    }
    
    public void open(int i, int j) {
        // open site (row i, column j) if it is not already
    }
    
    public boolean isOpen(int i, int j) {
        // is site (row i, column j) open?
        return grid[i*size + j*size] == false;
    }
    
    public boolean isFull(int i, int j) {
        // is site (row i, column j) full?
        return grid[i*size + j*size] == true;
    }
    
    public boolean percolates() {
        // does the system percolate?
        return false;
    }
}