package codes.college.softskills.sem6;

import java.util.HashSet;
import java.util.Set;

class ListNode {
    final int val;
    final ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

/**
 * LoopDetectionInSLL
 */
public class LoopDetectionInSLL {

    public String problemLink() {
        return "https://leetcode.com/problems/linked-list-cycle";
    }

    public boolean bruteHasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        for (ListNode i = head; i != null; i = i.next) {
            if (set.contains(i)) {
                return true;
            }

            set.add(i);
        }

        return false;
    }

    public boolean optimalHasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

}
