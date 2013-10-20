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

    private Board createAnyBoard(int size, int[] args) {
        int counter = 0;
        int[][] array = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (counter < args.length) {
                    array[i][j] = args[counter++];
                }
            }
        }

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

    @Test
    public void testEquals() {
        Board board = createGoalBoard(3);

        assertTrue(board.equals(board));
        assertFalse(board.equals(null));
        assertFalse(board.equals(new String()));
        assertFalse(board.equals(createRandomBoard(3)));
        assertFalse(board.equals(createGoalBoard(2)));
        assertTrue(board.equals(createGoalBoard(3)));
    }

    @Test
    public void testHamming() {
        Board board = createGoalBoard(3);

        assertEquals(0, board.hamming());
        assertEquals(5,
                createAnyBoard(3, new int[] { 8, 1, 3, 4, 0, 2, 7, 6, 5 })
                        .hamming());
    }

    @Test
    public void testManhattan() {
        Board board = createGoalBoard(3);

        assertEquals(0, board.manhattan());
        assertEquals(2,
                createAnyBoard(3, new int[] { 2, 1, 3, 4, 5, 6, 7, 8, 0 })
                        .manhattan());
        assertEquals(6,
                createAnyBoard(3, new int[] { 8, 2, 3, 4, 5, 6, 7, 1, 0 })
                        .manhattan());
        assertEquals(10,
                createAnyBoard(3, new int[] { 8, 1, 3, 4, 0, 2, 7, 6, 5 })
                        .manhattan());
    }

    @Test
    public void testTwin() {
        Board board = createGoalBoard(3);

        assertEquals(
                createAnyBoard(3, new int[] { 2, 1, 3, 4, 5, 6, 7, 8, 0 }),
                createAnyBoard(3, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 0 })
                        .twin());
        assertEquals(
                createAnyBoard(3, new int[] { 0, 2, 3, 4, 5, 6, 7, 8, 1 }),
                createAnyBoard(3, new int[] { 0, 3, 2, 4, 5, 6, 7, 8, 1 })
                        .twin());
        assertEquals(
                createAnyBoard(3, new int[] { 5, 0, 4, 2, 3, 8, 7, 1, 6 }),
                createAnyBoard(3, new int[] { 5, 0, 4, 3, 2, 8, 7, 1, 6 })
                        .twin());
        assertEquals(createAnyBoard(2, new int[] { 1, 0, 2, 3 }),
                createAnyBoard(2, new int[] { 1, 0, 3, 2 }).twin());
    }
}
