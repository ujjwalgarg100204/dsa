package com.ujjwal.solutions.softskills.sem6;

import java.util.List;

import com.ujjwal.annotations.Solution;
import com.ujjwal.models.DSAProblem;
import com.ujjwal.models.TestCase;

/**
 * StockSpan
 */
public class StockSpan extends DSAProblem<int[], int[]> {

    @Override
    public String getProblemLink() {
        return "https://www.geeksforgeeks.org/problems/stock-span-problem-1587115621/1";
    }

    @Override
    public List<TestCase<int[], int[]>> getTestCases() {
        return List.of(
                new TestCase<>(
                        new int[] { 100, 80, 60, 70, 60, 75, 85 },
                        new int[] { 1, 1, 1, 2, 1, 4, 6 }),
                new TestCase<>(
                        new int[] { 10, 4, 5, 90, 120, 80 },
                        new int[] { 1, 1, 2, 4, 5, 1 }));
    }

    @Solution
    public int[] brute(int[] stocks) {
        int[] spans = new int[stocks.length];
        spans[0] = 1;

        for (int i = 1; i < stocks.length; i++) {
            int span = 1;
            // calculate span
            for (int j = i - 1; j >= 0; j--) {
                if (stocks[j] <= stocks[i]) {
                    span++;
                } else {
                    break;
                }
            }

            spans[i] = span;
        }

        return spans;
    }

    // TODO: Complete optimal approach for this problem
}
