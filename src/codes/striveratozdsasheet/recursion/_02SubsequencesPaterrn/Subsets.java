package codes.striveratozdsasheet.recursion._02SubsequencesPaterrn;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

  public List<List<Integer>> iterativeSolution(int[] arr) {
    int lenOfPowSet = 1 << arr.length;
    List<List<Integer>> powerSet = new ArrayList<>(lenOfPowSet);

    for (int i = 0; i < lenOfPowSet; i++) {
      int iCpy = i;
      List<Integer> set = new ArrayList<>();
      // if the bit is set then we include that particular element in the subset,
      // otherwise we do not
      for (int j = 0; iCpy > 0; j++, iCpy >>= 1) {
        if ((iCpy & 1) == 1) {
          set.add(arr[j]);
        }
      }
      powerSet.add(set);
    }
    return powerSet;
  }

  private int[] arr;
  private List<List<Integer>> result;

  public List<List<Integer>> recursiveSolution(int[] arr) {
    this.arr = arr;
    this.result = new ArrayList<>(1 << arr.length);
    recursiveHelper(0, new ArrayList<>());

    return this.result;
  }

  private void recursiveHelper(int idx, List<Integer> curr) {
    if (idx == arr.length) {
      result.add(new ArrayList<>(curr));
      return;
    }

    // exclude the current element and recurse
    recursiveHelper(idx + 1, curr);

    // include the current element and recurse
    curr.add(arr[idx]);
    recursiveHelper(idx + 1, curr);

    // backtrack to remove last element
    curr.removeLast();
  }
}
