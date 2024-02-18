package com.ujjwal.solutions.softskills.sem6;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.lang.reflect.Method;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.TestFactory;

import com.ujjwal.models.TestCase;
import com.ujjwal.solutions.DSATest;
import com.ujjwal.solutions.softskills.sem6.SlidingWindowMaximum.SlidingWindowMaximum;
import com.ujjwal.solutions.softskills.sem6.SlidingWindowMaximum.SlidingWindowMaximumInput;

/**
 * SlidingWindowMaximumTest
 */
public class SlidingWindowMaximumTest {
    private SlidingWindowMaximum problem = new SlidingWindowMaximum();

    @TestFactory
    @DisplayName("Merge Sort In SLL")
    List<DynamicContainer> testingProblem() {
        return DSATest.generateTestContainers(
                problem,
                TestCase::toString,
                pair -> {
                    Method solution = pair.getFirst();
                    TestCase<SlidingWindowMaximumInput, List<Integer>> testCase = pair.getSec();
                    return () -> assertIterableEquals(
                            testCase.expectedOutput(),
                            (List<Integer>) solution.invoke(problem, testCase.input().arr(),
                                    testCase.input().k()));
                }

        );
    }
}
