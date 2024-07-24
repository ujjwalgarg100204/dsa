- Problem Link: [GeeksForGeeks](https://bit.ly/3SVcOqW)
- Video Solution Link: [Striver](https://youtu.be/hjR1IYVx9lY)
## Solution
### Brute
- Linear Search
```java
  public int brute(int[] arr, int target) {
    int count = 0;
    for (int i : arr) {
      if (i == target) {
        count++;
      }
    }
    return count;
  }
```
### Better Brute
- We find the first occurrence by using binary search and count the rest using linear search
```java
  public int betterBrute(int[] arr, int target) {
    int firstOccur = getFirstOccur(arr, target);
    int count = 0;
    if (firstOccur == -1) {
      return count;
    }

    while (firstOccur < arr.length && arr[firstOccur] == target) {
      count++;
      firstOccur++;
    }
    return count;
  }
```
### Optimal
- From the last question we find the first occurrence and last occurrence and simply subtract them to get count
```java
  public int optimal(int[] arr, int target) {
    int firstOccur = getFirstOccur(arr, target);
    int secOccur = getLastOccur(arr, target);

    return secOccur - firstOccur + 1;
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