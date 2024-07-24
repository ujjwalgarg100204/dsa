- Problem Link: [LeetCode](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array)
- Video Solution Link: [Striver](https://youtu.be/hjR1IYVx9lY)
## Solution
### Brute
- Linear Search
```java
  public int[] brute(int[] arr, int target) {
    int[] result = new int[2];
    Arrays.fill(result, -1);

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == target) {
        if (result[0] == -1) {
          result[0] = i;
        }
        result[1] = i;
      }
    }
    return result;
  }
```
### Better Brute
- We optimise a little by finding first position by using binary search, then use linear search to find the last position
```java
  public int[] betterBrute(int[] arr, int target) {
    int[] result = new int[2];

    int firstOccur = Arrays.binarySearch(arr, target);
    result[0] = firstOccur;
    result[1] = firstOccur;
    if (firstOccur == -1) {
      return result;
    }

    // keep updating both first and last occurrences
    for (int i = firstOccur; i >= 0 && arr[i] == target; i--) {
      result[0] = i;
    }
    for (int i = firstOccur; i < arr.length && arr[i] == target; i++) {
      result[1] = i;
    }

    return result;
  }
```
### Optimal
- We use the concept of [[02 Implement Lower Bound]] and [[03 Implement Upper Bound]]. We find first occurrence by using upper bound and last occurrence by using lower bound
- We use separate binary searches, one for finding first occurrence and other for finding last occurrence
```java
  public int[] optimal(int[] arr, int target) {
    var result = new int[2];
    result[0] = getFirstOccur(arr, target);
    if (result[0] == -1) {
      result[1] = -1;
      return result;
    }
    result[1] = getLastOccur(arr, target);

    return result;
  }

  private int getFirstOccur(int[] arr, int target) {
    int occur = -1;
    int low = 0;
    int high = arr.length - 1;
    while (low <= high) {
      int mid = low + ((high - low) >> 1);

      if (arr[mid] == target) {
        occur = mid;
        high = mid - 1;
      } else if (arr[mid] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return occur;
  }

  private int getLastOccur(int[] arr, int target) {
    int occur = -1;
    int low = 0;
    int high = arr.length - 1;
    while (low <= high) {
      int mid = low + ((high - low) >> 1);

      if (arr[mid] == target) {
        occur = mid;
        low = mid + 1;
      } else if (arr[mid] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return occur;
  }
```