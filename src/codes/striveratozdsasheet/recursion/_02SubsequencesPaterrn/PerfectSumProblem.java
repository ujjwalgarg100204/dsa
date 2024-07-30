package codes.striveratozdsasheet.recursion._02SubsequencesPaterrn;

import java.util.Arrays;

public class PerfectSumProblem {

  private static final int MOD = 1000000007;

  public int optimal(int[] arr, int n, int sum) {
    long[][] memo = new long[n + 1][sum + 1];
    for (long[] i : memo) {
      Arrays.fill(i, -1);
    }
    return (int) helper(arr, sum, 0, memo);
  }

  private long helper(int[] arr, int sum, int currIdx, long[][] memo) {
    if (sum < 0) {
      return 0;
    }
    if (currIdx == arr.length) {
      if (sum == 0) {
        return 1;
      }
      return 0;
    }

    if (memo[currIdx][sum] != -1) {
      return (int) memo[currIdx][sum];
    }

    long pickCaseCnt = helper(arr, sum - arr[currIdx], currIdx + 1, memo);
    long notPickCaseCnt = helper(arr, sum, currIdx + 1, memo);

    memo[currIdx][sum] = (pickCaseCnt + notPickCaseCnt) % MOD;
    return memo[currIdx][sum];
  }


  public int better(int[] arr, int sum) {
    return (int) helper(arr, sum, 0);
  }

  private long helper(int[] arr, int sum, int currIdx) {
    // early return
    if (sum < 0) {
      return 0;
    }
    if (currIdx == arr.length) {
      if (sum == 0) {
        return 1L;
      }
      return 0L;
    }

    long pickCaseCnt = helper(arr, sum - arr[currIdx], currIdx + 1);
    long notPickCaseCnt = helper(arr, sum, currIdx + 1);
    return (pickCaseCnt + notPickCaseCnt) % MOD;
  }
}
