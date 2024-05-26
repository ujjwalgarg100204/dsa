import java.util.Scanner;

public class ValidSudoku {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int boardDimension = Integer.parseInt(sc.nextLine());
        String[][] board = new String[boardDimension][boardDimension];

        for (int i = 0; i < boardDimension; i++) {
            for (int j = 0; j < boardDimension; j++) {
                board[i][j] = sc.next();
            }
        }
        boolean boardIsValid = new SudokuBoard(board).isValid();
        if (boardIsValid) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        sc.close();
    }
}

/**
 * Represents a Sudoku board.
 */
class SudokuBoard {

    private static final int SUDOKU_BOARD_DIMENSION = 9;
    private String[][] board;

    public SudokuBoard(String[][] board) {
        this.board = board;
    }

    /**
     * Checks if the Sudoku board is valid.
     *
     * @return true if the Sudoku board is valid, false otherwise.
     */
    public boolean isValid() {
        for (int row = 0; row < SUDOKU_BOARD_DIMENSION; row++) {
            for (int col = 0; col < SUDOKU_BOARD_DIMENSION; col++) {
                // ignore the empty values
                if (this.board[row][col].equals(".")) {
                    continue;
                }

                // check occurrences in row
                if (occurrenceInRow(row, col) > 2) {
                    return false;
                }

                // check occurrences in col
                if (occurrenceInCol(row, col) > 2) {
                    return false;
                }

                // check occurrences in grid
                if (occurrenceInGrid(row, col) > 2) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Calculates the number of occurrences of the value at the specified row and
     * column in the 3x3 grid that contains it.
     *
     * @param row The row index of the cell.
     * @param col The column index of the cell.
     * @return The number of occurrences of the value in the grid.
     */
    private int occurrenceInGrid(int row, int col) {
        int occur = 0;
        int[] gridCenter = gridCenterForCell(row, col);
        int gridCenterRow = gridCenter[0];
        int gridCenterCol = gridCenter[1];

        for (int i = gridCenterRow - 1; i < gridCenterRow + 2; i++) {
            for (int j = gridCenterCol - 1; j < gridCenterCol + 2; j++) {
                if (this.board[i][j].equals(board[row][col])) {
                    occur++;
                }
            }
        }
        return occur;
    }

    /**
     * Calculates the center row and column for a given cell in the Sudoku grid.
     *
     * @param row The row index of the cell.
     * @param col The column index of the cell.
     * @return An array containing the center row and column of the cell.
     */
    private int[] gridCenterForCell(int row, int col) {
        int centerRow = 0;
        int centerCol = 0;

        // calculate row of center
        if (row <= 2) {
            centerRow = 1;
        } else if (row <= 5) {
            centerRow = 4;
        } else {
            centerRow = 7;
        }

        // calculate col of center
        if (col <= 2) {
            centerCol = 1;
        } else if (col <= 5) {
            centerCol = 4;
        } else {
            centerCol = 7;
        }

        return new int[] { centerRow, centerCol };
    }

    /**
     * Counts the number of occurrences of the value at the specified row and column
     * in the column of the Sudoku board.
     *
     * @param row The row index of the value.
     * @param col The column index of the value.
     * @return The number of occurrences of the value in the column.
     */
    private int occurrenceInCol(int row, int col) {
        int occur = 0;
        for (String[] boardRow : this.board) {
            if (boardRow[col].equals(board[row][col])) {
                occur++;
            }
        }
        return occur;
    }

    /**
     * Calculates the number of occurrences of the value at the specified row and
     * column in the same row of the Sudoku board.
     *
     * @param row The row index of the value.
     * @param col The column index of the value.
     * @return The number of occurrences of the value in the same row.
     */
    private int occurrenceInRow(int row, int col) {
        int occur = 0;
        for (int i = 0; i < SUDOKU_BOARD_DIMENSION; i++) {
            if (board[row][i].equals(board[row][col])) {
                occur++;
            }
        }
        return occur;
    }
}
