---
id: 04 Kadanes Algorithm
aliases: []
tags: []
---

# Kadanes Algorithm

Problem Link: [LeetCode](https://leetcode.com/problems/maximum-subarray/)
Video Solution Link: [Striver](https://www.youtube.com/watch?v=w_KEocd__20&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=5)

## Solutions

### Brute

```java
public int brute(final int[] arr) {
    int maxSum = 0;
    for (int i = 0; i < arr.length; i++) {
        int sum = arr[i];
        for (int j = i + 1; j < arr.length; j++) {
            sum += arr[j];
            maxSum = Math.max(maxSum, sum);
        }
    }

    return maxSum;
}
```

### Optimal

- Crux of the solution is, we shouldn't take negative sum ahead

```java
public int better(final int[] arr) {
    int maxSum = arr[0];

    int sum = 0;
    for (int i : arr) {
        sum += i;
        maxSum = Math.max(maxSum, sum);

        if (sum < 0) {
            sum = 0;
        }
    }

    return maxSum;
}
```
