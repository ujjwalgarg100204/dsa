import java.util.List;

/**
 * MergeTwoSortedArrayWithoutExtraSpace
 */
public class MergeTwoSortedArrayWithoutExtraSpace {

    public String getProblemLink() {
        return "https://leetcode.com/problems/merge-sorted-array";
    }

    public void brute(int[] arr1, int m, int[] arr2, int n) {
        // start filling the array from end
        int k = arr1.length;

        // go through at least one array
        while (m >= 0 & n >= 0) {
            if (arr1[m] > arr2[n]) {
                arr1[k] = arr1[m];
            } else {
                arr1[k] = arr2[n];
            }
            k--;
        }

        // go through the left array
        while (m >= 0) {
            arr1[k] = arr1[m];
            k--;
        }
        while (n >= 0) {
            arr1[k] = arr2[n];
            k--;
        }
    }

}
