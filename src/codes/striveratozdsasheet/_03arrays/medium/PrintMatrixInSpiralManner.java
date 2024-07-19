package codes.striveratozdsasheet._03arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class PrintMatrixInSpiralManner {

  public List<Integer> solution(int[][] matrix) {
    List<Integer> spiral = new ArrayList<>();
    // no of rows
    final int M = matrix.length;
    // no of cols
    final int N = matrix[0].length;

    int top = 0;
    int bottom = M - 1;
    int left = 0;
    int right = N - 1;
    while (top <= bottom && left <= right) {
      // go left
      for (int i = left; i <= right; i++) {
        spiral.add(matrix[top][i]);
      }
      top++;
      // go bottom
      for (int i = top; i <= bottom; i++) {
        spiral.add(matrix[i][right]);
      }
      right--;
      if (top <= bottom) {
        // go left
        for (int i = right; i >= left; i--) {
          spiral.add(matrix[bottom][i]);
        }
        bottom--;
      }
      if (left <= right) {
        // go up
        for (int i = bottom; i >= top; i--) {
          spiral.add(matrix[i][left]);
        }
        left++;
      }
    }

    return spiral;
  }
}
