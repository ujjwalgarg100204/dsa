---
id: 08 Next Permutation
aliases: []
tags: []
---

# Next Permutation

Problem Link: [LeetCode](https://leetcode.com/problems/next-permutation/description/)
Video Solution Link: [Striver](https://youtu.be/JDOXKqF60RQ)

## Solution

Solving this problem takes 3 steps:
1. Find the pivot point
  - Here, the pivot point in array is from the right side where `arr[i] > arr[i - 1]`
2. Swap the `pvtIdx - 1` index with a number which is its smallest maximum in the sub-array `arr[pvtIdx:]` if it exists
3. Sort the sub-array `arr[pvtIdx:]`

But if the pivot point is not found, then we need to reverse the array.

```java
public void solution(int[] arr) {
  // find the pivot point from right
  int pvtIdx = -1;
  for (int i = arr.length - 1; i > 0; i--) {
    if (arr[i] > arr[i - 1]) {
      pvtIdx = i;
      break;
    }
  }

  if (pvtIdx == -1) {
    // reverse the array
    for (int i = 0; i < arr.length / 2; i++) {
      swap(arr, i, arr.length - 1 - i);
    }
    return;
  }

  // find the element to swap with pivot - 1
  // it has to be swapped with number which is just bigger than it
  int justBiggerIdx = pvtIdx;
  int justBiggerNum = arr[pvtIdx];
  for (int i = pvtIdx; i < arr.length; i++) {
    if (arr[i] > arr[pvtIdx - 1] && arr[i] < justBiggerNum) {
      justBiggerIdx = i;
      justBiggerNum = arr[i];
    }
  }
  swap(arr, pvtIdx - 1, justBiggerIdx);

  // sort the rest of the array
  Arrays.sort(arr, pvtIdx, arr.length);
}
```

