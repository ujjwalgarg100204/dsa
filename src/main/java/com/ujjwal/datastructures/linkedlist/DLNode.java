package com.ujjwal.datastructures.linkedlist;

/**
 * DLNode
 */
public class DLNode<T> {
    public T data;
    public DLNode<T> next;
    public DLNode<T> prev;

    public DLNode(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public DLNode() {
        this.data = null;
        this.next = null;
        this.prev = null;
    }

    @Override
    public String toString() {
        return "DLNode [data=" + data + ", next=" + next.data + ", prev=" + prev.data + "]";
    }
}
