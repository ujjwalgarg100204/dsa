- Problem Link: [LeetCode](https://leetcode.com/problems/search-insert-position/)
- Video Solution Link: [Striver](https://youtu.be/6zhGS79oQ4k)
## Solution
### Brute
- We use **Linear Search** to find the correct insert position. We check if target is smaller than element at current index and larger than that of previous index, or equal to current index, if true we return current index
- Boundary Checks
	- For above logic to work we need previous index so we have to start loop from 1, and specially check for index 0, if it is `<=` than `arr[0]` we return 0.
	- We also check explicitly for last index whether target is greater than `arr[arr.length - 1]`. If yes then return `arr.length` as desired searched position
```java
  // uses linear search
  public int brute(int[] arr, int target) {
    // if target is smaller than first element then 0th index is its
    // correct position
    if (target <= arr[0]) {
      return 0;
    } else if (target > arr[arr.length - 1]) {
      return arr.length;
    }
    for (int i = 1; i < arr.length; i++) {
      // if target smaller than current element and bigger than previous
      // element current index is its correct position
      if (arr[i] == target || (target < arr[i] && target > arr[i - 1])) {
        return i;
      }
    }
    return -1;
  }
```
### Optimal
- We use Binary Search in this approach without any modification, because by default if binary search does not find the element it leaves the `low, mid, high` pointer at position where it should have been present
```java
  // uses binary search
  public int solution(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;
    while (low <= high) {
      int mid = low + ((high - low) >> 1);

      if (arr[mid] == target) {
        return mid;
      } else if (arr[mid] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return low;
  }
```