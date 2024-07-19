package codes.striveratozdsasheet._03arrays.medium;

import java.util.Arrays;

public class SetMatrixZeroes {

  private static void setColumnToZero(int[][] matrix, int column) {
    for (int row = 0; row < matrix.length; row++) {
      matrix[row][column] = 0;
    }
  }

  private static void setRowToZero(int[][] matrix, int row) {
    Arrays.fill(matrix[row], 0);
  }

  public void brute(int[][] matrix) {
    int[][] cpy = new int[matrix.length][];
    for (int i = 0; i < cpy.length; i++) {
      cpy[i] = Arrays.copyOf(matrix[i], matrix[i].length);
    }

    for (int row = 0; row < cpy.length; row++) {
      for (int col = 0; col < cpy[row].length; col++) {
        if (cpy[row][col] == 0) {
          setColumnToZero(matrix, col);
          setRowToZero(matrix, row);
        }
      }
    }
  }

  public void better(int[][] matrix) {
    // false is means that particular row/col should be 1, true means it should be 0
    boolean[] rowMarkers = new boolean[matrix.length];
    boolean[] colMarkers = new boolean[matrix[0].length];

    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix[row].length; col++) {
        if (matrix[row][col] == 0) {
          rowMarkers[row] = true;
          colMarkers[col] = true;
        }
      }
    }

    // now change the array
    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix[row].length; col++) {
        if (rowMarkers[row] || colMarkers[col]) {
          matrix[row][col] = 0;
        }
      }
    }
  }

  public void optimal(int[][] matrix) {
    // use first row and first col as markers
    int common = matrix[0][0];
    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix[row].length; col++) {
        if (matrix[row][col] == 0) {
          // mark top row and col
          if (row == 0) {
            common = 0;
          } else {
            matrix[0][col] = 0;
            matrix[row][0] = 0;
          }
        }
      }
    }

    // now using the markers transform inner matrix
    for (int row = 1; row < matrix.length; row++) {
      for (int col = 1; col < matrix[row].length; col++) {
        if (matrix[0][col] == 0 || matrix[row][0] == 0) {
          matrix[row][col] = 0;
        }
      }
    }

    // now transform the first row and col
    for (int row = 0; row < matrix.length; row++) {
      if (matrix[0][0] == 0) {
        matrix[row][0] = 0;
      }
    }
    for (int col = 0; col < matrix[0].length; col++) {
      if (common == 0) {
        matrix[0][col] = 0;
      }
    }
  }
}
