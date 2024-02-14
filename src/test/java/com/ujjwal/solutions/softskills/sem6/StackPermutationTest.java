package com.ujjwal.solutions.softskills.sem6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import com.ujjwal.models.TestCase;
import com.ujjwal.solutions.softskills.sem6.StackPermutation.StackPermutation;
import com.ujjwal.solutions.softskills.sem6.StackPermutation.StackPermutationInput;

/**
 * StackPermutationTest
 */
public class StackPermutationTest {
    private StackPermutation problem = new StackPermutation();

    @TestFactory
    @DisplayName("Testing All Approaches")
    Collection<DynamicContainer> testing() {
        Collection<DynamicContainer> testContainers = new ArrayList<>();

        for (Method solution : problem.getSolutions()) {
            // create tests for solution against all testCases
            List<DynamicTest> tests = new ArrayList<>();
            for (TestCase<StackPermutationInput, Boolean> testCase : problem.getTestCases()) {
                tests.add(DynamicTest.dynamicTest(
                        testCase.toString(),
                        () -> {
                            // call solution
                            assertEquals(
                                    testCase.expectedOutput(),
                                    (boolean) solution.invoke(problem, testCase.input().input(),
                                            testCase.input().output()));
                        }));
            }

            testContainers.add(DynamicContainer.dynamicContainer(solution.getName(), tests));
        }

        return testContainers;
    }

}
