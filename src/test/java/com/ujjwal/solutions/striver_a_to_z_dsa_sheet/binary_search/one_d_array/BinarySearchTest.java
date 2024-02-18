package com.ujjwal.solutions.striver_a_to_z_dsa_sheet.binary_search.one_d_array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Method;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.TestFactory;

import com.ujjwal.models.TestCase;
import com.ujjwal.solutions.DSATest;
import com.ujjwal.solutions.striver_a_to_z_dsa_sheet.binary_search.one_d_array.BinarySearch.BinarySearch;
import com.ujjwal.solutions.striver_a_to_z_dsa_sheet.binary_search.one_d_array.BinarySearch.BinarySearchInput;

class BinarySearchTest {
    private BinarySearch problem;

    @BeforeEach
    void setUp() {
        problem = new BinarySearch();
    }

    @TestFactory
    @DisplayName("Binary Search")
    List<DynamicContainer> testingProblem() {
        return DSATest.generateTestContainers(
                problem,
                TestCase::toString,
                pair -> {
                    Method solution = pair.getFirst();
                    TestCase<BinarySearchInput, Integer> testCase = pair.getSec();
                    return () -> assertEquals(
                            testCase.expectedOutput(),
                            solution.invoke(problem, testCase.input().arr(), testCase.input().target()));
                }

        );
    }
}
