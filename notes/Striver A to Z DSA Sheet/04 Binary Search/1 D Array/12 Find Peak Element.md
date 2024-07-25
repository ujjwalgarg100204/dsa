- Problem Link: [LeetCode](https://leetcode.com/problems/find-peak-element/#:~:text=Find%20Peak%20Element%20%2D%20LeetCode&text=A%20peak%20element%20is%20an,to%20any%20of%20the%20peaks.)
- Video Solution Link: [Striver](https://youtu.be/cXxmbemS6XM)
## Solution
### Brute
- Linear Search
```java
  public int brute(int[] arr) {
    if (arr.length == 1) {
      return 0;
    }
    // check for first index
    if (arr[0] > arr[1]) {
      return 0;
    } else if (arr[arr.length - 1] > arr[arr.length - 2]) {
      // check for last index
      return arr.length - 1;
    }
    for (int i = 1; i < arr.length - 1; i++) {
      if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
        return i;
      }
    }
    return -1;
  }
```
### Optimal
- For better solution you should see video, but basic crux is, if you draw the graph of the array of any input you will see it makes a saw-tooth kinda figure.
- Now imagine if you were on a increasing line then you know that peak exists ahead, and if you were on decreasing line then you know that peak exists behind, we use this idea to find peak using binary search. We can guarantee that we can find a peak if it exists but which will will be the answer, we can't be sure of that.
- However, we need to handle one specific condition wherein `mid` pointer comes at `minima` point of the graph, at this point, we can't be sure where peak exists so can either go towards `low` side or `high` side, I chose `low` side

> [!Warning] When it works
> It only works because question specifically asks that we can return any index of any peak, it had been specific like first peak or something else, it wouldn't have worked

```java
  private int optimal(int[] arr) {
    if (arr.length == 1) {
      return 0;
    } else if (arr[0] > arr[1]) {
      // check for first index
      return 0;
    } else if (arr[arr.length - 1] > arr[arr.length - 2]) {
      // check for last index
      return arr.length - 1;
    }

    int low = 1;
    int high = arr.length - 2;
    while (low <= high) {
      int mid = low + ((high - low) >> 1);

      if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
        return mid;
      } else if (arr[mid] > arr[mid - 1]) {
        low = mid + 1;
      } else if (arr[mid] > arr[mid + 1]) {
        high = mid - 1;
      } else {
        // test will fall here when we are at the minima position,
        // here, we can either go towards right or left, as both would have peaks,
        // I choose left half
        high = mid - 1;
      }
    }

    return -1;
  }
```