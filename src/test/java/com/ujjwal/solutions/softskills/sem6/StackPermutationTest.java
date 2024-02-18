package com.ujjwal.solutions.softskills.sem6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Method;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.TestFactory;

import com.ujjwal.models.TestCase;
import com.ujjwal.solutions.DSATest;
import com.ujjwal.solutions.softskills.sem6.StackPermutation.StackPermutation;
import com.ujjwal.solutions.softskills.sem6.StackPermutation.StackPermutationInput;

/**
 * StackPermutationTest
 */
public class StackPermutationTest {
    private StackPermutation problem = new StackPermutation();

    @TestFactory
    @DisplayName("Stack Permutation")
    List<DynamicContainer> testingProblem() {
        return DSATest.generateTestContainers(
                problem,
                TestCase::toString,
                pair -> {
                    Method solution = pair.getFirst();
                    TestCase<StackPermutationInput, Boolean> testCase = pair.getSec();
                    return () -> assertEquals(
                            testCase.expectedOutput(),
                            (boolean) solution.invoke(problem, testCase.input().input(),
                                    testCase.input().output()));
                }

        );
    }
}
