---
id: 10 Longest Consecutive Subsequence in Array
aliases: []
tags: []
---
# Longest Consecutive Sub-Sequence in Array

Problem Link: [LeetCode](https://leetcode.com/problems/longest-consecutive-sequence/solution/)
Video Solution Link: [Striver](https://youtu.be/cHrH9CQ8pmY)

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
- We sort the array in order to bring consecutive elements together.
- We should remember that array might contain duplicates, so we keep track of what last number we saw last time and we ignore current iteration if current number is same as last number.
- If current number is not same as last number, and is equal to its predecessor we increment sub-sequence length and we update answer accordingly, also we update `lastNum` accordingly
- Time Complexity: **O(N)** 
- Space Complexity: **O(1)**
```java
  public int better(int[] arr) {
    if (arr.length == 0) {
      return 0;
    }
    Arrays.sort(arr);
    int answer = 1;

    int length = 0;
    int lastNum = Integer.MIN_VALUE;
    for (int i : arr) {
      if (lastNum == i) {
        continue;
      }
      if (lastNum == i - 1) {
        length++;
        answer = Math.max(answer, length);
      } else {
        length = 1;
      }
      lastNum = i;
    }
    return answer;
  }
```

### Optimal
We do two optimisation:
1. Using a `HashSet` in order to query numbers fast from array
2. Checking if a number's predecessor exists, to count each sub-sequence once
```java
  public int optimal(int[] arr) {
    if (arr.length == 0) {
      return 0;
    }

    Set<Integer> set = new HashSet<>();
    for (int i : arr) {
      set.add(i);
    }
    int answer = 1;

    for (int i : arr) {
      // check if current number forms a subsequence
      // we want to start from bottom of the subsequence so if i - 1
      // exist then we can be sure that it ain't the start of the subsequence
      if (set.contains(i - 1)) {
        continue;
      }

      int length = 1;
      for (int successor = i + 1; set.contains(successor); successor++) {
        length++;
      }

      answer = Math.max(answer, length);
    }

    return answer;
  }

```