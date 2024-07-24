package codes.striveratozdsasheet._04binarysearch._01_1darray;

public class CountOccurrenceOfNumberInSortedArray {

  public int brute(int[] arr, int target) {
    int count = 0;
    for (int i : arr) {
      if (i == target) {
        count++;
      }
    }
    return count;
  }

  public int betterBrute(int[] arr, int target) {
    int firstOccur = getFirstOccur(arr, target);
    int count = 0;
    if (firstOccur == -1) {
      return count;
    }

    while (firstOccur < arr.length && arr[firstOccur] == target) {
      count++;
      firstOccur++;
    }
    return count;
  }


  public int optimal(int[] arr, int target) {
    int firstOccur = getFirstOccur(arr, target);
    int secOccur = getLastOccur(arr, target);

    return secOccur - firstOccur + 1;
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
