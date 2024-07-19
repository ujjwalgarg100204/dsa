package codes.striveratozdsasheet._03arrays.easy;

import java.util.Arrays;

/**
 * SecondLargestElementInArray
 */
public class SecondLargestElementInArray {

    public int brute(int[] arr) {
        Arrays.sort(arr);
        final int N = arr.length;
        int max = arr[N - 1];

        for (int i = N - 2; i >= 0; i--) {
            if (arr[i] != max) {
                return arr[i];
            }
        }
        return -1;
    }

    public int better(int[] arr) {
        // find 1st max
        int firstMax = arr[0];
        for (int i : arr) {
            firstMax = Math.max(firstMax, i);
        }

        // find 2nd max
        int secMax = Integer.MIN_VALUE;
        for (int i : arr) {
            if (i < firstMax) {
                secMax = Math.max(i, secMax);
            }
        }

        return secMax == Integer.MIN_VALUE ? -1 : secMax;
    }

    public int optimized(int[] arr) {
        int firstMax = Integer.MIN_VALUE;
        int secMax = Integer.MIN_VALUE;

      for (int j : arr) {
        // update second max whenever firstMax is changed
        if (j > firstMax) {
          secMax = firstMax;
          firstMax = j;
        } else if (j > secMax && j != firstMax) {
          secMax = j;
        }
      }

        return secMax == Integer.MIN_VALUE ? -1 : secMax;
    }

}
