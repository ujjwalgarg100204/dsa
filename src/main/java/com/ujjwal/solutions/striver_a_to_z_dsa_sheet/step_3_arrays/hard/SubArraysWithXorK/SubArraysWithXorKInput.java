package com.ujjwal.solutions.striver_a_to_z_dsa_sheet.step_3_arrays.hard.SubArraysWithXorK;

import java.util.Arrays;

public record SubArraysWithXorKInput(int[] arr, int k) {
    @Override
    public String toString() {
        return "{arr=" + Arrays.toString(arr) +
                ", k=" + k +
                "}";
    }
}
