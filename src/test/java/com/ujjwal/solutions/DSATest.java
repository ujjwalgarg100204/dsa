package com.ujjwal.solutions;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.function.Executable;

import com.ujjwal.datastructures.Pair;
import com.ujjwal.models.DSAProblem;
import com.ujjwal.models.TestCase;

public class DSATest {
    /**
     * Generates a list of dynamic test containers for testing solutions to a given
     * problem.
     *
     * @param problem                The problem for which solutions are being
     *                               tested.
     * @param testNameGenerator      A function that generates test names based on
     *                               test
     *                               cases.
     * @param testingMethodGenerator A function that generates a test method based
     *                               on
     *                               solutions and test cases.
     * @param <I>                    The type of input data for the problem.
     * @param <O>                    The type of expected output data for the
     *                               problem.
     * @return A list of dynamic test containers, each containing dynamic tests for
     *         each solution.
     */
    public static <I, O> List<DynamicContainer> generateTestContainers(
            DSAProblem<I, O> problem,
            Function<TestCase<I, O>, String> testNameGenerator,
            Function<Pair<Method, TestCase<I, O>>, Executable> testingMethodGenerator) {
        List<DynamicContainer> testContainers = new ArrayList<>();

        for (Method solution : problem.getSolutions()) {
            List<DynamicTest> tests = new ArrayList<>();
            for (TestCase<I, O> testCase : problem.getTestCases()) {
                tests.add(DynamicTest.dynamicTest(
                        testNameGenerator.apply(testCase),
                        testingMethodGenerator.apply(new Pair<>(solution, testCase))));
            }
            testContainers.add(DynamicContainer.dynamicContainer(solution.getName(), tests));
        }

        return testContainers;
    }
}
