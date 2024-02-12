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

import com.ujjwal.datastructures.linkedlist.SLNode;
import com.ujjwal.datastructures.linkedlist.SinglyLinkedList;
import com.ujjwal.models.TestCase;

/**
 * MergeSortInDLLTest
 */
public class MergeSortInSLLTest {
    private MergeSortInSLL problem = new MergeSortInSLL();

    @TestFactory
    @DisplayName("Testing All Approaches")
    Collection<DynamicContainer> testing() {
        Collection<DynamicContainer> testContainers = new ArrayList<>();

        for (Method solution : problem.getSolutions()) {
            // create tests for solution against all testCases
            List<DynamicTest> tests = new ArrayList<>();
            for (TestCase<SLNode<Integer>, SLNode<Integer>> testCase : problem.getTestCases()) {
                tests.add(DynamicTest.dynamicTest(
                        testCase.toString(),
                        () -> {
                            // call solution
                            assertEquals(0, SinglyLinkedList.compare(
                                    testCase.expectedOutput(),
                                    (SLNode<Integer>) solution.invoke(problem, testCase.input())));
                        }));
            }

            testContainers.add(DynamicContainer.dynamicContainer(solution.getName(), tests));
        }

        return testContainers;
    }
}
