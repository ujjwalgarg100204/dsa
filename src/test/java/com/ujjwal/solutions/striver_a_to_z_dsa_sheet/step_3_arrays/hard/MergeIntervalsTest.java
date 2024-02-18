package com.ujjwal.solutions.striver_a_to_z_dsa_sheet.step_3_arrays.hard;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.TestFactory;

import com.ujjwal.models.TestCase;
import com.ujjwal.solutions.DSATest;

class MergeIntervalsTest {
    private MergeIntervals problem;

    @BeforeEach
    void setUp() {
        problem = new MergeIntervals();
    }

    @TestFactory
    @DisplayName("Merge Intervals")
    List<DynamicContainer> testingProblem() {
        return DSATest.generateTestContainers(
                problem,
                testCase -> Arrays.deepToString(testCase.input()),
                pair -> {
                    Method solution = pair.getFirst();
                    TestCase<int[][], int[][]> testCase = pair.getSec();
                    return () -> assertTrue(Arrays.deepEquals(
                            testCase.expectedOutput(),
                            (int[][]) solution.invoke(problem, (Object) testCase.input())));
                }

        );
    }
}
