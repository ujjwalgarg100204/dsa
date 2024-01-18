package com.ujjwal.solutions.striver_a_to_z_dsa_sheet.binary_search.one_d_array;

import com.ujjwal.models.TestCase;
import com.ujjwal.solutions.striver_a_to_z_dsa_sheet.binary_search.one_d_array.BinarySearch.BinarySearch;
import com.ujjwal.solutions.striver_a_to_z_dsa_sheet.binary_search.one_d_array.BinarySearch.BinarySearchInput;
import org.junit.jupiter.api.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTest {
    private BinarySearch binarySearch;

    @BeforeEach
    void setUp() {
        binarySearch = new BinarySearch();
    }

    @TestFactory
    @DisplayName("Testing All Approaches")
    Collection<DynamicContainer> testing() {
        Collection<DynamicContainer> testContainers = new ArrayList<>();

        for (Method solution : binarySearch.getSolutions()) {
            // create tests for solution against all testCases
            List<DynamicTest> tests = new ArrayList<>();
            for (TestCase<BinarySearchInput, Integer> testCase : binarySearch.getTestCases()) {
                tests.add(DynamicTest.dynamicTest(
                        testCase.input().toString(),
                        () -> assertEquals(
                                testCase.expectedOutput(),
                                solution.invoke(binarySearch, testCase.input().arr(), testCase.input().target())
                        )
                ));
            }

            testContainers.add(DynamicContainer.dynamicContainer(solution.getName(), tests));
        }

        return testContainers;
    }
}