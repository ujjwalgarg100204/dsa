package com.ujjwal.solutions.striver_a_to_z_dsa_sheet.step_3_arrays.hard;

import com.ujjwal.models.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MergeIntervalsTest {
    private MergeIntervals problem;

    @BeforeEach
    void setUp() {
        problem = new MergeIntervals();
    }

    @TestFactory
    Collection<DynamicContainer> testing() {
        Collection<DynamicContainer> testContainers = new ArrayList<>();

        for (Method solution : problem.getSolutions()) {
            // create tests for solution against all testCases
            List<DynamicTest> tests = new ArrayList<>();
            for (TestCase<int[][], int[][]> testCase : problem.getTestCases()) {
                tests.add(DynamicTest.dynamicTest(
                        Arrays.deepToString(testCase.input()),
                        () -> assertTrue(Arrays.deepEquals(
                                testCase.expectedOutput(),
                                (int[][]) solution.invoke(problem, (Object) testCase.input())
                        ))
                ));
            }

            testContainers.add(DynamicContainer.dynamicContainer(solution.getName(), tests));
        }

        return testContainers;
    }

}