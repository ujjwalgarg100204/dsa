package codes.striveratozdsasheet._04binarysearch._01_1darray;

public class SearchInRotatedArrayII {

  public boolean solution(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;
    while (low <= high) {
      int mid = low + ((high - low) >> 1);

      if (arr[mid] == target) {
        return true;
      }
      if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
        low++;
        high--;
        continue;
      }
      // find which part is sorted
      if (arr[low] <= arr[mid]) {
        // the left part is sorted
        if (target >= arr[low] && target <= arr[mid]) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      } else {
        // the right part is sorted
        if (target >= arr[mid] && target <= arr[high]) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }
    }
    return false;
  }
}
