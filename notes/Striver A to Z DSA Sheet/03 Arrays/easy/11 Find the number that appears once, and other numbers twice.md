# Find the number that appears once, and other numbers twice

- Problem Link: [LeetCode](https://leetcode.com/problems/single-number/description/)
- Video Solution Link: [Striver](https://youtu.be/bYWLJb3vCWY?t=1369)

## Solutions

### Brute

1. Create a map of element and its occurrence
2. Populate the map with all elements of array with their occurrence
3. Iterate over the map and return whose occurrence is 1

```java
public int brute(final int[] nums) {
    Map<Integer, Integer> map = new HashMap<>(nums.length);
    for (int i : nums) {
        map.merge(i, 1, (key, value) -> value + 1);
    }

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        if (entry.getValue() == 1) {
            return entry.getKey();
        }
    }

    // dummy return statement
    return -1;
}
```

### Optimal

Before solving this question we should know one property of xor, ie, we xor
same number twice, we get 0 and any number xored with 0, gives us back the same
number

1. Initialize `xor` with 0
2. xor all elements of array with `xor`
3. return value of `xor`

```java
public int optimal(final int[] nums) {
    int xor = 0;
    for (int i : nums) {
        xor ^= i;
    }
    return xor;
}
```
