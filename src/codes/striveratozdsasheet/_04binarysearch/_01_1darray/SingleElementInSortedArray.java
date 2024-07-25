package codes.striveratozdsasheet._04binarysearch._01_1darray;

public class SingleElementInSortedArray {

  public int brute(int[] arr) {
    int singleElem = 0;
    for (int i : arr) {
      singleElem ^= i;
    }
    return singleElem;
  }

  public int optimal(int[] arr) {
    if (arr.length == 1) {
      return arr[0];
    }
    if (arr[0] != arr[1]) {
      return arr[0];
    } else if (arr[arr.length - 1] != arr[arr.length - 2]) {
      return arr[1];
    }
    int low = 1;
    int high = arr.length - 2;

    while (low <= high) {
      int mid = low + ((high - low) >> 1);

      if (arr[mid - 1] != arr[mid] && arr[mid + 1] != arr[mid]) {
        return arr[mid];
      }

      // check of even / odd index, and check the left and right element accordingly
      if (((mid & 1) == 0 && arr[mid] == arr[mid + 1]) ||
          ((mid & 1) != 0 && arr[mid] == arr[mid - 1])) {
        // if mid is even, and it is equal to its right element or mid is odd, and it is
        // equal to its left element, then the single element exists in right part
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    // code will never reach here
    return -1;
  }
}
