# Largest Element in the an Array

Problem Link: [GeeksForGeeks](https://www.geeksforgeeks.org/problems/largest-element-in-array4009/0)

## Solution

```java
public int solution(int[] arr) {
    int max = arr[0];
    for (int i : arr) {
        max = Math.max(max, i);
    }
    return max;
}
```
