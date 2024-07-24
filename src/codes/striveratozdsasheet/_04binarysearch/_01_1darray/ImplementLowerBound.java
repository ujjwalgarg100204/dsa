package codes.striveratozdsasheet._04binarysearch._01_1darray;

// The code follows below definition of Lower Bound
//  of a given number `x` in the given array, is the number
// which is just bigger than or equal to given number `x`, or in other words
// smallest maximum of given number x in the array
public class ImplementLowerBound {

  public static int brute(long[] arr, long x) {
    int lowerBoundIdx = -1;
    long lowerBound = Long.MAX_VALUE;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > x && arr[i] < lowerBound) {
        lowerBound = arr[i];
        lowerBoundIdx = i;
      }
    }

    return lowerBoundIdx;
  }


  public static int solution(long[] arr, long x) {
    // check the existence of lower bound
    if (arr[arr.length - 1] < x) {
      // if largest element in the array is smaller than x, then there
      // is no lower bound of that number in that array
      return -1;
    }

    int lowerBoundIdx = -1;
    int low = 0;
    int high = arr.length - 1;
    while (low <= high) {
      int mid = low + ((high - low) >> 1);

      if (arr[mid] >= x) {
        lowerBoundIdx = mid;
        // look for better lowerBound towards left part
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return lowerBoundIdx;
  }
}
