package com.ujjwal.solutions.softskills.sem6.SlidingWindowMaximum;

import java.util.Arrays;

/**
 * SlidingWindowMaximumInput
 */
public record SlidingWindowMaximumInput(int[] arr, int k) {

    @Override
    public String toString() {
        return "{arr = " + Arrays.toString(arr) + ", k = " + k + "}";
    }
}
