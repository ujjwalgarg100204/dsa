package codes.striveratozdsasheet._03arrays.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * UnionOfTwoSortedArrays
 */
public class UnionOfTwoSortedArrays {

    public List<Integer> brute(int[] arr1, int[] arr2) {
        Set<Integer> set = new TreeSet<>();
        for (int i : arr1) {
            set.add(i);
        }
        for (int i : arr2) {
            set.add(i);
        }

        return new ArrayList<>(set);
    }

    public List<Integer> optimal(int[] arr1, int[] arr2) {
        List<Integer> ans = new ArrayList<>();

        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            int newElem = -1;
            if (arr1[i] < arr2[j]) {
                newElem = arr1[i];
                i++;
            } else {
                newElem = arr2[j];
                j++;
            }

            if (ans.isEmpty() || ans.getLast() < newElem) {
                ans.add(newElem);
            }

        }

        while (i < arr1.length) {
            if (ans.getLast() < arr1[i]) {
                ans.add(arr1[i]);
            }
            i++;
        }

        while (j < arr2.length) {
            if (ans.getLast() < arr2[j]) {
                ans.add(arr2[j]);
            }
            j++;
        }

        return ans;
    }
}
