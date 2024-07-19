package codes.striveratozdsasheet._03arrays.easy;

import java.util.Set;
import java.util.TreeSet;

/**
 * RemoveDuplicatesFromSortedArray
 */
public class RemoveDuplicatesFromSortedArray {

    public int brute(int[] arr) {
        Set<Integer> set = new TreeSet<>();
        for (int i : arr) {
            set.add(i);
        }

        int j = 0;
        for (int i : set) {
            arr[j] = i;
            j++;
        }

        return set.size();
    }

    public int optimal(int[] arr) {
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[j] > arr[i]) {
                arr[i + 1] = arr[j];
                i++;
            }
        }

        return i + 1;
    }

}
