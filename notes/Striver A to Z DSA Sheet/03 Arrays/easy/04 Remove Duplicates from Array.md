# Remove Duplicates from the Array

Problem Link: [Leetcode](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)
Video Solution Link: [Striver](https://www.youtube.com/watch?t=1887&v=37E9ckMDdTk&feature=youtu.be)

## Solutions

### Brute

1. We put the array elements into a sorted set
   - This will remove all duplicates and keep the elements in sorted order
2. We then fill the array from the set and return the new size

```java
public int brute(int[] arr) {
    Set<Integer> set = new TreeSet<>();
    for (int i : arr) {
        set.add(i);
    }

    int j = 0;
    for (int i : set) {
        arr[j] = i;
        j++;
    }

    return set.size();
}
```

### Optimal

We take advantage of the fact that array is sorted, we keep two pointers
`i -> 0`, `j -> 1`. `i` keeps the position where array is sorted without any duplicates
and `j` is used to iterate through the array.
Whenever `j` finds an element which is bigger than element at `i`, we place
that element at position `i + 1` and increment `i` pointer

```java
public int optimal(int[] arr) {
    int i = 0;
    for (int j = 1; j < arr.length; j++) {
        if (arr[j] > arr[i]) {
            arr[i + 1] = arr[j];
            i++;
        }
    }

    return i + 1;
}
```
