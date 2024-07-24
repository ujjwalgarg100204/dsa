package codes.striveratozdsasheet._03arrays.hard;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PascalsTriangle {

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

  public List<List<Integer>> better(int n) {
    List<List<Integer>> triangle = new ArrayList<>();
    for (int row = 0; row < n; row++) {
      List<Integer> rowList = new ArrayList<>();
      for (int col = 0; col <= row; col++) {
        rowList.add((int) optimalNcr(row, col));
      }
      triangle.add(rowList);
    }

    return triangle;
  }

  private long optimalNcr(int n, int r) {
    long result = 1;
    for (int i = 0; i < r; i++) {
      result *= n - i;
      result /= i + 1;
    }

    return result;
  }


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
}
