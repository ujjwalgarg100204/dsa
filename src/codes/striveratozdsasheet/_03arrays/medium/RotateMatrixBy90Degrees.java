package codes.striveratozdsasheet._03arrays.medium;


public class RotateMatrixBy90Degrees {

  private static void reverse(int[] arr) {
    for (int i = 0; i < arr.length / 2; i++) {
      swap(arr, i, arr.length - i - 1);
    }
  }

  private static void swap(int[] arr, int firstIdx, int secIdx) {
    int temp = arr[firstIdx];
    arr[firstIdx] = arr[secIdx];
    arr[secIdx] = temp;
  }

  public void optimal(int[][] matrix) {
    // take transpose of matrix
    for (int i = 0; i < matrix.length; i++) {
      for (int j = i; j < matrix.length; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }
    // reverse each row
    for (int[] row : matrix) {
      reverse(row);
    }
  }
}
