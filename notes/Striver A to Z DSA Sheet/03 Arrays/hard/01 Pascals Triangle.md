- Problem Link: [LeetCode](https://leetcode.com/problems/pascals-triangle/description/)
- Video Solution Link: [Striver](https://youtu.be/bR7mQgwQ_o8)
## Solution
### Brute
- In this approach I use `BigInteger` to prevent overflow of integers or even longs, since factorials rise pretty high.
- I simply the use the fact that pascals triangle can be calculated using `nCr` formula, where n is the row number (`n-1` for 0 based indexing) and r is column number (`r-1` for 0 based indexing)
- No optimisation for calculating `nCr`

```java
  private static final Map<Integer, BigInteger> memory = new HashMap<>();

  private static BigInteger nCr(int n, int r) {
    BigInteger nFactorial = factorial(n);
    BigInteger rFact = factorial(r);
    BigInteger nMinusRFact = factorial(n - r);

    return nFactorial.divide(rFact).divide(nMinusRFact);
  }

  private static BigInteger factorial(int n) {
    if (memory.containsKey(n)) {
      return memory.get(n);
    }

    // calculate
    BigInteger prod = BigInteger.ONE;
    for (int i = 1; i <= n; i++) {
      prod = prod.multiply(BigInteger.valueOf(i));
      memory.put(i, prod);
    }
    return prod;
  }

  public List<List<Integer>> brute(int n) {
    List<List<Integer>> triangle = new ArrayList<>();
    for (int row = 0; row < n; row++) {
      List<Integer> rowList = new ArrayList<>();
      for (int col = 0; col <= row; col++) {
        rowList.add(nCr(row, col).intValue());
      }
      triangle.add(rowList);
    }

    return triangle;
  }
```
### Better
We try to optimise the calculation of `nCr` in this solution. We notice while calculating `ncr` there are **n** terms in numerator and **r** terms and **n-r** terms in the denominator. Now can let go of **n-r** terms from both numerator and denominator.
- Now we initialise `result` to 1
- now we iterate till `r` multiplying `n-i` which will be n-1, n-2, n-3, ... to result and dividing with `i+1` which will be 1, 2, 3, ...
- We do it this way because `ncr` can be quite big even for small numbers and this way we can be sure that doesn't overflow
```java
  public List<List<Integer>> optimal(int n) {
    List<List<Integer>> triangle = new ArrayList<>();
    for (int row = 0; row < n; row++) {
      List<Integer> rowList = new ArrayList<>();
      for (int col = 0; col <= row; col++) {
        rowList.add((int)optimalNcr(row, col));
      }
      triangle.add(rowList);
    }

    return triangle;
  }

  public long optimalNcr(int n, int r) {
    long result = 1;
    for (int i = 0; i < r; i++) {
      result *= n - i;
      result /= i + 1;
    }

    return result;
  }
}
```
### Optimal
- In this approach we try to find a pattern in Pascal's triangle to remove calculation of `nCr` completely. We do so by noticing pattern in every row from 1st column, where in it can be written as below
$$
\frac{row * (row+1) * (row + 2) * ...} {1 * (1 + 1) * (2 + 1) * ...}
$$
- Moreover clear understanding will come from Striver's Video
```java
  public List<List<Integer>> optimal(int n) {
    List<List<Integer>> triangle = new ArrayList<>();
    for (int row = 1; row <= n; row++) {
      List<Integer> currRow = nthRowOfPascalTriangle(row);
      triangle.add(currRow);
    }

    return triangle;
  }

  public List<Integer> nthRowOfPascalTriangle(int n) {
    List<Integer> result = new ArrayList<>();
    result.add(1);

    long prod = 1;
    for (int col = 1; col < n; col++) {
      prod *= n - col;
      prod /= col;
      result.add((int) prod);
    }

    return result;
  }
```