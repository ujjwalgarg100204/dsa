package com.ujjwal.solutions.striver_a_to_z_dsa_sheet.step_3_arrays.hard;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Method;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.TestFactory;

import com.ujjwal.models.TestCase;
import com.ujjwal.solutions.DSATest;
import com.ujjwal.solutions.striver_a_to_z_dsa_sheet.step_3_arrays.hard.SubArraysWithXorK.SubArraysWithXorK;
import com.ujjwal.solutions.striver_a_to_z_dsa_sheet.step_3_arrays.hard.SubArraysWithXorK.SubArraysWithXorKInput;

class SubArraysWithXorKTest {
    private SubArraysWithXorK problem;

    @BeforeEach
    void setUp() {
        problem = new SubArraysWithXorK();
    }

    @TestFactory
    @DisplayName("Sub-array With Xor K")
    List<DynamicContainer> testingProblem() {
        return DSATest.generateTestContainers(
                problem,
                TestCase::toString,
                pair -> {
                    Method solution = pair.getFirst();
                    TestCase<SubArraysWithXorKInput, Integer> testCase = pair.getSec();
                    return () -> assertEquals(
                            testCase.expectedOutput(),
                            solution.invoke(problem, testCase.input().arr(), testCase.input().k()));
                }

        );
    }
}
