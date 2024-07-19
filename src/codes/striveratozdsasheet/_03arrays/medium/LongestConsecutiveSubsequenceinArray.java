package codes.striveratozdsasheet._03arrays.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequenceinArray {
  public int optimal(int[] arr) {
    if (arr.length == 0) {
      return 0;
    }

    Set<Integer> set = new HashSet<>();
    for (int i : arr) {
      set.add(i);
    }
    int answer = 1;

    for (int i : arr) {
      // check if current number forms a subsequence
      // we want to start from bottom of the subsequence so if i - 1
      // exist then we can be sure that it aint the start of the subsequence
      if (set.contains(i - 1)) {
        continue;
      }

      int length = 1;
      for (int successor = i + 1; set.contains(successor); successor++) {
        length++;
      }

      answer = Math.max(answer, length);
    }

    return answer;
  }

  public int better(int[] arr) {
    if (arr.length == 0) {
      return 0;
    }
    Arrays.sort(arr);
    int answer = 1;

    int length = 0;
    int lastNum = Integer.MIN_VALUE;
    for (int i : arr) {
      if (lastNum == i) {
        continue;
      }
      if (lastNum == i - 1) {
        length++;
        answer = Math.max(answer, length);
      } else {
        length = 1;
      }
      lastNum = i;
    }
    return answer;
  }

  public int brute(final int[] arr) {
    int answer = 0;
    for (int i : arr) {
      int length = 1;
      for (int curr = i; successorExists(arr, curr); curr++) {
        length++;
      }
      answer = Math.max(answer, length);
    }

    return answer;
  }

  public static boolean successorExists(int[] arr, int num) {
    for (int i : arr) {
      if (num + 1 == i) {
        return true;
      }
    }

    return false;
  }
}
