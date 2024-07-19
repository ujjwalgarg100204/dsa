- Problem Link: [LeetCode](https://leetcode.com/problems/rotate-image)
- Video Solution Link: [Striver](https://youtu.be/Z0R2u6gd3GU)
## Solution
We take transpose of the matrix and then reverse each row of matrix.
```java
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
```