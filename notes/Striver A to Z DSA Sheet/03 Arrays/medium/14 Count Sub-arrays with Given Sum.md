- Problem Link: [LeetCode](https://leetcode.com/problems/subarray-sum-equals-k)
- Video Link: [Striver](https://www.youtube.com/watch?v=xvNwoz-ufXA&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=33)
## Solution
### Brute
```java
  public int brute(final int[] arr, int k) {
    // generate all the sub-arrays and filter out those array which have sum as k, and keep count
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
      int sum = 0;
      for (int j = i; j < arr.length; j++) {
        sum += arr[j];
        if (sum == k) {
          count++;
        }
      }
    }

    return count;
  }
```
## Optimal
Here we can refer the optimal solution of [[12 Longest Subarray With Given Sum#Optimal (if +ve & -ve)]] where we used `HashMap` of prefix sums, where in we held prefix sum as key and index as value. We stored value because we needed to find the maximum length, but here we need to find the count, so we keep the count of the sum instead, and rest is pretty much the same
```java
  public int optimal(final int[] arr, int k) {
    Map<Integer, Integer> preSum = new HashMap<>();
    int count = 0;
    int sum = 0;
    for (int i : arr) {
      sum += i;
      if (sum == k) {
        count++;
      }
      if (preSum.containsKey(sum - k)) {
        count += preSum.get(sum - k);
      }
      preSum.merge(sum, 1, Integer::sum);
    }

    return count;
  }
```