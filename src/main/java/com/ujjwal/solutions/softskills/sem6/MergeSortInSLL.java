package com.ujjwal.solutions.softskills.sem6;

import java.util.ArrayList;
import java.util.List;

import com.ujjwal.annotations.Solution;
import com.ujjwal.datastructures.linkedlist.SLNode;
import com.ujjwal.datastructures.linkedlist.SinglyLinkedList;
import com.ujjwal.models.DSAProblem;
import com.ujjwal.models.TestCase;

/**
 * MergeSortInSLL
 */
public class MergeSortInSLL extends DSAProblem<SLNode<Integer>, SLNode<Integer>> {

    @Override
    public String getProblemLink() {
        return "https://leetcode.com/problems/sort-list/description";
    }

    @Override
    public List<TestCase<SLNode<Integer>, SLNode<Integer>>> getTestCases() {
        return List.of(
                new TestCase<>(
                        SinglyLinkedList.toLL(List.of(11, 15, 26, 38, 9, 10)),
                        SinglyLinkedList.toLL(List.of(9, 10, 11, 15, 26, 38))),
                new TestCase<>(
                        SinglyLinkedList.toLL(List.of(10, 1, 90, 107, 5)),
                        SinglyLinkedList.toLL(List.of(1, 5, 10, 90, 107))));
    }

    @Solution
    public SLNode<Integer> brute(SLNode<Integer> head) {
        // create array from LL and sort that, then convert it back to LL
        List<Integer> arr = new ArrayList<>();
        for (SLNode<Integer> i = head; i != null; i = i.next) {
            arr.add(i.data);
        }

        // sort array
        arr.sort(Integer::compare);

        // re-create list
        SLNode<Integer> node = head;
        for (int i : arr) {
            node.data = i;
            node = node.next;
        }

        return head;
    }

    @Solution
    public SLNode<Integer> optimal(SLNode<Integer> head) {
        if (head == null || head.next == null) {
            // if no element left or only one element in linkedlist then return
            return head;
        }

        // divide the list in two halves
        SLNode<Integer> middle = findMiddle(head);
        SLNode<Integer> right = middle.next;
        middle.next = null;
        SLNode<Integer> left = head;

        // sort left and right halves of list
        left = optimal(left);
        right = optimal(right);

        return mergeSortedLists(left, right);
    }

    private static SLNode<Integer> mergeSortedLists(SLNode<Integer> head1, SLNode<Integer> head2) {
        SLNode<Integer> newHead = new SLNode<>(-1);
        SLNode<Integer> newTail = newHead;

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                newTail.next = head1;
                head1 = head1.next;
            } else {
                newTail.next = head2;
                head2 = head2.next;
            }
            newTail = newTail.next;
        }

        if (head1 != null)
            newTail.next = head1;
        else if (head2 != null)
            newTail.next = head2;

        return newHead.next;
    }

    private static SLNode<Integer> findMiddle(SLNode<Integer> head) {
        SLNode<Integer> slow = head;
        // change made in order to return first middle in case of two middles
        SLNode<Integer> fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

}
