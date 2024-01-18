package com.ujjwal.solutions.striver_a_to_z_dsa_sheet.binary_search.one_d_array.BinarySearch;

import java.util.Arrays;

public record BinarySearchInput(int[] arr, int target) {
    @Override
    public String toString() {
        return "{arr=" + Arrays.toString(arr) +
                ", target=" + target +
                '}';
    }
}
