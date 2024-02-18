package com.ujjwal.solutions.softskills.sem6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Method;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.TestFactory;

import com.ujjwal.datastructures.linkedlist.SLNode;
import com.ujjwal.datastructures.linkedlist.SinglyLinkedList;
import com.ujjwal.models.TestCase;
import com.ujjwal.solutions.DSATest;

/**
 * MergeSortInDLLTest
 */
public class MergeSortInSLLTest {
    private MergeSortInSLL problem = new MergeSortInSLL();

    @TestFactory
    @DisplayName("Merge Sort In SLL")
    List<DynamicContainer> testingProblem() {
        return DSATest.generateTestContainers(
                problem,
                TestCase::toString,
                pair -> {
                    Method solution = pair.getFirst();
                    TestCase<SLNode<Integer>, SLNode<Integer>> testCase = pair.getSec();
                    return () -> assertEquals(0, SinglyLinkedList.compare(
                            testCase.expectedOutput(),
                            (SLNode<Integer>) solution.invoke(problem, testCase.input())));
                }

        );
    }
}
