 - Problem Link: [LeetCode](https://leetcode.com/problems/single-element-in-a-sorted-array/)
 - Video Solution Link: [Striver](https://youtu.be/AZOmHuHadxQ)
## Solutions
### Brute
- Xor based solution [[11 Find the number that appears once, and other numbers twice]]
```java
  public int brute(int[] arr) {
    int singleElem = 0;
    for (int i : arr) {
      singleElem ^= i;
    }
    return singleElem;
  }
```
### Optimal
- We use binary search in this problem, but to use it we need two things
	1. Some way decrease our search space in halves each time
	2. Some way to get solution using `low`, `mid` or `high` indices
- Upon looking closely we find that elements in the array before single element occur at even indices, so `0 0 1 1 2 2 3 4 4`, first `0`, `1`, `2` all occur at even indices and their subsequent duplicate occurs at odd indices. But first `4` occurs at odd index, giving us a hint that single element occurs before `4`, and we use this.
- Since in this question we need to check at `i-1`, `i+1` where `i` is iteration index, we can use `low=0;high=n-1` as we usually do, but we will have to write too many boundary checks, to we check for boundary separately making our code more readable.
- So now beginning from `low=1;high=n-2`, we check whether `arr[mid]` is single element or not, if it is not, then we check whether current index is even or odd
	- if index is **even** then we check whether its `i+1` is same or not, because if it is same, single element lies ahead, and if not, then single element is behind it
	- if index is **odd** then we check whether its `i-1` is same or not, because if it is same, then single element lies ahead,  and if not, then single element is behind it
	- if it yields `true`, we limit the search space from `[low, high]` to `[mid + 1, high]`
		- otherwise `[low, mid - 1]`
```java
  public int optimal(int[] arr) {
    if (arr.length == 1) {
      return arr[0];
    }
    if (arr[0] != arr[1]) {
      return arr[0];
    } else if (arr[arr.length - 1] != arr[arr.length - 2]) {
      return arr[1];
    }
    int low = 1;
    int high = arr.length - 2;

    while (low <= high) {
      int mid = low + ((high - low) >> 1);

      if (arr[mid - 1] != arr[mid] && arr[mid + 1] != arr[mid]) {
        return arr[mid];
      }

      // check of even / odd index, and check the left and right element accordingly
      if (((mid & 1) == 0 && arr[mid] == arr[mid + 1]) ||
          ((mid & 1) != 0 && arr[mid] == arr[mid - 1])) {
        // if mid is even, and it is equal to its right element or mid is odd, and it is
        // equal to its left element, then the single element exists in right part
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    // code will never reach here
    return -1;
  }
```
 