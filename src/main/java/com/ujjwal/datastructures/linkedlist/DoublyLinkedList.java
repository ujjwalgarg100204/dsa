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

    public static <T extends Comparable<T>> int compare(DLNode<T> head1, DLNode<T> head2) {
        DLNode<T> temp1 = head1, temp2 = head2;

        while (temp1 != null && temp2 != null) {
            if (temp1.data.compareTo(temp2.data) != 0) {
                return temp1.data.compareTo(temp2.data);
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        if (temp1 != null || temp2 != null) {
            return temp1 != null ? 1 : -1;
        }

        return 0;
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
