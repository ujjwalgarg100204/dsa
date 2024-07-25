package codes.striveratozdsasheet._04binarysearch._01_1darray;

import java.util.List;

public class FindKthRotation {

  public int solution(List<Integer> arr) {
    int minIdx = getMinIdx(arr);
    return minIdx - 1;
  }

  private int getMinIdx(List<Integer> arr) {
    int min = Integer.MAX_VALUE;
    int minIdx = -1;
    int low = 0;
    int high = arr.size() - 1;

    while (low <= high) {
      int mid = low + ((high - low) >> 1);

      if (arr.get(low) <= arr.get(mid)) {
        if (arr.get(low) < min) {
          min = arr.get(low);
          minIdx = low;
        }
        low = mid + 1;
      } else {
        // the right part is sorted
        if (arr.get(mid) < min) {
          min = arr.get(mid);
          minIdx = mid;
        }
        high = mid - 1;
      }
    }
    return minIdx;
  }
}
