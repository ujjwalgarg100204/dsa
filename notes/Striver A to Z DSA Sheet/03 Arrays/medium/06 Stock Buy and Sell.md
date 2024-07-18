---
id: 06 Stock Buy and Sell
aliases: []
tags:
  - medium
---

# Stock Buy and Sell

Problem Link: [LeetCode](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/)
Video Solution Link: [Striver](https://youtu.be/excAOvwF_Wk)

## Solutions

### Brute

```java
public int brute(final int[] arr) {
  int maxProfit = 0;

  for (int i = 0; i < arr.length; i++) {
    for (int j = i + 1; j < arr.length; j++) {
      if (arr[j] > arr[i]) {
        int profit = arr[j] - arr[i];
        maxProfit = Math.max(maxProfit, profit);
      }
    }
  }

  return maxProfit;
}
```

### Optimal

```java
public int mostOptimal(final int[] arr) {
  int maxProfit = 0;

  int min = Integer.MAX_VALUE;
  for (int i : arr) {
    min = Math.min(i, min);
    maxProfit = Math.max(maxProfit, min - i);
  }

  return maxProfit;
}
```
