package codes.leetcode.mediumproblems;

import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

/*
 * OddEvenLinkedList
 */
public class OddEvenLinkedList {

    public String problemLink() {
        return "https://leetcode.com/problems/odd-even-linked-list";
    }

    public ListNode bruteOddEvenList(ListNode head) {
        // segregate even and odds in two list
        List<Integer> odds = new ArrayList<>();
        List<Integer> evens = new ArrayList<>();

        int j = 1;
        for (ListNode i = head; i != null; i = i.next, j++) {
            if ((j & 1) == 0) {
                evens.add(i.val);
            } else {
                odds.add(i.val);
            }
        }

        // recreate LL with above two list
        ListNode tail = head;
        for (int i : odds) {
            tail.val = i;
            tail = tail.next;
        }
        for (int i : evens) {
            tail.val = i;
            tail = tail.next;
        }

        return head;
    }

    public ListNode optimal(ListNode head) {
        // create odds and evens linked list
        ListNode odds = new ListNode(Integer.MAX_VALUE);
        ListNode oddsTail = odds;
        ListNode evens = new ListNode(Integer.MAX_VALUE);
        ListNode evensTail = evens;

        boolean isEven = false;
        for (ListNode i = head; i != null; i = i.next) {
            if (isEven) {
                evensTail.next = i;
                evensTail = evensTail.next;
            } else {
                oddsTail.next = i;
                oddsTail = oddsTail.next;
            }
            isEven = !isEven;
        }

        // clean last value of the linked list
        evensTail.next = null;
        oddsTail.next = null;

        // append the evens ll to odd ll and return even ll head
        // remember odds first node is dummy node
        oddsTail.next = evens.next;

        // remember evens first node is dummy node
        return odds.next;
    }
}
