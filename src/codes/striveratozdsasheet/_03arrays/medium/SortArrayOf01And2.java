package codes.striveratozdsasheet._03arrays.medium;

import java.util.Arrays;

public class SortArrayOf01And2 {

    public void brute(int[] arr) {
        Arrays.sort(arr);
    }

    public void better(int[] arr) {
        int noOf0 = 0, noOf1 = 0;

        for (int i : arr) {
            if (i == 0) {
                noOf0++;
            } else if (i == 1) {
                noOf1++;
            }
        }

        int i = 0;
        while (noOf0 != 0) {
            arr[i++] = 0;
            noOf0--;
        }
        while (noOf1 != 0) {
            arr[i++] = 1;
            noOf1--;
        }
        while (i < arr.length) {
            arr[i++] = 2;
        }
    }

    public void optimal(int[] arr) {
        int left = -1, right = arr.length;
        for (int i = 0; i < right;) {
            if (arr[i] == 1 || i <= left) {
                i++;
            } else if (arr[i] == 0) {
                swap(arr, left + 1, i);
                left++;
            } else {
                swap(arr, right, i);
                right--;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
