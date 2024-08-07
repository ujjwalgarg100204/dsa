package codes.striveratozdsasheet._04binarysearch._01_1darray;

public class BinarySearch {

  public int iterative(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;
    while (low <= high) {
      int mid = (low + high) >> 1;
      if (arr[mid] == target) {
        return mid;
      } else if (arr[mid] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return -1;
  }

  public int recursive(final int[] arr, int target, int low, int high) {
    if (low >= high) {
      return -1;
    }
    int mid = (low >> 1) + (high >> 1);
    if (arr[mid] == target) {
      return mid;
    } else if (arr[mid] > target) {
      return recursive(arr, target, low, mid - 1);
    } else {
      return recursive(arr, target, mid + 1, high);
    }
  }
}
