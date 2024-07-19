- Problem Link: [LeetCode](https://leetcode.com/problems/binary-search/)
- Video Solution Link: [Striver](https://youtu.be/MHf6awe89xw)
## Solution
### Iterative
```java
  public int iterative(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;
    while (low <= high) {
      int mid = (low + high) >> 1;
      if (arr[mid] == target) {
        return mid;
      } else if (arr[mid] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return -1;
  }

```
### Recursive
```java
  public int recursive(final int[] arr, int target, int low, int high) {
    if (low >= high) {
      return -1;
    }
    int mid = (low >> 1) + (high >> 1);
    if (arr[mid] == target) {
      return mid;
    } else if (arr[mid] > target) {
      return recursive(arr, target, low, mid - 1);
    } else {
      return recursive(arr, target, mid + 1, high);
    }
  }
```