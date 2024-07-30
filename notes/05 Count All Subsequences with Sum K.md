- Problem Link: [GeeksForGeeks](https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=perfect-sum-problem)
# Solution
## Brute
- In this solution, we don't create another sum variable, instead we keep subtracting from existing `sum` variable, and since we are given non-negative integers, we know that nothing won't help sum increase if reach below 0, we **early return**.
- Also in the approach, I return 1 if we find the current subsequence's sum to be 0, otherwise 0, and and last I add both counts and return it
```java
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
```
### Optimal
- We use `memoization` in this approach to delete some unnecessary re-calculations done in calculating subsequences.
	- We do this by creating 2D matrix where of size `n+1`x`sum+1`, ie, one greater than the size of arr and one greater than the possible sum, since only two variables are changing we created a 2D matrix.
	- Now, we are going to store results in the `memo` matrix, so for each index, we are going to store for each sum, the count calculated
	- If we find it in the matrix solution, then we return it otherwise normal functioning of function happens and at last we store it in the memo matrix
```java
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
```