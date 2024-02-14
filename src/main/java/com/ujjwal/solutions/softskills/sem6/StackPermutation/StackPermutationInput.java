package com.ujjwal.solutions.softskills.sem6.StackPermutation;

import java.util.Arrays;

/**
 * StackPermutationInput
 */
public record StackPermutationInput(int[] input, int[] output) {

  @Override
  public String toString() {
    return "{input = " + Arrays.toString(input) + ", output = " + Arrays.toString(output) + "}";
  }
}
