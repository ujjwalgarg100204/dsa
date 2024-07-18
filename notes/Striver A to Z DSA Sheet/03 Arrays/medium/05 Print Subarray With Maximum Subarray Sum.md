---
id: 05 Print Subarray With Maximum Subarray Sum
aliases: []
tags:
  - medium
---

# Print Subarray With Maximum Subarray Sum

Problem Link: [GeeksForGeeks](https://www.geeksforgeeks.org/problems/max-sum-in-sub-arrays0824/0)
Video Solution Link: [Striver](https://youtu.be/AHZpyENo7k4)
## Solutions
### Optimal
You start by iterating over the array with initial sum set to 0. As you iterate
you add each element to sum, but if the sum goes below 0 you reset the sum to 0.
You do this because forwarding -ves in sum is not going to help us.

```java
public long optimal(final long[] arr) {
  long maxSum = Long.MIN_VALUE;

  long sum = 0;
  for (long i : arr) {
    sum += i;
    if (sum < 0) {
      sum = 0;
    }

    maxSum = Math.max(sum, maxSum);
  }

  return maxSum;
}
```

## Follow-up question to print the subarray with maximum sum
Important thing to remember is that we start afresh whenever we have sum = 0
so, we have to update startIndex = 0.
```java
public long[] followUpQuestion(final long[] arr) {
  long maxSum = Long.MIN_VALUE;
  int maxSumStartIndex = 0;
  int maxSumEndIndex = 0;

  int startIndex = 0;
  long sum = 0;
  for (int i = 0; i < arr.length; i++) {
    if (sum == 0) {
      startIndex = i;
    }
    sum += arr[i];
    if (sum < 0) {
      sum = 0;
    }

    if (sum > maxSum) {
      maxSumStartIndex = startIndex;
      maxSumEndIndex = i;
      maxSum = sum;
    }
  }

  return new long[]{maxSumStartIndex, maxSumEndIndex};
}
```

## Solution to GeeksForGeeks Problem
### Brute Solution to GeeksForGeeks Problem
```java
public long geeksForGeeksBrute(final long[] arr) {
  long maxScore = Long.MIN_VALUE;

  for (int i = 0; i < arr.length; i++) {
    for (int j = i; j < arr.length; j++) {
      long[] minNumbers = get2MinNumbers(arr, i, j);
      long score = minNumbers[0] + minNumbers[1];
      maxScore = Math.max(maxScore, score);
    }
  }

  return maxScore;
}

private static long[] get2MinNumbers(final long[] arr, int start, int end) {
  long firstMin = Long.MAX_VALUE;
  long secondMin = Long.MAX_VALUE;

  for (int i = start; i <= end; i++) {
    if (arr[i] < firstMin) {
      secondMin = firstMin;
      firstMin = arr[i];
    } else if (arr[i] < secondMin) {
      secondMin = arr[i];
    }
  }

  return new long[] {firstMin, secondMin};
}
```

### Optimal Solution to GeeksForGeeks Problem
We can solve this problem in O(n) time complexity by iterating over 
the array, according to question we need first 2 minimum numbers of
the subarray. Now on inspecting the question we see that we need 
at least two numbers in the subarray, and so every number will be 
minimum and second minimum. So, we can just iterate over the array
and calculate of sum of two consecutive numbers and keep track of
maximum sum which shall be our answer.

```java
public long geeksForGeeksOptimal(final long[] arr) {
  long maxScore = Long.MIN_VALUE;
  for (int i = 0; i < arr.length - 1; i++) {
    long score = arr[i] + arr[i + 1];
    maxScore = Math.max(maxScore, score);
  }

  return maxScore;
}
```
