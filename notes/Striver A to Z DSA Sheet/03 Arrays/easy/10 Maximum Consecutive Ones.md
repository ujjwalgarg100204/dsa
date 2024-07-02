# Maximum Consecutive Ones

- Problem Link: [LeetCode](https://leetcode.com/problems/max-consecutive-ones/description)
- Video Solution Link: [Striver](https://youtu.be/bYWLJb3vCWY?t=1124)

## Solution

Keep count of 1s in current iteration and maximum count, and update `maxCnt`
whenever you encounter 0

```java
public int solution(final int[] nums) {
    int currCnt = 0;
    int maxCnt = 0;
    for (int i : nums) {
        if (i == 1) {
            currCnt++;
        } else {
            maxCnt = Math.max(maxCnt, currCnt);
            currCnt = 0;
        }
    }

    maxCnt = Math.max(maxCnt, currCnt);

    return maxCnt;
}
```
