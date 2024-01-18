package com.ujjwal.solutions.striver_a_to_z_dsa_sheet.binary_search.one_d_array.BinarySearch;


import com.ujjwal.annotations.Solution;
import com.ujjwal.models.DSAProblem;
import com.ujjwal.models.TestCase;

import java.util.List;

public class BinarySearch extends DSAProblem<BinarySearchInput, Integer> {
    @Override
    public String getProblemLink() {
        return "https://leetcode.com/problems/binary-search/description";
    }

    @Override
    public List<TestCase<BinarySearchInput, Integer>> getTestCases() {
        return List.of(
                new TestCase<>(new BinarySearchInput(new int[]{-1, 0, 3, 5, 9, 12}, 9), 4),
                new TestCase<>(new BinarySearchInput(new int[]{-1, 0, 3, 5, 9, 12}, 2), -1),
                new TestCase<>(new BinarySearchInput(new int[]{5}, 5), 0)
        );
    }

    @Solution
    public int iterative(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] > target) end = mid - 1;
            else if (arr[mid] < target) start = mid + 1;
            else return mid;
        }

        return -1;
    }

    @Solution
    public int recursive(int[] arr, int target) {
        return recursiveHelper(arr, target, 0, arr.length - 1);
    }

    private int recursiveHelper(int[] arr, int target, int start, int end) {
        if (end < start) return -1;
        int mid = (start + end) / 2;
        if (arr[mid] > target) return recursiveHelper(arr, target, start, mid - 1);
        else if (arr[mid] < target) return recursiveHelper(arr, target, mid + 1, end);
        return mid;
    }
}
