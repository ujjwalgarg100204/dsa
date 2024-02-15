package com.ujjwal.solutions.softskills.sem6.PriorityQueueUsingDLL;

import java.util.NoSuchElementException;

/**
 * PriorityQueueBruteImplementation
 */
public class PriorityQueueBruteImplementation<T> implements PriorityQueue<T> {
    private PQNode<T> head;

    public PriorityQueueBruteImplementation() {
        head = null;
    }

    public PriorityQueueBruteImplementation(T data, int priority) {
        head = new PQNode<>(data, priority);
    }

    @Override
    public void push(T data, int priority) {
        // if queue is empty then simply add and return
        if (head == null) {
            head = new PQNode<>(data, priority);
            return;
        }

        // node with largest priority stays at the head of the node
        PQNode<T> parent = head;
        while (parent.next != null && parent.priority <= priority) {
            parent = parent.next;
        }

        // add the new node in place of position node
        PQNode<T> newNode = new PQNode<>(data, priority);
        if (parent.priority <= priority) {
            // if new node has to be put at the end of linkedlist
            parent.next = newNode;
            newNode.prev = parent;
        } else {
            // add newNode in place of parent node
            newNode.next = parent;
            if (parent != head) {
                newNode.prev = parent.prev;
                parent.prev.next = newNode;
                parent.prev = newNode;
            } else {
                parent.prev = newNode;
                head = newNode;
            }
        }
    }

    @Override
    public T peek() {
        return head == null ? null : head.data;
    }

    @Override
    public void pop() {
        if (head == null) {
            throw new NoSuchElementException("Can't pop from an empty queue");
        }

        if (head.next == null) {
            // for single node or no node
            head = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (PQNode<T> node = head; node != null; node = node.next) {
            sb.append(String.format("d=%d,p=%d", node.data, node.priority)).append(" -> ");
        }
        sb.append("null");
        sb.append("}");
        return sb.toString();
    }
}
