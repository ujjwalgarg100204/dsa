package codes.striveratozdsasheet._03arrays.medium;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

  public int brute(final int[] arr, int k) {
    // generate all the sub-arrays and filter out those array which have sum as k, and keep count
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
      int sum = 0;
      for (int j = i; j < arr.length; j++) {
        sum += arr[j];
        if (sum == k) {
          count++;
        }
      }
    }

    return count;
  }

  public int optimal(final int[] arr, int k) {
    Map<Integer, Integer> preSum = new HashMap<>();
    int count = 0;
    int sum = 0;
    for (int i : arr) {
      sum += i;
      if (sum == k) {
        count++;
      }
      if (preSum.containsKey(sum - k)) {
        count += preSum.get(sum - k);
      }
      preSum.merge(sum, 1, Integer::sum);
    }

    return count;
  }
}
