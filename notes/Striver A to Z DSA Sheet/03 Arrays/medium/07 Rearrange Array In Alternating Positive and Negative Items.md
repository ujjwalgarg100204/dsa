---
id: 07 Rearrange Array In Alternating Positive and Negative Items
aliases: []
tags:
  - medium
---

# Rearrange Array In Alternating Positive and Negative Items

Problem Link: [LeetCode](https://leetcode.com/problems/rearrange-array-elements-by-sign/description/)
Video Solution Link: [Striver](https://youtu.be/h4aBagy4Uok)

## Solutions

### Brute

```java
public int[] brute(int[] arr) {
  int[] positives = new int[arr.length / 2];
  int[] negatives = new int[arr.length / 2];

  int p = 0, n = 0;
  for (int i : arr) {
    if (i > 0) {
      positives[p] = i;
      p++;
    } else {
      negatives[n] = i;
      n++;
    }
  }

  for (int i = 0; i < positives.length; i++) {
    arr[2 * i] = positives[i];
  }

  for (int i = 0; i < negatives.length; i++) {
    arr[2 * i + 1] = negatives[i];
  }

  return arr;
}
```

### Optimal

```java
public int[] optimal(int[] arr) {
  int[] cpy = new int[arr.length];
  int pos = 0, neg = 1;
  for (int i : arr) {
    if (i > 0) {
      cpy[pos] = i;
      pos += 2;
    } else {
      cpy[neg] = i;
      neg += 2;
    }
  }

  return cpy;
}
```

