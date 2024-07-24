- Problem Link: [LeetCode](https://leetcode.com/problems/search-in-rotated-sorted-array/)
- Video Solution Link: [Striver](https://youtu.be/5qGrJbHhqFs)
## Solutions
### Brute
- Linear Search
```java
  public int brute(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == target) {
        return i;
      }
    }
    return -1;
  }
```
### Better
- We know that if an array is rotated once, we know that at least one part will be sorted in ascending order, which we can tell by comparing `arr[low]` with `arr[mid]`
	- if `arr[low] < arr[mid]` it means that left part is sorted and so we find the element there and if we find it we return its index by doing another binary search in restricted search space, and we limit search space from **mid** to **high**
	- if not, then if we right part is sorted. We find the element in right part and if we find it we return its index by doing another binary search in restricted space
```java
  public int better(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;
    while (low <= high) {
      int mid = low + ((high - low) >> 1);

      if (arr[mid] == target) {
        return mid;
      }
      // find which part is sorted
      if (arr[low] < arr[mid]) {
        // the left part is sorted
        int idx = Arrays.binarySearch(arr, low, mid, target);
        if (isValidIdx(arr, idx) && arr[idx] == target) {
          return idx;
        }
        low = mid + 1;
      } else {
        // the right part is sorted
        int idx = Arrays.binarySearch(arr, mid + 1, high + 1, target);
        if (isValidIdx(arr, idx) && arr[idx] == target) {
          return idx;
        }
        high = mid - 1;

      }
    }

    return -1;
  }
```
### Optimal
- We optimise the solution by omitting nested binary search
- **Checking if the left part is sorted**:
    - If `arr[low] <= arr[mid]`, it means the left portion from `low` to `mid` is sorted.
    - If the target is within the range of `arr[low]` to `arr[mid-1]`, adjust the `high` pointer to `mid - 1`.
    - Otherwise, adjust the `low` pointer to `mid + 1`.
- **Checking if the right part is sorted**:
    - If `arr[low] > arr[mid]`, it means the right portion from `mid` to `high` is sorted.
    - If the target is within the range of `arr[mid+1]` to `arr[high]`, adjust the `low` pointer to `mid + 1`.
    - Otherwise, adjust the `high` pointer to `mid - 1`.
```java
  public int optimal(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;
    while (low <= high) {
      int mid = low + ((high - low) >> 1);

      if (arr[mid] == target) {
        return mid;
      }
      // find which part is sorted
      if (arr[low] <= arr[mid]) {
        // the left part is sorted
        if (target >= arr[low] && target < arr[mid]) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }

      } else {
        // the right part is sorted
        if (target > arr[mid] && target <= arr[high]) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }
    }

    return -1;
  }
```