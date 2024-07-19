package codes.striveratozdsasheet._03arrays.medium;

public class StockBuyandSell {

  public int mostOptimal(final int[] arr) {
    int maxProfit = 0;

    int min = Integer.MAX_VALUE;
    for (int i : arr) {
      min = Math.min(i, min);
      maxProfit = Math.max(maxProfit, min - i);
    }

    return maxProfit;
  }

  public int optimal(final int[] arr) {
    int maxProfit = 0;

    int minPriceIndex = getMinIndex(arr);
    int maxPriceIndex = -1;
    int max = arr[minPriceIndex];
    for (int i = minPriceIndex + 1; i < arr.length; i++) {
      if (arr[i] > max) {
        max = arr[i];
        maxPriceIndex = i;
      }
    }

    // no solution
    if (maxPriceIndex == -1) {
      return 0;
    }

    return maxProfit;
  }

  private static int getMinIndex(final int[] arr) {
    int minIdx = -1;
    int min = arr[0];
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < min) {
        min = arr[i];
        minIdx = i;
      }
    }

    return minIdx;
  }

  public int brute(final int[] arr) {
    int maxProfit = 0;

    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] > arr[i]) {
          int profit = arr[j] - arr[i];
          maxProfit = Math.max(maxProfit, profit);
        }
      }
    }

    return maxProfit;
  }
}
