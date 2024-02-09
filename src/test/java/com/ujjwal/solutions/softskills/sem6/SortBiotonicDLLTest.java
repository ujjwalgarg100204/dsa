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

import com.ujjwal.datastructures.linkedlist.DLNode;
import com.ujjwal.datastructures.linkedlist.DoublyLinkedList;
import com.ujjwal.models.TestCase;

/**
 * SortBiotonicDLLTest
 */
public class SortBiotonicDLLTest {
    private SortBiotonicDLL problem = new SortBiotonicDLL();

    @TestFactory
    @DisplayName("Testing All Approaches")
    Collection<DynamicContainer> testing() {
        Collection<DynamicContainer> testContainers = new ArrayList<>();

        for (Method solution : problem.getSolutions()) {
            // create tests for solution against all testCases
            List<DynamicTest> tests = new ArrayList<>();
            for (TestCase<DLNode<Integer>, DLNode<Integer>> testCase : problem.getTestCases()) {
                tests.add(DynamicTest.dynamicTest(
                        testCase.toString(),
                        () -> assertEquals(0, DoublyLinkedList.compare(
                                testCase.expectedOutput(),
                                (DLNode<Integer>) solution.invoke(problem, testCase.input())))));
            }

            testContainers.add(DynamicContainer.dynamicContainer(solution.getName(), tests));
        }

        return testContainers;
    }
}
