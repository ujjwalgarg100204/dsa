package codes.striveratozdsasheet._04binarysearch._01_1darray;

public class SearchInsertPosition {

  // uses linear search
  public int brute(int[] arr, int target) {
    // if target is smaller than first element then 0th index is its
    // correct position
    if (target <= arr[0]) {
      return 0;
    } else if (target > arr[arr.length - 1]) {
      return arr.length;
    }
    for (int i = 1; i < arr.length; i++) {
      // if target smaller than current element and bigger than previous
      // element current index is its correct position
      if (arr[i] == target || (target < arr[i] && target > arr[i - 1])) {
        return i;
      }
    }
    return -1;
  }

  // uses binary search
  public int solution(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;
    while (low <= high) {
      int mid = low + ((high - low) >> 1);

      if (arr[mid] == target) {
        return mid;
      } else if (arr[mid] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return low;
  }
}
