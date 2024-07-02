---
id: 12 Longest Subarray With Given Sum
aliases: []
tags: []
---

# Longest Subarray With Given Sum

## Solutions

### Brute

```java
public int brute(final int[] arr, int k) {
    int maxLength = 0;
    for (int i = 0; i < arr.length; i++) {
        int sum = 0;
        for (int j = i; j < arr.length; j++) {
            sum += arr[j];
            if (sum == k) {
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }
    }

    return maxLength;
}
```

### Optimal (if +ve & -ve)

- We use `HashMap` to reduce the time complexity of the solution.
- In this we iterate over the array and we ask the question whether there exists
  a number which is `prefixSum - k`, if so then there is a sub-array with length
  where that number is found till current prefixSum.

```java
public int optimal(final int[] arr, int k) {
    int maxLen = Integer.MIN_VALUE;
    Map<Integer, Integer> prefixSum = new HashMap<>();

    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
        sum += arr[i];

        if (sum == k) {
            maxLen = Math.max(maxLen, i + 1);
        } else if (prefixSum.containsKey(sum - k)) {
            maxLen = Math.max(maxLen, i - prefixSum.get(sum - k));
        }

        prefixSum.putIfAbsent(sum, i);
    }

    return maxLen;
}
```

> [!NOTE]
> We have used `Map.putIfAbsent` because of 0. Imagine array [2, 0, 0, 5], here
> the second 0 will be ignored if we use `Map.put` because it will replace the
> value created by 2, we then we will end up getting the shortest sub-array of
> sum k. So we use `Map.putIfAbsent` to avoid this.

### Optimal (if only +ve)

- In this case we can use two pointers to find the sub-array with sum k.
- We keep increasing the sum if sum < k, but if the sum exceeds k, then we
  decrease the sum by removing the element at the start of the sub-array.

```java
public int optimalIfAllPositives(final int[] arr, int k) {
    if (arr.length == 1) {
        return arr[0] == k ? 1 : 0;
    }

    int maxLen = 0;

    int i = 0, j = 1;
    int sum = arr[i] + arr[j];

    while (j < arr.length) {
        if (sum == k) {
            maxLen = Math.max(maxLen, j - i + 1);
        }
        while (sum > k && i <= j) {
            sum -= arr[i];
            i++;
        }
        j++;
    }

    return maxLen;
}
```
