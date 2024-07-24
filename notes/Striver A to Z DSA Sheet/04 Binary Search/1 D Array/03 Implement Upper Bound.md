- Problem Link: [GeeksForGeeks](https://bit.ly/3CgDDjE)
- Video Solution Link: [Striver](https://youtu.be/6zhGS79oQ4k)
## Solutions
Upper Bound is number which is just smaller than the given number in a given array
### Brute
- Linear Search
```java
  public static int brute(int[] arr, int x) {
    int upperBound = Integer.MIN_VALUE;
    for (int i : arr) {
      if (i <= x && i > upperBound) {
        upperBound = i;
      }
    }
    return upperBound;
  }
```
### Optimal
- Similar to [[02 Implement Lower Bound]], we look for the biggest smallest element and when we find one we look towards the right side, to get bigger elements than current element but at the same time smaller than target element `x`
```java
  public static int optimalSolution(int[] arr, int x) {
    int upperBound = Integer.MIN_VALUE;
    // check about existence of upper bound in the array for x
    if (arr[0] > x) {
      // if lowest element in array is bigger than x, then there is
      // upper bound for x
      return upperBound;
    }
    int low = 0;
    int high = arr.length - 1;
    while (low <= high) {
      int mid = low + ((high - low) >> 1);

      if (arr[mid] == x) {
        return x;
      } else if (arr[mid] < x) {
        upperBound = arr[mid];
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return upperBound;
  }
```