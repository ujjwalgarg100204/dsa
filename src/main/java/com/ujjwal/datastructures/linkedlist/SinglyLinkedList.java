package com.ujjwal.datastructures.linkedlist;

import java.util.Iterator;

/**
 * SinglyLinkedList
 */
public class SinglyLinkedList {

    public static <T> SLNode<T> toLL(Iterable<T> iterable) {
        Iterator<T> iterator = iterable.iterator();
        if (!iterator.hasNext())
            return null;

        SLNode<T> head = new SLNode<>(iterator.next());
        if (!iterator.hasNext())
            return head;

        // create tail pointer for easy addition ll
        SLNode<T> tail = new SLNode<>(iterator.next());

        // set head's next ptr to its tail
        head.next = tail;

        while (iterator.hasNext()) {
            tail.next = new SLNode<>(iterator.next());
        }

        return head;
    }

    /**
     * @param <T>
     * @param iterable data to be added to the linked listj
     * @param x        position of the node where the last node's next pointer will
     *                 point to (1 - indexed)
     * @return looped linked list
     */
    public static <T> SLNode<T> toLoopedLL(Iterable<T> iterable, int x) {
        SLNode<T> head = toLL(iterable);

        // get tail ptr
        SLNode<T> tail = null;
        for (SLNode<T> node = head; node.next != null; node = node.next) {
            tail = node;
        }

        // get xth node
        SLNode<T> xthNode = head;
        for (int i = 1; i < x; i++) {
            xthNode = xthNode.next;
        }

        // set tail's next ptr to xth node
        tail.next = xthNode;

        return head;
    }

    public static String toString(SLNode<?> head) {
        StringBuilder sb = new StringBuilder();
        for (SLNode<?> node = head; node != null; node = node.next) {
            sb.append(node.data).append(" -> ");
        }
        sb.append("null");
        return sb.toString();
    }
}
