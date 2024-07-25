- Problem Link: [LeetCode](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
- Video Solution Link: [Striver](https://youtu.be/nhEMDKMB44g)
## Solutions
### Brute
- Linear Search
```java
  public int brute(int[] arr) {
    int min = Integer.MAX_VALUE;
    for (int i : arr) {
      if (i < min) {
        min = i;
      }
    }
    return min;
  }
```
### Optimal
- We use Binary Search  algorithm similar to [[07 Search in Rotated Array I]], we try to find which part is sorted and get the minimum of that part, cut off that part of the array.
```java
  public int optimal(int[] arr) {
    int min = Integer.MAX_VALUE;
    int low = 0;
    int high = arr.length - 1;
    while (low <= high) {
      int mid = low + ((high - low) >> 1);

      min = Math.min(min, arr[mid]);
      // find which part is sorted
      if (arr[low] <= arr[mid]) {
        // the left part is sorted
        min = Math.min(min, arr[low]);
        low = mid + 1;
      } else {
        // the right part is sorted
        min = Math.min(min, arr[mid]);
        high = mid - 1;
      }
    }
    return min;
  }
```