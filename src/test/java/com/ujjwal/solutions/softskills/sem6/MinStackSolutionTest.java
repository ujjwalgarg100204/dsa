package com.ujjwal.solutions.softskills.sem6;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import com.ujjwal.models.TestCase;
import com.ujjwal.solutions.softskills.sem6.MinStack.MinStackInput;
import com.ujjwal.solutions.softskills.sem6.MinStack.MinStackSolution;

/**
 * MinStackSolutionTest
 */
public class MinStackSolutionTest {

    private MinStackSolution implementation;

    @BeforeEach
    void setupStack() {
        implementation = new MinStackSolution();
    }

    List<Integer> testMinStack(MinStackInput input) {
        List<Integer> result = new ArrayList<>();

        List<String> operations = input.operations();
        List<List<Integer>> values = input.values();

        for (int i = 0; i < operations.size(); i++) {
            switch (operations.get(i)) {
                case "push":
                    values.get(i).forEach(implementation::push);
                    result.add(null);
                    break;
                case "pop":
                    implementation.pop();
                    result.add(null);
                    break;
                case "top":
                    result.add(implementation.top());
                    break;
                case "getMin":
                    result.add(implementation.getMin());
                    break;
                default:
                    break;
            }
        }

        return result;
    }

    @TestFactory
    @DisplayName("Testing MinStackSolution")
    List<DynamicTest> testingMinstackSolution() {
        List<DynamicTest> tests = new ArrayList<>();

        for (TestCase<MinStackInput, List<Integer>> testCase : implementation.getTestCases()) {
            tests.add(DynamicTest.dynamicTest(
                    testCase.toString(),
                    () -> {
                        List<Integer> results = testMinStack(testCase.input());
                        System.out.println(results);
                        Assertions.assertIterableEquals(results, testCase.expectedOutput());
                    }));
        }

        return tests;
    }
}
