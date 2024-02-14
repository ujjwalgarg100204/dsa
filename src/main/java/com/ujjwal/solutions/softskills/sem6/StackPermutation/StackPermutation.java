package com.ujjwal.solutions.softskills.sem6.StackPermutation;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import com.ujjwal.annotations.Solution;
import com.ujjwal.models.DSAProblem;
import com.ujjwal.models.TestCase;

/**
 * StackPermutation
 */
public class StackPermutation extends DSAProblem<StackPermutationInput, Boolean> {

    @Override
    public String getProblemLink() {
        return "https://www.geeksforgeeks.org/problems/stack-permutations/1";
    }

    @Override
    public List<TestCase<StackPermutationInput, Boolean>> getTestCases() {
        return List.of(
                new TestCase<>(new StackPermutationInput(new int[] { 1, 2, 3 }, new int[] { 2, 1, 3 }), true),
                new TestCase<>(new StackPermutationInput(new int[] { 1, 2, 3 }, new int[] { 3, 1, 2 }), false));
    }

    @Solution
    public boolean brute(int[] input, int[] output) {
        Deque<Integer> stack = new ArrayDeque<>();

        int j = 0;
        for (int i = 0; i < input.length; i++) {
            stack.push(input[i]);
            while (!stack.isEmpty() && stack.peek() == output[j]) {
                stack.pop();
                j++;
            }
        }

        return stack.isEmpty() && j == output.length;
    }

}
