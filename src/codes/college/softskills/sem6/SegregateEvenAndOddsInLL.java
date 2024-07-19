package codes.college.softskills.sem6;

import java.util.ArrayList;
import java.util.List;

class Node {
    int data;
    Node next;

    Node() {
        data = Integer.MAX_VALUE;
        next = null;
    }
}

/**
 * SegregateEvenAndOddsInLL
 */
public class SegregateEvenAndOddsInLL {

    public String problemLink() {
        return "https://www.geeksforgeeks.org/problems/segregate-even-and-odd-nodes-in-a-linked-list5035/1";
    }

    public Node brute(int n, Node head) {
        // segregate even and odds in two list
        List<Integer> odds = new ArrayList<>(n / 2);
        List<Integer> evens = new ArrayList<>(n / 2);

        for (Node i = head; i != null; i = i.next) {
            if ((i.data & 1) == 0) {
                evens.add(i.data);
            } else {
                odds.add(i.data);
            }
        }

        // recreate LL with above two list
        Node tail = head;
        for (int i : evens) {
            tail.data = i;
            tail = tail.next;
        }
        for (int i : odds) {
            tail.data = i;
            tail = tail.next;
        }

        return head;
    }

    public Node optimal(int n, Node head) {
        // create odds and evens linked list
        Node odds = new Node();
        Node oddsTail = odds;
        Node evens = new Node();
        Node evensTail = evens;

        for (Node i = head; i != null; i = i.next) {
            if ((i.data & 1) == 0) {
                evensTail.next = i;
                evensTail = evensTail.next;
            } else {
                oddsTail.next = i;
                oddsTail = oddsTail.next;
            }
        }

        // clean last value of the linked list
        evensTail.next = null;
        oddsTail.next = null;

        // append the odds ll to even ll and return even ll head
        // remember odds first node is dummy node
        evensTail.next = odds.next;

        // remember evens first node is dummy node
        return evens.next;
    }

}
