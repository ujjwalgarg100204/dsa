package com.ujjwal.solutions.softskills.sem6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Method;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.TestFactory;

import com.ujjwal.datastructures.linkedlist.DLNode;
import com.ujjwal.datastructures.linkedlist.DoublyLinkedList;
import com.ujjwal.models.TestCase;
import com.ujjwal.solutions.DSATest;

/**
 * SortBiotonicDLLTest
 */
public class SortBiotonicDLLTest {
    private SortBiotonicDLL problem = new SortBiotonicDLL();

    @TestFactory
    @DisplayName("Sort Biotonic DLL")
    List<DynamicContainer> testingProblem() {
        return DSATest.generateTestContainers(
                problem,
                testCase -> DoublyLinkedList.toString(testCase.input()),
                pair -> {
                    Method solution = pair.getFirst();
                    TestCase<DLNode<Integer>, DLNode<Integer>> testCase = pair.getSec();
                    return () -> assertEquals(0, DoublyLinkedList.compare(
                            testCase.expectedOutput(),
                            (DLNode<Integer>) solution.invoke(problem, testCase.input())));
                }

        );
    }
}
