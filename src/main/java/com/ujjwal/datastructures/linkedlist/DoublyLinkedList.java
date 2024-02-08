package com.ujjwal.datastructures.linkedlist;

import java.util.Iterator;

/**
 * DoublyLinkedList
 */
public class DoublyLinkedList {

    /**
     * @param <T>
     * @param iterable data to be added to the linked list
     * @return doubly linked list head node
     */
    public static <T> DLNode<T> toDLL(Iterable<T> iterable) {
        Iterator<T> iterator = iterable.iterator();
        DLNode<T> head = new DLNode<T>(iterator.next());
        DLNode<T> tail = head;

        while (iterator.hasNext()) {
            tail.next = new DLNode<T>(iterator.next());
            tail.next.prev = tail;
            tail = tail.next;
        }

        return head;
    }

    public static String toString(DLNode<?> head) {
        StringBuilder sb = new StringBuilder();
        for (DLNode<?> node = head; node != null; node = node.next) {
            sb.append(node.data).append(" -> ");
        }
        sb.append("null");
        return sb.toString();
    }
}
