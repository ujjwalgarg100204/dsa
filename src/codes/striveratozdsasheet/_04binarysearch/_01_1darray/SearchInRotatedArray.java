package codes.striveratozdsasheet._04binarysearch._01_1darray;

import java.util.Arrays;

public class SearchInRotatedArray {

  public int brute(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == target) {
        return i;
      }
    }
    return -1;
  }

  public int better(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;
    while (low <= high) {
      int mid = low + ((high - low) >> 1);

      if (arr[mid] == target) {
        return mid;
      }
      // find which part is sorted
      if (arr[low] < arr[mid]) {
        // the left part is sorted
        int idx = Arrays.binarySearch(arr, low, mid, target);
        if (isValidIdx(arr, idx) && arr[idx] == target) {
          return idx;
        }
        low = mid + 1;
      } else {
        // the right part is sorted
        int idx = Arrays.binarySearch(arr, mid + 1, high + 1, target);
        if (isValidIdx(arr, idx) && arr[idx] == target) {
          return idx;
        }
        high = mid - 1;

      }
    }

    return -1;
  }

  private boolean isValidIdx(int[] arr, int idx) {
    return idx > -1 && idx < arr.length;
  }

  public int optimal(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;
    while (low <= high) {
      int mid = low + ((high - low) >> 1);

      if (arr[mid] == target) {
        return mid;
      }
      // find which part is sorted
      if (arr[low] <= arr[mid]) {
        // the left part is sorted
        if (target >= arr[low] && target < arr[mid]) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }

      } else {
        // the right part is sorted
        if (target > arr[mid] && target <= arr[high]) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }
    }

    return -1;
  }
}
