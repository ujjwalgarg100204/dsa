package com.ujjwal.solutions.striver_a_to_z_dsa_sheet.datastructures.linkedlist;

public class SLNode<T> {
    public T data;
    public SLNode<T> next;

    public SLNode(T data) {
        this.data = data;
    }

    public SLNode() {
    }

    @Override
    public String toString() {
        return "SLNode [data=" + data + "]";
    }
}
