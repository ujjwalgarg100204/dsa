---
id: 03 Majority Element
aliases: []
tags: []
---

# Majority Element

Problem Link: [LeetCode](https://leetcode.com/problems/majority-element)
Video Solution Link: [Striver](https://youtu.be/nP_ns3uSh80)

## Solutions

### Brute

```java
public int brute(final int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.merge(i, 1, Integer::sum);
        }

        int maxElement = -1;
        int maxCount = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxElement = entry.getKey();
            }
        }

        return maxElement;
    }
```

### Optimal

```java
public int optimal(final int[] arr) {
    int count = 0;
    int maxElement = -1;

    for (int i : arr) {
        if (count == 0) {
            maxElement = i;
            count = 1;
        } else if (maxElement == i) {
            count++;
        } else {
            count--;
        }
    }

    return maxElement;
}
```
