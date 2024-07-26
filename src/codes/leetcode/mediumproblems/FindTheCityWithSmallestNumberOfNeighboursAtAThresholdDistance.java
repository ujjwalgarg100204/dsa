package codes.leetcode.mediumproblems;


import java.util.Arrays;

public class FindTheCityWithSmallestNumberOfNeighboursAtAThresholdDistance {

  private static final String PROBLEM_LINK = "https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance";

  public int[][] getMatrix(int[][] edges, int n) {
    int[][] mat = new int[n][n];
    for (int[] rows : mat) {
      Arrays.fill(rows, (int) (1e9));
    }
    for (int[] edge : edges) {
      mat[edge[0]][edge[1]] = edge[2];
      mat[edge[1]][edge[0]] = edge[2];
    }
    return mat;
  }

  public int findTheCity(int n, int[][] edges, int distanceThreshold) {
    int[][] mat = getMatrix(edges, n);
    for (int via = 0; via < n; via++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          mat[i][j] = Math.min(mat[i][j], mat[i][via] + mat[via][j]);
        }
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i == j) {
          mat[i][j] = 0;
        }
        if (mat[i][j] == (int) (1e9)) {
          mat[i][j] = -1;
        }
      }
    }

    int[][] pairs = new int[n][2];
    for (int i = 0; i < n; i++) {
      int count = 0;
      for (int j = 0; j < n; j++) {
        if (distanceThreshold >= mat[i][j]) {
          count++;
        }
      }
      pairs[i][0] = i;
      pairs[i][1] = count - 1;
    }
    Arrays.sort(pairs, (a, b) -> {
      if (a[1] == b[1]) {
        return b[0] - a[0];
      } else {
        return a[1] - b[1];
      }
    });
    return pairs[0][0];
  }
}
