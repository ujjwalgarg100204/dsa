package com.ujjwal.solutions.softskills.sem6.MinStack;

import java.util.List;

/**
 * MinStackInput
 */
public record MinStackInput(List<String> operations, List<List<Integer>> values) {
    @Override
    public String toString() {
        return "{operations = " + operations() + ", values = " + values() + "}";
    }
}
