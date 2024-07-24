- Problem Link: [LeetCode](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/)
- Video Solution Link: [Striver](https://youtu.be/w2G2W8l__pc)
## Solution
This time we have duplicates in the array, but we can get away with making small adjustments in the code. We can pass all test cases except where `arr[low] = arr[mid] = arr[high]` so in that case we simply increment `low` and `high`
```java
  public boolean solution(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;
    while (low <= high) {
      int mid = low + ((high - low) >> 1);

      if (arr[mid] == target) {
        return true;
      }
      if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
        low++;
        high--;
        continue;
      }
      // find which part is sorted
      if (arr[low] <= arr[mid]) {
        // the left part is sorted
        if (target >= arr[low] && target <= arr[mid]) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      } else {
        // the right part is sorted
        if (target >= arr[mid] && target <= arr[high]) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }
    }
    return false;
  }
```
