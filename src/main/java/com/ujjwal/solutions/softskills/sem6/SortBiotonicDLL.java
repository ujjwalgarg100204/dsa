package com.ujjwal.solutions.softskills.sem6;

import java.util.ArrayList;
import java.util.List;

import com.ujjwal.annotations.Solution;
import com.ujjwal.datastructures.linkedlist.DLNode;
import com.ujjwal.datastructures.linkedlist.DoublyLinkedList;
import com.ujjwal.models.DSAProblem;
import com.ujjwal.models.TestCase;

/**
 * SortBiotonicDLL
 */
public class SortBiotonicDLL extends DSAProblem<DLNode<Integer>, DLNode<Integer>> {

    @Override
    public String getProblemLink() {
        return "https://www.geeksforgeeks.org/sort-biotonic-doubly-linked-list/";
    }

    @Override
    public List<TestCase<DLNode<Integer>, DLNode<Integer>>> getTestCases() {
        return List.of(
                new TestCase<>(
                        DoublyLinkedList.toDLL(List.of(2, 5, 7, 12, 10, 6, 4, 1)),
                        DoublyLinkedList.toDLL(List.of(1, 2, 4, 5, 6, 7, 10, 12))),
                new TestCase<>(
                        DoublyLinkedList.toDLL(List.of(10, 12, 13, 9, 5)),
                        DoublyLinkedList.toDLL(List.of(5, 9, 10, 12, 13))));
    }

    @Solution
    public DLNode<Integer> brute(DLNode<Integer> head) {
        // simply add all elements of DLL to array and sort
        List<Integer> list = new ArrayList<>();
        for (DLNode<Integer> i = head; i != null; i = i.next) {
            list.add(i.data);
        }

        // sort list
        list.sort(Integer::compare);

        // compare back to linked list
        return DoublyLinkedList.toDLL(list);
    }

    @Solution
    public DLNode<Integer> tryingBubbleSort(DLNode<Integer> head) {
        boolean isSorted = false;
        for (DLNode<Integer> i = head; i != null; i = i.next) {
            if (isSorted)
                break;

            for (DLNode<Integer> j = head; j.next != null; j = j.next) {
                if (j.data > j.next.data) {
                    // swap the data values
                    int temp = j.data;
                    j.data = j.next.data;
                    j.next.data = temp;
                }
            }
        }
        return head;
    }

    @Solution
    public DLNode<Integer> optimal(DLNode<Integer> head) {
        DLNode<Integer> start = head, end = head;

        // make end pointer point to end of linked list
        while (end.next != null) {
            end = end.next;
        }

        // create a new head which points to smallest number in DLL
        DLNode<Integer> newHead = null;
        if (end.data < start.data) {
            newHead = end;
            end = end.prev;

            // make end the last node
            end.next = null;
        } else {
            newHead = start;
            start = start.next;

            // make start the first node
            start.prev = null;
        }

        // make all newHead ptrs point to nothing
        newHead.next = null;
        newHead.prev = null;

        DLNode<Integer> newTail = newHead;

        while (start != end) {
            DLNode<Integer> temp;

            // choose the next node smaller among the avl
            if (start.data < end.data) {
                // save ref to curr start node
                temp = start;
                // iterate further
                start = start.next;
                // break connection to prev node
                start.prev = null;
                // add new node at the end of new DLL & update newTail
                newTail.next = temp;
                temp.prev = newTail;
                temp.next = null;
                newTail = temp;
            } else {
                // save a ref to end.prev
                temp = end;
                // iterate further back
                end = end.prev;
                // break connection to prev node
                end.next = null;
                // add new node at the end of new DLL & update newTail
                newTail.next = temp;
                temp.prev = newTail;
                temp.next = null;
                newTail = temp;
            }
        }

        // add last node to new DLL
        newTail.next = start;
        start.prev = newTail;
        start.next = null;

        return newHead;
    }
}
