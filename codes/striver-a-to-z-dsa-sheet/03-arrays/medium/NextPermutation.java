import java.util.Arrays;

public class NextPermutation {

  public void solution(int[] arr) {
    // find the pivot point from right
    int pvtIdx = -1;
    for (int i = arr.length - 1; i > 0; i--) {
      if (arr[i] > arr[i - 1]) {
        pvtIdx = i;
        break;
      }
    }

    if (pvtIdx == -1) {
      // reverse the array
      for (int i = 0; i < arr.length / 2; i++) {
        swap(arr, i, arr.length - 1 - i);
      }
      return;
    }

    // find the element to swap with pivot - 1
    // it has to be swapped with number which is just bigger than it
    int justBiggerIdx = pvtIdx;
    int justBiggerNum = arr[pvtIdx];
    for (int i = pvtIdx; i < arr.length; i++) {
      if (arr[i] > arr[pvtIdx - 1] && arr[i] < justBiggerNum) {
        justBiggerIdx = i;
        justBiggerNum = arr[i];
      }
    }
    swap(arr, pvtIdx - 1, justBiggerIdx);

    // sort the rest of the array
    Arrays.sort(arr, pvtIdx, arr.length);
  }

  private static void swap(int[] arr, int firstIdx, int secIdx) {
    int temp = arr[firstIdx];
    arr[firstIdx] = arr[secIdx];
    arr[secIdx] = temp;
  }
}
