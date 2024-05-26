# Linear Search

Problem Link: [GeeksForGeeks](https://www.geeksforgeeks.org/problems/who-will-win-1587115621/1)
Video Solution Link: [Striver](https://youtu.be/wvcQg43_V8U?t=2465)

## Solution

```java
public int solution(final int[] arr, int k) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == k) {
            return i;
        }
    }

    return -1;
}
```
