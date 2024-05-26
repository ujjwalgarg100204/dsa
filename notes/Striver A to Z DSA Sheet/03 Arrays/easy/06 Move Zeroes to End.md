# Move Zeroes to End

Problem Link: [Leetcode](https://leetcode.com/problems/move-zeroes/description/)
Video Solution Link: [Striver](https://youtu.be/wvcQg43_V8U?t=1633)

## Solution

### Brute

```java
public void brute(int[] arr) {
    int[] cpy = new int[arr.length];

    int zeroCount = 0;
    for (int i = 0, j = 0; i < arr.length; i++) {
        if (arr[i] != 0) {
            cpy[j] = arr[i];
            j++;
        } else {
            zeroCount++;
        }
    }

    for (int i = arr.length - 1, j = 0; j < zeroCount; j++, i--) {
        cpy[i] = 0;
    }

    System.arraycopy(cpy, 0, arr, 0, arr.length);
}
```

### Optimal - Using Two Pointer Approach

We use two pointers to solve this problem

- `i`: from 0 to `i`, we assume array contains all non-zero elements
- `j`: we use this pointer to iterate over the array

#### Algorithm

1. Initialize `i` to -1
2. Iterate array from 0 till end
   - For every non-zero element you find in the iteration you store that
     element at `i + 1`, and then increment `i` keeping above property of `i`
3. Now, all non-zero elements are copied to subarray\[0, i\] (inclusive),
   and rest of the array needs to be filled with zero
   - So start iteration from `i + 1` till end of the array, and fill it with
     zero

#### Edge-Cases

1. All zero array: In this case, first for loop won't ever go to its if
   condition, so i won't change and we return early
2. No Zero: In this case, for loop will make **i -> arr.length - 1**, after
   which we increment i, so we won't every go into the while loop

```java
public void optimal(int[] arr) {
    int i = -1;
    for (int j = 0; j < arr.length; j++) {
        if (arr[j] != 0) {
            arr[i + 1] = arr[j];
            i++;
        }
    }
    // in case there is no non-zero element
    if (i == -1) {
        return;
    }

    i++;
    while (i < arr.length) {
        arr[i] = 0;
        i++;
    }
}
```
