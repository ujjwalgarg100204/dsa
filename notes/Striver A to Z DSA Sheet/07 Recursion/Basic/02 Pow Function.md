- Problem Link: [LeetCode](https://leetcode.com/problems/powx-n)
- Video Solution Link: [Striver](https://www.youtube.com/watch?v=l0YC3876qxg)
## Solution using Recursion
 If we go linearly we going to face TLE, so we make an observation
 $$ 2^{10} = (2^2)^5; 4^5 = 4 * (4^2)^2 $$

> [!Note] Pitfall: Boundary Value Check
> Problem statement states that `n` can vary from `INT_MIN` to `INT_MAX` inclusive, and `INT_MIN` can't be converted directly to `INT_MAX`, as it would lead to buffer-overflow, so i multiply till `INT_MAX` first and then multiply once more to get the right ans

```java
  public double recursiveSolution(double x, int n) {
    double ans;
    if (n < 0) {
      if (n == Integer.MIN_VALUE) {
        ans = recursiveSolutionForPositivePower(x, Math.abs(n + 1));
        ans *= ans;
      } else {
        ans = recursiveSolutionForPositivePower(x, -n);
      }
      ans = 1 / ans;
    } else {
      ans = recursiveSolutionForPositivePower(x, n);
    }
    return ans;
  }

  private double recursiveSolutionForPositivePower(double x, int n) {
    if (x == 1) {
      return 1;
    } else if (n == 1) {
      return x;
    } else if (n == 0) {
      return 1;
    }

    if ((n & 1) == 0) {
      return recursiveSolutionForPositivePower(x * x, n / 2);
    } else {
      return x * recursiveSolutionForPositivePower(x, n - 1);
    }
  }
```