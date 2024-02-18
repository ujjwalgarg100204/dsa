package com.ujjwal.solutions.softskills.sem6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ujjwal.solutions.softskills.sem6.MinStack.MinStack;
import com.ujjwal.solutions.softskills.sem6.MinStack.MinStackBruteImplementation;

/**
 * MinStackSolutionTest
 */
public class MinStackSolutionTest {

    private MinStack problem;

    @BeforeEach
    void setupStack() {
        problem = new MinStackBruteImplementation();
    }

    @Test
    public void testPushAndTop() {
        problem.push(5);
        assertEquals(5, problem.top());
        problem.push(3);
        assertEquals(3, problem.top());
        problem.push(7);
        assertEquals(7, problem.top());
    }

    @Test
    public void testPop() {
        problem.push(5);
        problem.push(3);
        problem.push(7);
        problem.pop();
        assertEquals(3, problem.top());
        problem.pop();
        assertEquals(5, problem.top());
        problem.pop();
    }

    @Test
    public void testGetMin() {
        problem.push(5);
        assertEquals(5, problem.getMin());
        problem.push(3);
        assertEquals(3, problem.getMin());
        problem.push(7);
        assertEquals(3, problem.getMin());
        problem.pop();
        assertEquals(3, problem.getMin());
        problem.pop();
        assertEquals(5, problem.getMin());
    }
}
