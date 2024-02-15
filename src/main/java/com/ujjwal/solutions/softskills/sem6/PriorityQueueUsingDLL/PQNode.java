package com.ujjwal.solutions.softskills.sem6.PriorityQueueUsingDLL;

import com.ujjwal.datastructures.linkedlist.DLNode;

/**
 * PQNode
 */
public class PQNode<T> extends DLNode<T> {
    public int priority;
    public PQNode<T> next;
    public PQNode<T> prev;

    public PQNode(T data, int priority) {
        super(data);
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "{priority=" + priority + ", data=" + data + ", next= " + (next == null ? null : next.hashCode())
                + ", prev=" + (prev == null ? null : prev.hashCode()) + "}";
    }
}
