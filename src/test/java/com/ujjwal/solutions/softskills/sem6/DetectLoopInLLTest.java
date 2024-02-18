package com.ujjwal.solutions.softskills.sem6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Method;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.TestFactory;

import com.ujjwal.datastructures.linkedlist.SLNode;
import com.ujjwal.models.TestCase;
import com.ujjwal.solutions.DSATest;

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
    List<DynamicContainer> testingProblem() {
        return DSATest.generateTestContainers(
                problem,
                TestCase::toString,
                pair -> {
                    Method solution = pair.getFirst();
                    TestCase<SLNode<Integer>, Boolean> testCase = pair.getSec();
                    return () -> assertEquals(
                            testCase.expectedOutput(),
                            solution.invoke(problem, testCase.input()));
                }

        );
    }
}
