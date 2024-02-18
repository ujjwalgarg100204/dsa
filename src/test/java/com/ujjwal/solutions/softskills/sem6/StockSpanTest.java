package com.ujjwal.solutions.softskills.sem6;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.TestFactory;

import com.ujjwal.models.TestCase;
import com.ujjwal.solutions.DSATest;

/**
 * StockSpanTest
 */
public class StockSpanTest {
    private StockSpan problem = new StockSpan();

    @TestFactory
    @DisplayName("Stock Span")
    List<DynamicContainer> testingProblem() {
        return DSATest.generateTestContainers(
                problem,
                testCase -> Arrays.toString(testCase.input()),
                pair -> {
                    Method solution = pair.getFirst();
                    TestCase<int[], int[]> testCase = pair.getSec();
                    return () -> assertArrayEquals(testCase.expectedOutput(),
                            (int[]) solution.invoke(problem, (Object) testCase.input()));
                }

        );
    }
}
