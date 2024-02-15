package com.ujjwal.solutions.softskills.sem6.PriorityQueueUsingDLL;

/**
 * PriorityQueue
 */
public interface PriorityQueue<T> {
    void push(T data, int priority);

    T peek();

    void pop();
}
