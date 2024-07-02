---
id: 02 Sort Array Of 0 1 And 2
aliases: []
tags:
  - medium
  - array
---

# Sort Array Of 0 1 And 2

Problem Link: [LeetCode](https://leetcode.com/problems/sort-colors/)
Video Solution Link: [Striver](https://youtu.be/tp8JIuCXBaU)

## Solutions

### Brute

```java
public void brute(int[] arr) {
    Arrays.sort(arr);
}
```

### Better

```java
public void better(int[] arr) {
    int noOf0 = 0, noOf1 = 0;

    for (int i : arr) {
        if (i == 0) {
            noOf0++;
        } else if (i == 1) {
            noOf1++;
        }
    }

    int i = 0;
    while (noOf0 != 0) {
        arr[i++] = 0;
        noOf0--;
    }
    while (noOf1 != 0) {
        arr[i++] = 1;
        noOf1--;
    }
    while (i < arr.length) {
        arr[i++] = 2;
    }
}
```

### Optimal

```java
public void optimal(int[] arr) {
    int left = -1, right = arr.length;
    for (int i = 0; i < right;) {
        if (arr[i] == 1 || i <= left) {
            i++;
        } else if (arr[i] == 0) {
            swap(arr, left + 1, i);
            left++;
        } else {
            swap(arr, right, i);
            right--;
        }
    }
}
```
