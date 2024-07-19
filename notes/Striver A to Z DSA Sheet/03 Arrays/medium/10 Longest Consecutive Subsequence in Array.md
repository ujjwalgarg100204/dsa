---
id: 10 Longest Consecutive Subsequence in Array
aliases: []
tags: []
---
# Longest Consecutive Sub-Sequence in Array

Problem Link: [LeetCode](https://leetcode.com/problems/longest-consecutive-sequence/solution/)

## Solutions

### Brute
- We do exactly what question asks us in brute solution, for each number we try to find its successor, if it exists we increment current sub-sequence length but if don't find its sub-sequence then we stop, and try for next number
- Time complexity: O(n^2) Space Complexity: O(1)
```java
public int brute(final int[] arr) {
  int answer = 0;
  for (int i : arr) {
    int length = 1;
    for (int curr = i; successorExists(arr, curr); curr++) {
      length++;
    }
    answer = Math.max(answer, length);
  }

  return answer;
}

public static boolean successorExists(int[] arr, int num) {
  for (int i : arr) {
    if (num + 1 == i) {
      return true;
    }
  }

  return false;
}
```

### Better
