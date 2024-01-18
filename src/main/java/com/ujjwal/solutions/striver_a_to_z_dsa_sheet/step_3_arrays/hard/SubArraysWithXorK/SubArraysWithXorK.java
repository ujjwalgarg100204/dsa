package com.ujjwal.solutions.striver_a_to_z_dsa_sheet.step_3_arrays.hard.SubArraysWithXorK;

import com.ujjwal.annotations.Solution;
import com.ujjwal.models.DSAProblem;
import com.ujjwal.models.TestCase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubArraysWithXorK extends DSAProblem<SubArraysWithXorKInput, Integer> {

    @Override
    public String getProblemLink() {
        return "https://www.codingninjas.com/studio/problems/subarrays-with-xor-k_6826258";
    }

    @Override
    public List<TestCase<SubArraysWithXorKInput, Integer>> getTestCases() {
        return List.of(
                new TestCase<>(new SubArraysWithXorKInput(new int[]{1, 2, 3, 2}, 2), 3),
                new TestCase<>(new SubArraysWithXorKInput(new int[]{1, 2, 3, 3}, 3), 4),
                new TestCase<>(new SubArraysWithXorKInput(new int[]{1, 3, 3, 3, 5}, 6), 2)
        );
    }

    @Solution
    public int brute(int[] arr, int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int xor = 0;
                for (int l = i; l <= j; l++) {
                    xor ^= arr[l];
                }
                if (xor == k) count++;
            }
        }


        return count;
    }

    @Solution
    public int better(int[] arr, int k) {
        int count = 0;

        // generate all sub-arrays, and check xor of each array
        for (int i = 0; i < arr.length; i++) {
            int xor = 0;
            for (int j = i; j < arr.length; j++) {
                xor ^= arr[j];
                if (xor == k) count++;
            }
        }

        return count;
    }

    @Solution
    public int optimal(int[] nums, int k) {
        // storing xor as key, count of that xor as value
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int count = 0;
        int currXor = 0;
        for (int i : nums) {
            currXor ^= i;

            int x = currXor ^ k;
            if (map.containsKey(x)) {
                count += map.get(x);
            }
            map.merge(currXor, 1, Integer::sum);
        }

        return count;
    }
}
