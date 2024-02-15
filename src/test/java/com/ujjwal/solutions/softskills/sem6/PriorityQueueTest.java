package com.ujjwal.solutions.softskills.sem6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ujjwal.solutions.softskills.sem6.PriorityQueueUsingDLL.PriorityQueue;
import com.ujjwal.solutions.softskills.sem6.PriorityQueueUsingDLL.PriorityQueueBruteImplementation;

/**
 * PriorityQueueTest
 */
public class PriorityQueueTest {
    private PriorityQueue<Integer> pq;

    @BeforeEach
    void setUp() {
        // Initialize your PriorityQueue implementation before each test
        pq = new PriorityQueueBruteImplementation<>();
    }

    @Test
    @DisplayName("Push elements and check peek")
    void pushAndPeekTest() {
        pq.push(5, 2);
        pq.push(10, 1);
        pq.push(7, 3);
        assertEquals(10, pq.peek());
    }

    @Test
    @DisplayName("Push elements and check pop")
    void pushAndPopTest() {
        pq.push(5, 2);
        pq.push(10, 1);
        pq.push(7, 3);
        pq.pop();
        assertEquals(5, pq.peek());
    }

    @Test
    @DisplayName("Push elements with same priority and check order")
    void pushSamePriorityTest() {
        pq.push(5, 2);
        pq.push(10, 2);
        pq.push(7, 2);
        assertEquals(5, pq.peek());
        pq.pop();
        assertEquals(10, pq.peek());
    }

    @Test
    @DisplayName("Push elements with different priorities and check order")
    void pushDifferentPriorityTest() {
        pq.push(5, 2);
        pq.push(10, 1);
        pq.push(7, 3);
        assertEquals(10, pq.peek());
        pq.pop();
        assertEquals(5, pq.peek());
    }

    @Test
    @DisplayName("Pop from empty queue")
    void popEmptyQueueTest() {
        assertThrows(NoSuchElementException.class, () -> pq.pop());
    }

    @Test
    @DisplayName("Peek from empty queue")
    void peekEmptyQueueTest() {
        assertNull(pq.peek());
    }
}
