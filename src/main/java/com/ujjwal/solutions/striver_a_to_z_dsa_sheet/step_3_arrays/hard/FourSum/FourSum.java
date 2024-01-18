package com.ujjwal.solutions.striver_a_to_z_dsa_sheet.step_3_arrays.hard.FourSum;

import com.ujjwal.annotations.Solution;
import com.ujjwal.models.DSAProblem;
import com.ujjwal.models.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum extends DSAProblem<FourSumInput, List<List<Integer>>> {

    @Override
    public String getProblemLink() {
        return "https://leetcode.com/problems/4sum/description/";
    }

    @Override
    public List<TestCase<FourSumInput, List<List<Integer>>>> getTestCases() {
        return List.of(
                new TestCase<>(new FourSumInput(new int[]{1, 0, -1, 0, -2, 2}, 0), List.of(List.of(-2, -1, 1, 2), List.of(-2, 0, 0, 2), List.of(-1, 0, 0, 1))),
                new TestCase<>(new FourSumInput(new int[]{2, 2, 2, 2, 2}, 8), List.of(List.of(2, 2, 2, 2)))
        );
    }

    @Solution
    public static List<List<Integer>> optimal(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> choplets = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            for (int j = i + 1; j < arr.length; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1]) continue;

                int k = j + 1;
                int l = arr.length - 1;
                while (k < l) {
                    long sum = (long) arr[i] + arr[j] + arr[k] + arr[l];
                    if (sum > target) {
                        l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        choplets.add(List.of(arr[i], arr[j], arr[k], arr[l]));
                        k++;
                        l--;
                        while (k < l && arr[k] == arr[k - 1]) {
                            k++;
                        }
                        while (k < l && arr[l] == arr[l + 1]) {
                            l--;
                        }
                    }
                }
            }
        }

        return choplets;
    }
}
