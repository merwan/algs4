import static org.junit.Assert.*;

import org.junit.Test;

public class BoardTests {
    private Board createBoard(int size) {
        int[][] array = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                array[i][j] = 1 + i * size + j;
            }
        }

        return new Board(array);
    }

    @Test
    public void testDimension() {
        Board board = createBoard(3);

        assertEquals(3, board.dimension());
    }

    @Test
    public void testToString() {
        Board board = createBoard(3);
        String expected = "3\n 1  2  3 \n 4  5  6 \n 7  8  9 \n";
        String output = board.toString();

        assertEquals(expected, output);
    }

    @Test
    public void testIsGoal() {
        Board board = createBoard(3);

        assertTrue(board.isGoal());
    }
}
