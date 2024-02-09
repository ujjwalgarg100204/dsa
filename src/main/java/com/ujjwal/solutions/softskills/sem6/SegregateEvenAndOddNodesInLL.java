package com.ujjwal.solutions.softskills.sem6;

import java.util.ArrayList;
import java.util.List;

import com.ujjwal.annotations.Solution;
import com.ujjwal.datastructures.linkedlist.SLNode;
import com.ujjwal.datastructures.linkedlist.SinglyLinkedList;
import com.ujjwal.models.DSAProblem;
import com.ujjwal.models.TestCase;

/**
 * SegregateEvenAndOddNodesInLL
 */
public class SegregateEvenAndOddNodesInLL extends DSAProblem<SLNode<Integer>, SLNode<Integer>> {

    @Override
    public String getProblemLink() {
        return "https://www.geeksforgeeks.org/problems/segregate-even-and-odd-nodes-in-a-linked-list5035/1";
    }

    @Override
    public List<TestCase<SLNode<Integer>, SLNode<Integer>>> getTestCases() {
        return List.of(
                new TestCase<>(
                        SinglyLinkedList.toLL(List.of(17, 15, 8, 12, 10, 5, 4, 1, 7, 6)),
                        SinglyLinkedList.toLL(List.of(8, 12, 10, 4, 6, 17, 15, 5, 1, 7))),
                new TestCase<>(
                        SinglyLinkedList.toLL(List.of(8, 12, 10, 5, 4, 1, 6)),
                        SinglyLinkedList.toLL(List.of(8, 12, 10, 4, 6, 5, 1))),
                new TestCase<>(
                        SinglyLinkedList.toLL(List.of(8, 12, 10)),
                        SinglyLinkedList.toLL(List.of(8, 12, 10))),
                new TestCase<>(
                        SinglyLinkedList.toLL(List.of(1, 3, 5, 7)),
                        SinglyLinkedList.toLL(List.of(1, 3, 5, 7))));
    }

    @Solution
    public SLNode<Integer> brute(SLNode<Integer> head) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        // segretate numbers into even and odd
        for (SLNode<Integer> i = head; i != null; i = i.next) {
            if (i.data % 2 == 0)
                even.add(i.data);
            else
                odd.add(i.data);
        }

        // copy elements back to list
        int e = 0, o = 0;
        for (SLNode<Integer> i = head; i != null; i = i.next) {
            if (e >= even.size()) {
                i.data = odd.get(o);
                o++;
            } else {
                i.data = even.get(e);
                e++;
            }
        }

        return head;
    }

    @Solution
    public SLNode<Integer> optimal(SLNode<Integer> head) {
        // this approach creates two linkedlist one of odd, and other of even, then we
        // just link them together at the end
        SLNode<Integer> evenHead = null;
        SLNode<Integer> evenTail = null;
        SLNode<Integer> oddHead = null;
        SLNode<Integer> oddTail = null;

        for (SLNode<Integer> i = head; i != null; i = i.next) {
            if (i.data % 2 == 0) {
                // append to even LL
                if (evenHead == null) {
                    evenHead = i;
                    evenTail = i;
                } else {
                    evenTail.next = i;
                    evenTail = evenTail.next;
                }
            } else {
                // append to odd LL
                if (oddHead == null) {
                    oddHead = i;
                    oddTail = i;
                } else {
                    oddTail.next = i;
                    oddTail = oddTail.next;
                }
            }
        }

        if (evenTail != null)
            evenTail.next = oddHead;

        if (oddTail != null)
            oddTail.next = null;

        return evenHead == null ? oddHead : evenHead;
    }
}
