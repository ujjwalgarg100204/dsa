package com.ujjwal.solutions.softskills.sem6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Method;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.TestFactory;

import com.ujjwal.datastructures.linkedlist.SLNode;
import com.ujjwal.datastructures.linkedlist.SinglyLinkedList;
import com.ujjwal.models.TestCase;
import com.ujjwal.solutions.DSATest;

/**
 * SegregateEvenAndOddNodesInLLTest
 */
public class SegregateEvenAndOddNodesInLLTest {
    private SegregateEvenAndOddNodesInLL problem;

    @BeforeEach
    void setupTest() {
        problem = new SegregateEvenAndOddNodesInLL();
    }

    @TestFactory
    @DisplayName("Segregate Even & Odd Nodes in LL")
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
