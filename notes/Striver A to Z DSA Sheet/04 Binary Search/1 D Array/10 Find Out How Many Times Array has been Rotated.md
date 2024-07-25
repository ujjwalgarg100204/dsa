- Problem Link: [GeeksForGeeks](https://bit.ly/3dEvWJD)
- Video Solution Link: [Striver](https://youtu.be/jtSiWTPLwd0)
## Solutions
- Using binary Search
- We get the index of the minimum in array using [[09 Find Minimum in Sorted Rotated Array]] and simply subtract 1 from it (0 based indexing)
```java
  public int solution(List<Integer> arr) {
    int minIdx = getMinIdx(arr);
    return minIdx - 1;
  }

  private int getMinIdx(List<Integer> arr) {
    int min = Integer.MAX_VALUE;
    int minIdx = -1;
    int low = 0;
    int high = arr.size() - 1;

    while (low <= high) {
      int mid = low + ((high - low) >> 1);

      if (arr.get(low) <= arr.get(mid)) {
        if (arr.get(low) < min) {
          min = arr.get(low);
          minIdx = low;
        }
        low = mid + 1;
      } else {
        // the right part is sorted
        if (arr.get(mid) < min) {
          min = arr.get(mid);
          minIdx = mid;
        }
        high = mid - 1;
      }
    }
    return minIdx;
  }
```