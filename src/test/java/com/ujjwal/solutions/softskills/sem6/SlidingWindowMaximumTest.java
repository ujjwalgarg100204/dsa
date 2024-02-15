package com.ujjwal.solutions.softskills.sem6;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import com.ujjwal.models.TestCase;
import com.ujjwal.solutions.softskills.sem6.SlidingWindowMaximum.SlidingWindowMaximum;
import com.ujjwal.solutions.softskills.sem6.SlidingWindowMaximum.SlidingWindowMaximumInput;

/**
 * SlidingWindowMaximumTest
 */
public class SlidingWindowMaximumTest {
    private SlidingWindowMaximum problem = new SlidingWindowMaximum();

    @TestFactory
    @DisplayName("Testing All Approaches")
    Collection<DynamicContainer> testing() {
        Collection<DynamicContainer> testContainers = new ArrayList<>();

        for (Method solution : problem.getSolutions()) {
            // create tests for solution against all testCases
            List<DynamicTest> tests = new ArrayList<>();
            for (TestCase<SlidingWindowMaximumInput, List<Integer>> testCase : problem.getTestCases()) {
                tests.add(DynamicTest.dynamicTest(
                        testCase.toString(),
                        () -> {
                            assertIterableEquals(
                                    testCase.expectedOutput(),
                                    (List<Integer>) solution.invoke(problem, testCase.input().arr(),
                                            testCase.input().k()));
                        }));
            }

            testContainers.add(DynamicContainer.dynamicContainer(solution.getName(), tests));
        }

        return testContainers;
    }
}
