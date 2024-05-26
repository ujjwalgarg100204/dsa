import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Node {

    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
    }

}

/**
 * MergeSortForDLL
 */
public class MergeSortForDLL {

    public String problemLink() {
        return "https://www.naukri.com/code360/problems/sort-linked-list_920517";
    }

    public Node brute(Node head) {
        // convert linked list to array
        List<Integer> list = new ArrayList<>();
        for (Node temp = head; temp != null; temp = temp.next) {
            list.add(temp.data);
        }

        // sort the array
        Collections.sort(list, (first, second) -> first - second);

        // copy the sorted array back to DLL
        Node temp = head;
        for (int i : list) {
            temp.data = i;
            temp = temp.next;
        }

        return head;
    }

    public static Node optimal(Node head) {
        if (head != null && head.next != null) {
            Node mid = _getMiddleOfDLL(head);

            Node left = head;
            Node right = mid.next;

            // separate two halves
            mid.next = null;

            left = optimal(left);
            right = optimal(right);

            Node newHead = _merge(left, right);

            return newHead;
        }

        return head;
    }

    private static Node _merge(Node left, Node right) {
        Node newHead = new Node(Integer.MAX_VALUE);
        Node tail = newHead;

        while (left != null && right != null) {
            if (left.data < right.data) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }

        if (left != null) {
            tail.next = left;
        } else if (right != null) {
            tail.next = right;
        }

        return newHead.next;
    }

    private static Node _getMiddleOfDLL(Node head) {
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

}
