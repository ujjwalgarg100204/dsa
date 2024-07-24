- Problem Link: [GeeksForGeeks](https://www.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1?track=DSASP-Searching&amp%253BbatchId=154&utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=floor-in-a-sorted-array)
- Video Solution Link: [Striver](https://youtu.be/6zhGS79oQ4k)
## Solution
### Brute
- Linear Search
- **Time Complexity: `O(N)`**
- **Space Complexity: `O(1)`**
```java
  public static int brute(long[] arr, long x) {
    int lowerBoundIdx = -1;
    long lowerBound = Long.MAX_VALUE;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > x && arr[i] < lowerBound) {
        lowerBound = arr[i];
        lowerBoundIdx = i;
      }
    }

    return lowerBoundIdx;
  }
```
### Optimal
- We use binary search to get the optimal solution, for the problem
- In the normal routine of binary search we try to eliminate solution space to get time complexity `O(log N)`
- Here whenever, we see that the mid is greater than or equal to x we, look towards the left part of the array, we contains smaller numbers than the current number, thus getting better lower bound of the array
- However if we get mid is smaller, we look for a bigger number in the right solution space
```java
  public static int solution(long[] arr, long x) {
    // check the existence of lower bound
    if (arr[arr.length - 1] < x) {
      // if largest element in the array is smaller than x, then there
      // is no lower bound of that number in that array
      return -1;
    }

    int lowerBoundIdx = -1;
    int low = 0;
    int high = arr.length - 1;
    while (low <= high) {
      int mid = low + ((high - low) >> 1);

      if (arr[mid] >= x) {
        lowerBoundIdx = mid;
        // look for better lowerBound towards left part
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return lowerBoundIdx;
  }
```
