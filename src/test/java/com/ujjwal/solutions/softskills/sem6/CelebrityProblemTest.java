package com.ujjwal.solutions.softskills.sem6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.TestFactory;

import com.ujjwal.models.TestCase;
import com.ujjwal.solutions.DSATest;

/*
 * CelebrityProblemTest
 */
public class CelebrityProblemTest {

    private final CelebrityProblem problem = new CelebrityProblem();

    @TestFactory
    @DisplayName("Celebrity Problem")
    List<DynamicContainer> testingProblem() {
        return DSATest.generateTestContainers(
                problem,
                testCase -> Arrays.deepToString(testCase.input()),
                pair -> {
                    Method solution = pair.getFirst();
                    TestCase<int[][], Integer> testCase = pair.getSec();
                    return () -> assertEquals(
                            testCase.expectedOutput(),
                            (int) solution.invoke(problem, (Object) testCase.input()));
                }

        );
    }
}
