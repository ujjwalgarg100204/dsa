---
id: 01 Two Sum
aliases: []
tags:
  - medium
---

# Two Sum

Problem Link: [LeetCode](https://leetcode.com/problems/two-sum/description/)
Video Solution Link: [Striver](https://youtu.be/UXDSeD9mN-k)

## Solution

### Brute

```java
public int[] brute(final int[] arr, int target) {
    int[] result = new int[2];

    for (int i = 0; i < arr.length; i++) {
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[i] + arr[j] == target) {
                result[0] = i;
                result[1] = j;
            }
        }
    }

    return result;
}
```

### Optimal

```java
public int[] optimal(final int[] arr, int target) {
    int[] result = new int[2];
    Map<Integer, Integer> set = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {
        set.put(arr[i], i);
    }

    for (int i = 0; i < arr.length; i++) {
        int diff = target - arr[i];
        if (set.containsKey(diff) && set.get(diff) != i) {
            result[0] = i;
            result[1] = set.get(diff);
            break;
        }
    }

    return result;

}
```
