package com.ujjwal.solutions.softskills.sem6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import com.ujjwal.models.TestCase;
import com.ujjwal.solutions.striver_a_to_z_dsa_sheet.datastructures.linkedlist.SLNode;

/**
 * DetectLoopInLLTest
 */
public class DetectLoopInLLTest {
    private DetectLoopInLL problem;

    @BeforeEach
    void setUp() {
        problem = new DetectLoopInLL();
    }

    @TestFactory
    @DisplayName("Testing All Approaches")
    Collection<DynamicContainer> testing() {
        Collection<DynamicContainer> testContainers = new ArrayList<>();

        for (Method solution : problem.getSolutions()) {
            // create tests for solution against all testCases
            List<DynamicTest> tests = new ArrayList<>();
            for (TestCase<SLNode<Integer>, Boolean> testCase : problem.getTestCases()) {
                tests.add(DynamicTest.dynamicTest(
                        testCase.toString(),
                        () -> assertEquals(
                                testCase.expectedOutput(),
                                solution.invoke(problem, testCase.input()))));
            }

            testContainers.add(DynamicContainer.dynamicContainer(solution.getName(), tests));
        }

        return testContainers;
    }
}
