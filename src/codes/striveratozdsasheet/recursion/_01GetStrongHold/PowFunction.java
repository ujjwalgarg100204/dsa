package codes.striveratozdsasheet.recursion._01GetStrongHold;

public class PowFunction {

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
}
