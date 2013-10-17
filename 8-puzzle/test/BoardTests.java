import static org.junit.Assert.*;

import org.junit.Test;

public class BoardTests {
    private Board createGoalBoard(int size) {
        int[][] array = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                array[i][j] = 1 + i * size + j;
            }
        }
        array[size - 1][size - 1] = 0;

        return new Board(array);
    }

    private Board createRandomBoard(int size) {
        int[][] array = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                array[i][j] = i * size + j;
            }
        }

        return new Board(array);
    }

    @Test
    public void testDimension() {
        Board board = createRandomBoard(3);

        assertEquals(3, board.dimension());
    }

    @Test
    public void testToString() {
        Board board = createRandomBoard(3);
        String expected = "3\n 0  1  2 \n 3  4  5 \n 6  7  8 \n";
        String output = board.toString();

        assertEquals(expected, output);
    }

    @Test
    public void testIsGoalTrue() {
        Board board = createGoalBoard(3);

        assertTrue(board.isGoal());
    }

    @Test
    public void testIsGoalFalse() {
        Board board = createRandomBoard(3);

        assertFalse(board.isGoal());
    }
}
