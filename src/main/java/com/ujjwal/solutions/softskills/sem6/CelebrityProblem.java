package com.ujjwal.solutions.softskills.sem6;

import java.util.List;

import com.ujjwal.annotations.Solution;
import com.ujjwal.models.DSAProblem;
import com.ujjwal.models.TestCase;

/**
 * CelebrityProblem
 */
public class CelebrityProblem extends DSAProblem<int[][], Integer> {

    @Override
    public String getProblemLink() {
        return "https://www.geeksforgeeks.org/problems/the-celebrity-problem/1";
    }

    @Override
    public List<TestCase<int[][], Integer>> getTestCases() {
        return List.of(
                new TestCase<>(new int[][] {
                        { 0, 1, 0 },
                        { 0, 0, 0 },
                        { 0, 1, 0 }
                }, 1),
                new TestCase<>(new int[][] {
                        { 0, 1 },
                        { 1, 0 },
                }, -1),
                new TestCase<>(new int[][] {
                        { 0, 1, 0, 1, },
                        { 0, 0, 0, 0 },
                        { 1, 1, 0, 1 },
                        { 1, 1, 1, 0 },
                }, 1),
                new TestCase<>(new int[][] {
                        { 0, 0, 0, 0, },
                        { 0, 0, 0, 0 },
                        { 0, 0, 0, 0 },
                        { 0, 0, 0, 0 },
                }, -1));
    }

    @Solution
    public int brute(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            // check if current person knows anyone from the party
            boolean doesntKnowAnybody = true;
            for (int j : mat[i]) {
                if (j != 0) {
                    doesntKnowAnybody = false;
                    break;
                }
            }
            if (!doesntKnowAnybody) {
                continue;
            }

            // if he doesn't know anybody and no body knows him, then he is celebrity
            // check if everybody knows him
            boolean isCelebrity = true;
            for (int j = 0; j < mat.length; j++) {
                // contine if its the same person
                if (j == i) {
                    continue;
                }

                if (mat[j][i] == 0) {
                    isCelebrity = false;
                    break;
                }
            }
            if (isCelebrity) {
                return i;
            }
        }
        return -1;
    }

    // TODO: complete optimal appraoch for this problem:
    // https://www.youtube.com/watch?v=9u2BJfmWNEg
}
