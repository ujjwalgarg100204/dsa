import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ListNode {

    int val;
    ListNode next;
    ListNode prev;

    public ListNode(int val) {
        this.val = val;
    }

}

/**
 * SortBitonicDLL
 */
public class SortBitonicDLL {

    public String problemLink() {
        return "https://www.geeksforgeeks.org/sort-the-biotonic-doubly-linked-list-set-2";
    }

    public ListNode brute(ListNode head) {
        // create an array from linked list
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        // sort the array
        Collections.sort(list);

        // recrete the linked list
        ListNode newHead = new ListNode(list.get(0));
        ListNode tail = newHead;
        for (int i = 1; i < list.size(); i++) {
            tail.next = new ListNode(list.get(i));
            tail = tail.next;
        }

        return newHead;
    }

    /**
     * This approach finds the pivot point of the linked list and reverses
     * the second half (decreasing order). It then merges both the linekd list
     * and returns the head after merging.
     * Time: O(n)
     * Space: O(1)
     * 
     * @param head
     * @return
     */
    public ListNode better(ListNode head) {
        // find the pivot point
        ListNode pivot = null;
        for (ListNode i = head; i.next != null; i = i.next) {
            if (i.val > i.next.val) {
                pivot = i;
            }
        }

        // no pivot means that the list is strictly increasing
        if (pivot == null) {
            return head;
        }

        // separate the two linked list
        pivot.prev.next = null;
        pivot.prev = null;

        // reverse the second pivot linked list
        pivot = reverseLL(pivot);

        // merge both linked list
        ListNode newHead = new ListNode(Integer.MAX_VALUE);
        ListNode tail = newHead;

        ListNode i = head;
        ListNode j = pivot;
        while (i != null && j != null) {
            if (i.val < j.val) {
                tail.next = i;
                i = i.next;
            } else {
                tail.next = j;
                j = j.next;
            }
            tail.next.prev = tail;
            tail = tail.next;
        }

        // append the reset of the linked list at the end
        if (j != null) {
            tail.next = j;
            tail.next.prev = tail;
        } else if (i != null) {
            tail.next = i;
            tail.next.prev = tail;
        }

        // remember first node is dummy node
        return newHead.next;
    }

    private ListNode reverseLL(ListNode head) {
        ListNode prev = head.prev;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            current.prev = next;
            prev = current;

            current = next;
        }
        head = prev;

        return head;
    }

    public ListNode alternativeOptimal(ListNode head) {
        // find last of the linked list and keep checking if the list is strictly
        // increasing
        ListNode last = head;
        boolean isIncreasing = false;
        while (last.next != null) {
            isIncreasing = last.val < last.next.val;
            last = last.next;
        }

        // list is strictly increasing
        if (isIncreasing) {
            return head;
        }

        ListNode newHead = new ListNode(Integer.MAX_VALUE);
        while (head != last) {
            if (head.val < last.val) {
                newHead.next = head;
                head = head.next;
            } else {
                newHead.next = last;
                last = last.prev;
            }

            // keep the integrity of DLL
            newHead.next.prev = newHead;
            newHead.next.next = null;
        }

        newHead.next = head;
        newHead.next.prev = newHead;
        newHead.next.next = null;

        // remember first node is dummy
        return newHead.next;
    }

}
