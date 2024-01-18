package com.ujjwal.solutions.striver_a_to_z_dsa_sheet.step_3_arrays.hard;

import com.ujjwal.models.TestCase;
import org.junit.jupiter.api.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class ThreeSumTest {
    private ThreeSum threeSum;

    @BeforeEach
    void createProblemObject() {
        threeSum = new ThreeSum();
    }

    @TestFactory
    @DisplayName("Testing All Approaches")
    Collection<DynamicContainer> testing() {
        Collection<DynamicContainer> testContainers = new ArrayList<>();

        for (Method solution : threeSum.getSolutions()) {
            // create tests for solution against all testCases
            List<DynamicTest> tests = new ArrayList<>();
            for (TestCase<int[], List<List<Integer>>> testCase : threeSum.getTestCases()) {
                tests.add(DynamicTest.dynamicTest(
                        Arrays.toString(testCase.input()),
                        () -> assertIterableEquals(
                                testCase.expectedOutput(),
                                (Iterable<?>) solution.invoke(threeSum, testCase.input())
                        )
                ));
            }

            testContainers.add(DynamicContainer.dynamicContainer(solution.getName(), tests));
        }

        return testContainers;
    }
}
