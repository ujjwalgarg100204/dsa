package codes.striveratozdsasheet._04binarysearch._01_1darray;

import java.util.Arrays;

public class ImplementUpperBound {

  // upper bound is number which is just smaller than or equal to given number
  // present in the array
  public static int brute(int[] arr, int x) {
    int upperBound = Integer.MIN_VALUE;
    for (int i : arr) {
      if (i <= x && i > upperBound) {
        upperBound = i;
      }
    }
    return upperBound;
  }

  public static int optimalSolution(int[] arr, int x) {
    int upperBound = Integer.MIN_VALUE;
    // check about existence of upper bound in the array for x
    if (arr[0] > x) {
      // if lowest element in array is bigger than x, then there is
      // upper bound for x
      return upperBound;
    }
    int low = 0;
    int high = arr.length - 1;
    while (low <= high) {
      int mid = low + ((high - low) >> 1);

      if (arr[mid] == x) {
        return x;
      } else if (arr[mid] < x) {
        upperBound = arr[mid];
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return upperBound;
  }

  public static int[] optimal(final int[] arr, int x) {
    int lowerBound = Integer.MIN_VALUE;
    int upperBound = Integer.MAX_VALUE;

    for (int i : arr) {
      // lower bound
      if (i <= x && i > lowerBound) {
        lowerBound = i;
      }
      // upper bound
      if (i >= x && i < upperBound) {
        upperBound = i;
      }
    }

    return new int[]{lowerBound == Integer.MIN_VALUE ? -1 : lowerBound,
        upperBound == Integer.MAX_VALUE ? -1 : upperBound};
  }

  // lower bound is number which is just greater than or equal to given number
  // present in the array
  // upper bound is number which is just smaller than or equal to given number
  // present in the array

  public static int[] solution(int[] arr, int x) {
    Arrays.sort(arr);
    int[] ans = new int[2];

    ans[0] = getUpperBound(arr, x);
    arr[1] = getLowerBound(arr, x);

    return ans;
  }

  private static int getLowerBound(int[] arr, int x) {
    // check if lower bound exits for the arr
    if (arr[arr.length - 1] < x) {
      return -1;
    }
    int lowerBound = -1;
    int low = 0;
    int high = arr.length - 1;
    while (low <= high) {
      int mid = low + ((high - low) >> 1);
      if (arr[mid] > x) {
        lowerBound = arr[mid];
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return lowerBound;
  }

  private static int getUpperBound(int[] arr, int x) {
    // check if upper bound exists for the arr
    if (arr[0] > x) {
      return -1;
    }
    int upperBound = -1;
    int low = 0;
    int high = arr.length - 1;
    while (low <= high) {
      int mid = low + ((high - low) >> 1);
      if (arr[mid] <= x) {
        // continue to look for better upperBound
        upperBound = arr[mid];
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return upperBound;
  }
}
