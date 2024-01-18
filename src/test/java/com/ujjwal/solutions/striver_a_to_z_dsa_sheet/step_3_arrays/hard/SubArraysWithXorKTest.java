package com.ujjwal.solutions.striver_a_to_z_dsa_sheet.step_3_arrays.hard;

import com.ujjwal.models.TestCase;
import com.ujjwal.solutions.striver_a_to_z_dsa_sheet.step_3_arrays.hard.SubArraysWithXorK.SubArraysWithXorK;
import com.ujjwal.solutions.striver_a_to_z_dsa_sheet.step_3_arrays.hard.SubArraysWithXorK.SubArraysWithXorKInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubArraysWithXorKTest {
    private SubArraysWithXorK problem;

    @BeforeEach
    void setUp() {
        problem = new SubArraysWithXorK();
    }

    @TestFactory
    Collection<DynamicContainer> testing() {
        Collection<DynamicContainer> testContainers = new ArrayList<>();

        for (Method solution : problem.getSolutions()) {
            // create tests for solution against all testCases
            List<DynamicTest> tests = new ArrayList<>();
            for (TestCase<SubArraysWithXorKInput, Integer> testCase : problem.getTestCases()) {
                tests.add(DynamicTest.dynamicTest(
                        testCase.input().toString(),
                        () -> assertEquals(
                                testCase.expectedOutput(),
                                solution.invoke(problem, testCase.input().arr(), testCase.input().k())
                        )
                ));
            }

            testContainers.add(DynamicContainer.dynamicContainer(solution.getName(), tests));
        }

        return testContainers;
    }
}