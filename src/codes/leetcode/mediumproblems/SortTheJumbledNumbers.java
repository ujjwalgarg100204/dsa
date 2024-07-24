package codes.leetcode.mediumproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortTheJumbledNumbers {

  private final String PROBLEM_LINK = "https://leetcode.com/problems/sort-the-jumbled-numbers/description";

  private static int getShuffledNumber(int[] mapping, int num) {
    String n = String.valueOf(num);
    var shuffledNum = new StringBuilder();
    for (int i = 0; i < n.length(); i++) {
      shuffledNum.append(mapping[n.charAt(i) - '0']);
    }

    return Integer.parseInt(shuffledNum.toString());
  }

  public static int[] brute(int[] mapping, int[] nums) {
    // map holds shuffled number mapped to its list of original numbers as they occur
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i : nums) {
      int shuffledNumber = getShuffledNumber(mapping, i);
      List<Integer> originalNums = new ArrayList<>();
      originalNums.add(i);
      map.merge(shuffledNumber, originalNums, (oldVal, newVal) -> {
        oldVal.addAll(newVal);
        return oldVal;
      });
    }

    return map.keySet()
        .stream()
        .sorted()
        .map(map::get)
        .flatMap(List::stream)
        .mapToInt(Integer::intValue)
        .toArray();
  }

  public static int[] better(int[] mapping, int[] nums) {
    return Arrays.stream(nums)
        .boxed()
        .sorted(Comparator.comparingInt(integer -> getShuffledNumber(mapping, integer)))
        .mapToInt(Integer::intValue).toArray();
  }
}
