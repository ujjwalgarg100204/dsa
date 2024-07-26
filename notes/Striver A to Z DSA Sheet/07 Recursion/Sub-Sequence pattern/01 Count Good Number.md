- Problem Link: [LeetCode](https://leetcode.com/problems/count-good-numbers)
- Video Solution Link: `NA`
## Solution
## Brute
- We find that on even indices only 5 numbers can be placed and on odd indices only 4 numbers can be placed so I run a loop from 0 to n (exclusive) and multiply 4 and 5 alternatively to get required result
```java
  public int brute(long n) {
    long ans = 1;
    for (int i = 0; i < n; i++) {
      int toMultiply = (i & 1) == 0 ? 5 : 4;
      ans = ((ans % MOD) * toMultiply) % MOD;
    }

    return (int) ans;
  }
```
### Better
- Instead of multiplying them individually we use `pow` function write in [[02 Pow Function]] to do it in `log(N)` time, so we create a modification of `pow` function to have result modded at 10^9 + 7   
```java
  public int better(long n) {
    // in odd cases, 5 occurs once more than 4
    long ans = (pow(5, (n + 1) / 2) * pow(4, n / 2)) % MOD;
    return (int) ans;
  }

  private static long pow(long x, long n) {
    long ans = 1L;
    while (n > 0) {
      if ((n & 1) != 0) {
        ans = ((ans % MOD) * (x % MOD)) % MOD;
        n = n - 1;
      } else {
        x = (x * x) % MOD;
        n = n / 2;
      }
    }
    return ans;
  }
```