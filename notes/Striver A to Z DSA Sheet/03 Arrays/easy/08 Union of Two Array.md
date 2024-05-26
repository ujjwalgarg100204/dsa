# Union of Two Array

Problem Link: [GeeksForGeeks](https://www.geeksforgeeks.org/problems/union-of-two-sorted-arrays-1587115621/1)
Video Solution Link: [Striver](https://youtu.be/wvcQg43_V8U?t=2584)

## Solution

### Brute

`TreeSet` in Java is a **Set** which stores element in a sorted manner, and does
not allow duplicates

```java
public List<Integer> brute(int[] arr1, int[] arr2) {
    Set<Integer> set = new TreeSet<>();
    for (int i : arr1) {
        set.add(i);
    }
    for (int i : arr2) {
        set.add(i);
    }

    return new ArrayList<>(set);
}
```

### Optimal

We iterate over the both of the arrays and keep adding the smallest of the current
iteration to answer provided that the last element in answer array is also smaller
than the aforementioned number

```java
public List<Integer> optimal(int[] arr1, int[] arr2) {
    List<Integer> ans = new ArrayList<>();

    int i = 0, j = 0;
    while (i < arr1.length && j < arr2.length) {
        int newElem = -1;
        if (arr1[i] < arr2[j]) {
            newElem = arr1[i];
            i++;
        } else {
            newElem = arr2[j];
            j++;
        }

        if (ans.isEmpty() || ans.get(ans.size() - 1) < newElem) {
            ans.add(newElem);
        }

    }

    while (i < arr1.length) {
        if (ans.get(ans.size() - 1) < arr1[i]) {
            ans.add(arr1[i]);
        }
        i++;
    }

    while (j < arr2.length) {
        if (ans.get(ans.size() - 1) < arr2[j]) {
            ans.add(arr2[j]);
        }
        j++;
    }

    return ans;
}
```
