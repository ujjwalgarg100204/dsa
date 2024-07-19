- Problem Link: [Leetcode](https://leetcode.com/problems/spiral-matrix/description/)
- Video Solution Link: [Striver](https://youtu.be/3Zv-s9UUrFM)
## Solution
This question tests for your implementation skills of the problem
So we have initialised 4 variables `top`, `bottom`, `left`, `right` each signifying where we will traverse in the array.
- `top` signifies the top most limit of the matrix
- `left` signifies where we will start from the left side of the matrix
- `bottom` signifies where we will start from the bottom row
- `right` signifies where we will start from the right side of the matrix
Actual explanation is best explained in video, but I shall attempt to tell about the if checks in while loop.
- First if check of `if (top <= bottom)`, imagine you only have a single row, now you would successfully go left, then increment top. Next loop will check `top <= bottom` which would turn out to be **false** so we don't go into loop. Now next loop wants to go from *left -> right* (assuming top and bottom are different). But since there is just one level, we should check that there is actually levels between top and bottom
- Second if check of `if (left <= right)`, checks that left has not crossed right even if there are levels left between top and bottom
```java
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
```
