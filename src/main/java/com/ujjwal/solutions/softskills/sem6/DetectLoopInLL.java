package com.ujjwal.solutions.softskills.sem6;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ujjwal.annotations.Solution;
import com.ujjwal.datastructures.linkedlist.SLNode;
import com.ujjwal.datastructures.linkedlist.SinglyLinkedList;
import com.ujjwal.models.DSAProblem;
import com.ujjwal.models.TestCase;

/**
 * DetectLoopInLL
 */
public class DetectLoopInLL extends DSAProblem<SLNode<Integer>, Boolean> {

    @Override
    public String getProblemLink() {
        return "https://www.geeksforgeeks.org/problems/detect-loop-in-linked-list/1";
    }

    @Override
    public List<TestCase<SLNode<Integer>, Boolean>> getTestCases() {
        return List.of(
                new TestCase<>(SinglyLinkedList.toLL(List.of(1, 2, 3, 4, 5)), false),
                new TestCase<>(SinglyLinkedList.toLoopedLL(List.of(1, 3, 4), 2), true),
                new TestCase<>(SinglyLinkedList.toLL(List.of(1, 8, 3, 4)), false));
    }

    @Solution
    public boolean better(SLNode<Integer> head) {
        Set<SLNode<Integer>> set = new HashSet<>();
        for (SLNode<Integer> node = head; node != null; node = node.next) {
            if (set.contains(node))
                return true;
            set.add(node);
        }

        return false;
    }

    @Solution
    public boolean optimal(SLNode<Integer> head) {
        SLNode<Integer> slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            }

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
