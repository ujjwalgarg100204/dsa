package codes.striveratozdsasheet.recursion._01GetStrongHold;

public class CountGoodNumbers {

  private static final int MOD = 1000000007;

  public int brute(long n) {
    long ans = 1;
    for (int i = 0; i < n; i++) {
      int toMultiply = (i & 1) == 0 ? 5 : 4;
      ans = ((ans % MOD) * toMultiply) % MOD;
    }

    return (int) ans;
  }

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
}
