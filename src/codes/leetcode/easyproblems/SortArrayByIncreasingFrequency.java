package codes.leetcode.easyproblems;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class SortArrayByIncreasingFrequency {

  public int[] brute(int[] arr) {
    Map<Integer, Integer> map = new TreeMap<>();
    for (int i : arr) {
      map.merge(i, 1, Integer::sum);
    }
    AtomicInteger i = new AtomicInteger(0);
    map.entrySet()
        .stream()
        .sorted(((o1, o2) -> {
          int compareCount = o1.getValue() - o2.getValue();
          if (compareCount == 0) {
            // if both values have the same count, then compare them by keys
            return o2.getKey() - o1.getKey();
          }
          return compareCount;
        }))
        .forEach(entry -> {
          int elem = entry.getKey();
          int count = entry.getValue();
          while (count != 0) {
            arr[i.get()] = elem;
            count--;
            i.incrementAndGet();
          }
        });

    return arr;
  }
}
