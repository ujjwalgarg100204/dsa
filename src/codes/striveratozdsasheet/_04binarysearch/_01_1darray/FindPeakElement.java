package codes.striveratozdsasheet._04binarysearch._01_1darray;

public class FindPeakElement {

  public int brute(int[] arr) {
    if (arr.length == 1) {
      return 0;
    }
    // check for first index
    if (arr[0] > arr[1]) {
      return 0;
    } else if (arr[arr.length - 1] > arr[arr.length - 2]) {
      // check for last index
      return arr.length - 1;
    }
    for (int i = 1; i < arr.length - 1; i++) {
      if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
        return i;
      }
    }
    return -1;
  }

  private int optimal(int[] arr) {
    if (arr.length == 1) {
      return 0;
    } else if (arr[0] > arr[1]) {
      // check for first index
      return 0;
    } else if (arr[arr.length - 1] > arr[arr.length - 2]) {
      // check for last index
      return arr.length - 1;
    }

    int low = 1;
    int high = arr.length - 2;
    while (low <= high) {
      int mid = low + ((high - low) >> 1);

      if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
        return mid;
      } else if (arr[mid] > arr[mid - 1]) {
        low = mid + 1;
      } else if (arr[mid] > arr[mid + 1]) {
        high = mid - 1;
      } else {
        // test will fall here when we are at the minima position,
        // here, we can either go towards right or left, as both would have peaks,
        // I choose left half
        high = mid - 1;
      }
    }

    return -1;
  }
}
