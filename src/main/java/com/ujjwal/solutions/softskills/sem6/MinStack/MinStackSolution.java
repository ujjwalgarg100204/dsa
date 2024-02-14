package com.ujjwal.solutions.softskills.sem6.MinStack;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.ujjwal.models.DSAProblem;
import com.ujjwal.models.TestCase;

/**
 * MinStack
 */
public class MinStackSolution extends DSAProblem<MinStackInput, List<Integer>> implements MinStack {
    private int min = Integer.MAX_VALUE;
    private List<Integer> list = new LinkedList<>();

    @Override
    public String getProblemLink() {
        return "https://leetcode.com/problems/min-stack/";
    }

    @Override
    public List<TestCase<MinStackInput, List<Integer>>> getTestCases() {
        return List.of(
                new TestCase<>(new MinStackInput(
                        List.of("MinStack", "push", "push", "push", "getMin", "pop", "top", "getMin"),
                        List.of(Collections.emptyList(), List.of(-2), List.of(0), List.of(-3), Collections.emptyList(),
                                Collections.emptyList(), Collections.emptyList(), Collections.emptyList())),
                        Arrays.asList(null, null, null, null, -3, null, 0, -2)));
    }

    @Override
    public void push(int val) {
        this.min = Math.min(val, this.min);
        this.list.add(val);
    }

    @Override
    public void pop() {
        int removed = this.list.removeLast();
    }

    @Override
    public int top() {
        return this.list.getLast();
    }

    @Override
    public int getMin() {
        return this.min;
    }
}
