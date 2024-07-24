package codes.striveratozdsasheet._04binarysearch._01_1darray;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {

  public int[] brute(int[] arr, int target) {
    int[] result = new int[2];
    Arrays.fill(result, -1);

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == target) {
        if (result[0] == -1) {
          result[0] = i;
        }
        result[1] = i;
      }
    }
    return result;
  }

  public int[] betterBrute(int[] arr, int target) {
    int[] result = new int[2];

    int firstOccur = Arrays.binarySearch(arr, target);
    result[0] = firstOccur;
    result[1] = firstOccur;
    if (firstOccur == -1) {
      return result;
    }

    // keep updating both first and last occurrences
    for (int i = firstOccur; i >= 0 && arr[i] == target; i--) {
      result[0] = i;
    }
    for (int i = firstOccur; i < arr.length && arr[i] == target; i++) {
      result[1] = i;
    }

    return result;
  }

  public int[] optimal(int[] arr, int target) {
    var result = new int[2];
    result[0] = getFirstOccur(arr, target);
    if (result[0] == -1) {
      result[1] = -1;
      return result;
    }
    result[1] = getLastOccur(arr, target);

    return result;
  }

  private int getFirstOccur(int[] arr, int target) {
    int occur = -1;
    int low = 0;
    int high = arr.length - 1;
    while (low <= high) {
      int mid = low + ((high - low) >> 1);

      if (arr[mid] == target) {
        occur = mid;
        high = mid - 1;
      } else if (arr[mid] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return occur;
  }

  private int getLastOccur(int[] arr, int target) {
    int occur = -1;
    int low = 0;
    int high = arr.length - 1;
    while (low <= high) {
      int mid = low + ((high - low) >> 1);

      if (arr[mid] == target) {
        occur = mid;
        low = mid + 1;
      } else if (arr[mid] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return occur;
  }
}
