package com.ujjwal.solutions.softskills.sem6.SlidingWindowMaximum;

import java.util.ArrayList;
import java.util.List;

import com.ujjwal.annotations.Solution;
import com.ujjwal.models.DSAProblem;
import com.ujjwal.models.TestCase;

/**
 * SlidingWindowMaximum
 */
public class SlidingWindowMaximum extends DSAProblem<SlidingWindowMaximumInput, List<Integer>> {

    @Override
    public String getProblemLink() {
        return "https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/";
    }

    @Override
    public List<TestCase<SlidingWindowMaximumInput, List<Integer>>> getTestCases() {
        return List.of(
                new TestCase<>(
                        new SlidingWindowMaximumInput(new int[] { 1, 2, 3, 1, 4, 5, 2, 3, 6 }, 3),
                        List.of(3, 3, 4, 5, 5, 5, 6)),
                new TestCase<>(
                        new SlidingWindowMaximumInput(new int[] { 8, 5, 10, 7, 9, 4, 15, 12, 90, 13 }, 4),
                        List.of(10, 10, 10, 15, 15, 90, 90)));
    }

    @Solution
    public List<Integer> brute(int[] arr, int k) {
        List<Integer> maxes = new ArrayList<>();

        for (int i = 0; i <= arr.length - k; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, arr[j]);
            }
            maxes.add(max);
        }

        return maxes;
    }

    // TODO: Complete optimal approach for this problem
}
